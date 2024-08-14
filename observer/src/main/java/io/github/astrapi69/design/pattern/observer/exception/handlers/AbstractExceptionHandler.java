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
package io.github.astrapi69.design.pattern.observer.exception.handlers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.github.astrapi69.design.pattern.observer.exception.ExceptionEvent;
import io.github.astrapi69.design.pattern.observer.exception.ExceptionListener;

/**
 * The abstract class {@link AbstractExceptionHandler} handles all exceptions by managing a list of
 * {@link ExceptionListener} objects and updating them when an exception event occurs
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public abstract class AbstractExceptionHandler implements Serializable
{

	/** The serialVersionUID for serialization compatibility */
	private static final long serialVersionUID = 1L;

	/** The list of registered {@link ExceptionListener} objects */
	private final List<ExceptionListener> listeners = new ArrayList<>();

	/**
	 * Adds an {@link ExceptionListener} object to the list of listeners
	 *
	 * @param listener
	 *            the listener to be added
	 */
	void addExceptionListener(final ExceptionListener listener)
	{
		listeners.add(listener);
	}

	/**
	 * Removes an {@link ExceptionListener} object from the list of listeners
	 *
	 * @param listener
	 *            the listener to be removed
	 */
	void removeExceptionListener(final ExceptionListener listener)
	{
		listeners.remove(listener);
	}

	/**
	 * Updates all registered listeners with the given exception event
	 *
	 * @param event
	 *            the exception event to be propagated to the listeners
	 */
	void update(final ExceptionEvent event)
	{
		for (final ExceptionListener listener : listeners)
		{
			updateEvent(listener, event);
		}
	}

	/**
	 * Updates the specified listener with the given exception event This method must be implemented
	 * by subclasses to define how the event is propagated to the listener
	 *
	 * @param listener
	 *            the listener to be updated
	 * @param event
	 *            the exception event to be propagated to the listener
	 */
	public abstract void updateEvent(final ExceptionListener listener, final ExceptionEvent event);

}
