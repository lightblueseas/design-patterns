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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.github.astrapi69.design.pattern.observer.AbstractSubject;
import io.github.astrapi69.design.pattern.observer.api.Subject;

/**
 * The Class ChatRoom.
 *
 * @param <M>
 *            the generic type of the Message that will be send in this chat room.
 */
public class ChatRoom<M extends Message<?>> extends AbstractSubject<M, ChatRoomUser<M>>
	implements
		Subject<M, ChatRoomUser<M>>,
		Room<M>,
		Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The observers. */
	private final List<ChatRoomUser<M>> observers;
	private final List<M> messageHistory = new ArrayList<>();
	/** The name of the chat room. */
	private final String name;
	/** The observable object. */
	private M observable;

	/**
	 * Initialize block.
	 **/
	{
		observers = new ArrayList<>();
	}

	/**
	 * Constructor for a new subject with an observable.
	 *
	 * @param observable
	 *            the observable
	 * @param name
	 *            the name
	 */
	public ChatRoom(final M observable, final String name)
	{
		this.observable = observable;
		this.name = name;
	}

	/**
	 * Constructor for a new chat room with the given name.
	 *
	 * @param name
	 *            the name of the chat room
	 */
	public ChatRoom(final String name)
	{
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void add(final ChatRoomUser<M> observer)
	{
		observers.add(observer);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAll(final Collection<ChatRoomUser<M>> observers)
	{
		for (final ChatRoomUser<M> chatUser : observers)
		{
			add(chatUser);
		}
	}

	/**
	 * Gets the chat room users as User objects.
	 *
	 * @return the chat room users
	 */
	@Override
	public List<IUser<?>> getChatRoomUsers()
	{
		final List<IUser<?>> chatRoomUsers = new ArrayList<>();
		for (final ChatRoomUser<M> chatUser : observers)
		{
			chatRoomUsers.add(chatUser.getUser());
		}
		return chatRoomUsers;
	}

	@Override
	public List<M> getMessageHistory()
	{
		return messageHistory;
	}

	/**
	 * Gets the name of the chat room.
	 *
	 * @return the name of the chat room.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized M getObservable()
	{
		return observable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void setObservable(final M observable)
	{
		this.observable = observable;
		messageHistory.add(observable);
		updateObservers();
	}

	@Override
	public boolean isSecure()
	{
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void remove(final ChatRoomUser<M> observer)
	{
		final int index = this.observers.indexOf(observer);
		if (0 <= index)
		{
			this.observers.remove(observer);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAll(final Collection<ChatRoomUser<M>> observers)
	{
		for (final ChatRoomUser<M> chatUser : observers)
		{
			remove(chatUser);
		}
	}

	/**
	 * Returns the number of chat users in this chat room.
	 *
	 * @return the number of chat users in this chat room.
	 */
	public int size()
	{
		return this.observers.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void updateObservers()
	{
		for (final ChatRoomUser<M> observer : this.observers)
		{
			observer.update(observable);
		}
	}

}
