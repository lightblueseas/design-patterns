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
package io.github.astrapi69.design.pattern.observer.event;

import java.util.Collection;

/**
 * The interface {@link EventSource} represents a source of events It provides methods to manage
 * event listeners and to fire events to those listeners
 *
 * @param <T>
 *            the generic type of the source object
 */
public interface EventSource<T>
{

	/**
	 * Adds the given event listener to the list of event listeners
	 *
	 * @param eventListener
	 *            the event listener to be added
	 */
	void add(final EventListener<T> eventListener);

	/**
	 * Adds all the given event listeners to the list of event listeners
	 *
	 * @param eventListeners
	 *            the collection of event listeners to be added
	 */
	void addAll(final Collection<EventListener<T>> eventListeners);

	/**
	 * Fires an event to all registered listeners with the given source object
	 *
	 * @param source
	 *            the source object that the event relates to
	 */
	void fireEvent(final T source);

	/**
	 * Removes the given event listener from the list of event listeners
	 *
	 * @param eventListener
	 *            the event listener to be removed
	 */
	void remove(final EventListener<T> eventListener);

	/**
	 * Removes all the given event listeners from the list of event listeners
	 *
	 * @param eventListeners
	 *            the collection of event listeners to be removed
	 */
	void removeAll(final Collection<EventListener<T>> eventListeners);

}
