/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.design.pattern.observer.chat;

import java.io.Serializable;

import io.github.astrapi69.design.pattern.observer.api.ActionCommand;
import io.github.astrapi69.design.pattern.observer.api.Observer;

/**
 * The class {@link ChatRoomUser} represents a user in a chat room who can send and receive messages
 * This class implements {@link Observer} to observe messages in the chat room,
 * {@link ActionCommand} to define actions when a message is received, and {@link Serializable} for
 * serialization support
 *
 * @param <M>
 *            the generic type of the message that will be sent and observed in the chat room
 */
public abstract class ChatRoomUser<M extends Message<?>>
	implements
		Observer<M>,
		ActionCommand,
		Serializable
{

	/** The Constant serialVersionUID for serialization compatibility */
	private static final long serialVersionUID = 1L;

	/** The user associated with this chat room user */
	private final IUser<?> user;

	/** The chat room (subject) that this user is part of */
	protected ChatRoom<M> subject;

	/** The observable message currently observed by this user */
	private M observable;

	/**
	 * Instantiates a new chat room user
	 *
	 * @param room
	 *            the chat room (subject) that this user is part of
	 * @param user
	 *            the user associated with this chat room user
	 */
	public ChatRoomUser(final ChatRoom<M> room, final IUser<?> user)
	{
		this.subject = room;
		this.observable = this.subject.getObservable();
		this.user = user;
		this.subject.add(this);
	}

	/**
	 * Gets the observable message currently observed by this user
	 *
	 * @return the observable message
	 */
	public synchronized M getObservable()
	{
		return observable;
	}

	/**
	 * Gets the user associated with this chat room user
	 *
	 * @return the user
	 */
	public IUser<?> getUser()
	{
		return user;
	}

	/**
	 * Sends the given message to the chat room
	 *
	 * @param message
	 *            the message to be sent
	 */
	public void send(final M message)
	{
		subject.setObservable(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void update(final M observable)
	{
		this.observable = observable;
		execute();
	}

}
