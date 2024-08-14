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

import java.util.ArrayList;
import java.util.Collection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The class {@link EventSubject} is an implementation of the {@link EventSource} interface It
 * represents a subject that can have multiple event listeners and can fire events to them
 *
 * @param <T>
 *            the generic type of the source object
 */
@Getter
@EqualsAndHashCode
@ToString
public class EventSubject<T> implements EventSource<T>
{

	/** The collection of registered event listeners */
	private final Collection<EventListener<T>> eventListeners;

	/** The source object associated with the event */
	private T source;

	/* Initialization block to initialize the eventListeners collection */
	{
		eventListeners = new ArrayList<>();
	}

	/**
	 * Instantiates a new {@code EventSubject} with no initial source
	 */
	public EventSubject()
	{
	}

	/**
	 * Instantiates a new {@code EventSubject} with the specified source
	 *
	 * @param source
	 *            the source object associated with the event
	 */
	public EventSubject(final T source)
	{
		this.source = source;
	}

	/**
	 * Factory method to create a new {@link EventSubject} object
	 *
	 * @param <T>
	 *            the generic type of the source object
	 * @param source
	 *            the source object associated with the event
	 * @return the newly created {@link EventSubject} object
	 */
	public static <T> EventSubject<T> of(final @NonNull T source)
	{
		return new EventSubject<>(source);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void add(final EventListener<T> eventListener)
	{
		eventListeners.add(eventListener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void addAll(final Collection<EventListener<T>> eventListeners)
	{
		this.eventListeners.addAll(eventListeners);
	}

	/**
	 * Fires the event to all registered listeners
	 */
	private synchronized void fireEvent()
	{
		for (final EventListener<T> eventListener : eventListeners)
		{
			eventListener.onEvent(source);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void fireEvent(final T source)
	{
		this.source = source;
		fireEvent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void remove(final EventListener<T> eventListener)
	{
		eventListeners.remove(eventListener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void removeAll(final Collection<EventListener<T>> eventListeners)
	{
		this.eventListeners.removeAll(eventListeners);
	}
}
