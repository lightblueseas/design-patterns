/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
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
package de.alpharogroup.designpattern.observer.chat.listener;

/**
 * The Class MessageObject.
 * 
 * @param <T>
 *            the generic type
 */
public class MessageObject<T>
{

	/**
	 * The object on which the message Event initially occurred.
	 */
	protected transient T source;

	/**
	 * Instantiates a new message object.
	 * 
	 * @param source
	 *            the source
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
	 * Gets the source.
	 *
	 * @return the source
	 */
	public T getSource()
	{
		return source;
	}

}
