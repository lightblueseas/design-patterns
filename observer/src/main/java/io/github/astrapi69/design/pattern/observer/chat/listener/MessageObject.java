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

/**
 * The Class {@link MessageObject} represents an object that contains a message event It
 * encapsulates the source object on which the message event initially occurred
 *
 * @param <T>
 *            the generic type of the source object
 */
public class MessageObject<T>
{

	/**
	 * The object on which the message event initially occurred
	 */
	protected transient T source;

	/**
	 * Instantiates a new {@code MessageObject} with the given source
	 *
	 * @param source
	 *            the source object on which the message event occurred
	 * @throws IllegalArgumentException
	 *             if the source is {@code null}
	 */
	public MessageObject(final T source)
	{
		if (source == null)
		{
			throw new IllegalArgumentException("null source");
		}

		this.source = source;
	}

	/**
	 * Gets the source object on which the message event initially occurred
	 *
	 * @return the source object
	 */
	public T getSource()
	{
		return source;
	}
}
