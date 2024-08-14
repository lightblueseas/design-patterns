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
import java.util.List;

/**
 * The interface {@link Room} represents a chat room in which users can participate It provides
 * methods to retrieve the list of users in the chat room, the history of messages sent in the room,
 * and to check whether the room is secure
 *
 * @param <M>
 *            the generic type representing the messages that can be sent in the room
 */
public interface Room<M extends Message<?>> extends Serializable
{

	/**
	 * Gets the list of users in the chat room
	 *
	 * @return the list of users in the chat room
	 */
	List<IUser<?>> getChatRoomUsers();

	/**
	 * Gets the history of messages sent in the chat room
	 *
	 * @return the list of messages sent in the chat room
	 */
	List<M> getMessageHistory();

	/**
	 * Checks if the chat room is secure
	 *
	 * @return true if the chat room is secure, otherwise false
	 */
	boolean isSecure();
}
