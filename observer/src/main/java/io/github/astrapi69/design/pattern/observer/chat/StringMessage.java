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

/**
 * The class {@link StringMessage} represents a message that contains a string value It implements
 * the {@link Message} interface and provides methods to get and set the string value
 */
public class StringMessage implements Message<String>
{

	/** The Constant serialVersionUID for serialization compatibility */
	private static final long serialVersionUID = 1L;

	/** The value of the string message */
	private String value;

	/**
	 * Instantiates a new {@code StringMessage} with no initial value
	 */
	public StringMessage()
	{
	}

	/**
	 * Instantiates a new {@code StringMessage} with the given value
	 *
	 * @param value
	 *            the value of the message
	 */
	public StringMessage(final String value)
	{
		this.value = value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getValue()
	{
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringMessage setValue(final String value)
	{
		this.value = value;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "StringMessage [value=" + value + "]";
	}

}
