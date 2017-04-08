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
package de.alpharogroup.design.pattern.observer.chat;

import java.io.Serializable;

import de.alpharogroup.design.pattern.observer.api.ActionCommand;
import de.alpharogroup.design.pattern.observer.api.Observer;

/**
 * The class {@link ChatRoomUser}.
 *
 * @param <M> the generic type
 */
public abstract class ChatRoomUser<M extends Message<?>>
	implements
		Observer<M>,
		ActionCommand,
		Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The subject. */
	protected ChatRoom<M> subject;

	/** The observable. */
	private M observable;

	/** The user. */
	private final IUser<?> user;

	/**
	 * Instantiates a new chat room user.
	 *
	 * @param room the room
	 * @param user the user
	 */
	public ChatRoomUser(final ChatRoom<M> room, final IUser<?> user)
	{
		this.subject = room;
		this.observable = this.subject.getObservable();
		this.user = user;
		this.subject.add(this);
	}

	/**
	 * Gets the observable object.
	 *
	 * @return the observable
	 */
	public synchronized M getObservable()
	{
		return observable;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public IUser<?> getUser()
	{
		return user;
	}

	/**
	 * Send the given message.
	 *
	 * @param message the message
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
