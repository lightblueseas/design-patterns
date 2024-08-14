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

import io.github.astrapi69.design.pattern.observer.exception.ExceptionEvent;
import io.github.astrapi69.design.pattern.observer.exception.ExceptionListener;

/**
 * The class {@link DefaultExceptionHandler} provides a default implementation for handling
 * exception events It extends {@link AbstractExceptionHandler} and propagates exception events to
 * the registered listeners
 */
public class DefaultExceptionHandler extends AbstractExceptionHandler
{

	/** The serialVersionUID for serialization compatibility */
	private static final long serialVersionUID = -7194471234913656513L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEvent(final ExceptionListener listener, final ExceptionEvent event)
	{
		listener.onException(event);
	}

	/**
	 * Updates all registered listeners with the given exception event
	 *
	 * @param event
	 *            the exception event to be propagated to the listeners
	 */
	public void updateOnException(final ExceptionEvent event)
	{
		super.update(event);
	}

}
