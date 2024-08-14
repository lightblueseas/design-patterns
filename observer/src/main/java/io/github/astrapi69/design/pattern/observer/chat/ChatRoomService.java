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
import java.util.HashMap;
import java.util.Map;

/**
 * The class {@link ChatRoomService} manages the creation and retrieval of chat rooms It provides a
 * way to obtain a {@link ChatRoom} based on an observable message and a room name
 *
 * @param <M>
 *            the generic type of the message that will be sent in the chat rooms
 */
public class ChatRoomService<M extends Message<?>> implements Serializable
{

	/** The Constant serialVersionUID for serialization compatibility */
	private static final long serialVersionUID = 1L;

	/** A map of chat room names to their corresponding {@link ChatRoom} instances */
	private final Map<String, ChatRoom<M>> chatRooms = new HashMap<>();

	/**
	 * Gets the chat room with the specified name If the chat room does not exist, a new one is
	 * created with the given observable message and name
	 *
	 * @param observable
	 *            the observable message for the chat room
	 * @param name
	 *            the name of the chat room
	 * @return the chat room associated with the given name
	 */
	public ChatRoom<M> getChatRoom(final M observable, final String name)
	{
		ChatRoom<M> room = chatRooms.get(name);
		if (room == null)
		{
			room = new ChatRoom<>(observable, name);
			chatRooms.put(name, room);
		}
		return room;
	}
}
