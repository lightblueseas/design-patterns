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
package de.alpharogroup.design.pattern.observer.event;

import java.util.Collection;

/**
 * The Interface EventSource.
 *
 * @param <T>
 *            the generic type
 */
public interface EventSource<T>
{

	/**
	 * Adds the given event listener to the eventListeners list.
	 *
	 * @param eventListener
	 *            the event listener
	 */
	void add(final EventListener<T> eventListener);

	/**
	 * Adds the all given event listeners to the eventListeners list.
	 *
	 * @param eventListeners
	 *            the event listeners
	 */
	void addAll(final Collection<EventListener<T>> eventListeners);

	/**
	 * Fire the given event.
	 *
	 * @param source
	 *            the source
	 */
	void fireEvent(final T source);

	/**
	 * Removes the given event listener from the eventListeners list.
	 *
	 * @param eventListener
	 *            the event listener
	 */
	void remove(final EventListener<T> eventListener);

	/**
	 * Removes the all given event listeners from the eventListeners list.
	 *
	 * @param eventListeners
	 *            the event listeners
	 */
	void removeAll(final Collection<EventListener<T>> eventListeners);

}