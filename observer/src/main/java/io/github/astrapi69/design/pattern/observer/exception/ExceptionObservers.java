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
package io.github.astrapi69.design.pattern.observer.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link ExceptionObservers} is a singleton that manages a list of
 * {@link ExceptionListener} objects It allows classes to register and unregister for exception
 * events, and notifies registered listeners when an exception event occurs
 */
public class ExceptionObservers
{

	/** The single instance of this class */
	private static ExceptionObservers instance = null;

	/** The list of registered exception listeners */
	protected List<ExceptionListener> exceptionListeners = new ArrayList<>();

	/**
	 * Instantiates a new {@code ExceptionObservers} object This constructor is private to enforce
	 * the singleton pattern
	 */
	private ExceptionObservers()
	{
	}

	/**
	 * Gets the single instance of {@code ExceptionObservers}
	 *
	 * @return the single instance of {@code ExceptionObservers}
	 */
	public static synchronized ExceptionObservers getInstance()
	{
		synchronized (ExceptionObservers.class)
		{
			if (instance == null)
			{
				instance = new ExceptionObservers();
			}
		}
		return instance;
	}

	/**
	 * Adds the specified exception listener to the list of listeners This method allows classes to
	 * register for exception events
	 *
	 * @param listener
	 *            the exception listener to be added
	 */
	public void addExceptionListener(final ExceptionListener listener)
	{
		exceptionListeners.add(listener);
	}

	/**
	 * Fires an exception event to all registered listeners
	 *
	 * @param event
	 *            the exception event to be fired
	 */
	void fireExceptionEvent(final ExceptionEvent event)
	{
		final int listenerSize = exceptionListeners.size();
		for (int i = 0; i < listenerSize; i++)
		{
			final ExceptionListener lis = exceptionListeners.get(i);
			lis.onException(event);
		}
	}

	/**
	 * Removes the specified exception listener from the list of listeners This method allows
	 * classes to unregister for exception events
	 *
	 * @param listener
	 *            the exception listener to be removed
	 */
	public void removeExceptionListener(final ExceptionListener listener)
	{
		exceptionListeners.remove(listener);
	}
}
