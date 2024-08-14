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
package io.github.astrapi69.design.pattern.observer.chat.listener;

import java.util.Collection;

/**
 * The Interface {@link MessageSource} represents a source that can send messages to registered
 * listeners It provides methods for adding, removing, and notifying {@link MessageListener} objects
 *
 * @param <T>
 *            the generic type of the message object
 */
public interface MessageSource<T>
{

	/**
	 * Adds the given {@link MessageListener} to the list of listeners that will receive messages
	 *
	 * @param messageListener
	 *            the {@link MessageListener} to be added
	 */
	void add(final MessageListener<T> messageListener);

	/**
	 * Adds all the given {@link MessageListener} objects to the list of listeners that will receive
	 * messages
	 *
	 * @param messageListeners
	 *            the collection of {@link MessageListener} objects to be added
	 */
	void addAll(final Collection<MessageListener<T>> messageListeners);

	/**
	 * Fires a message to all registered listeners with the given source object
	 *
	 * @param source
	 *            the message source object to be sent to listeners
	 */
	void fireMessage(final T source);

	/**
	 * Removes the given {@link MessageListener} from the list of listeners that receive messages
	 *
	 * @param messageListener
	 *            the {@link MessageListener} to be removed
	 */
	void remove(final MessageListener<T> messageListener);

	/**
	 * Removes all the given {@link MessageListener} objects from the list of listeners that receive
	 * messages
	 *
	 * @param messageListeners
	 *            the collection of {@link MessageListener} objects to be removed
	 */
	void removeAll(final Collection<MessageListener<T>> messageListeners);

}
