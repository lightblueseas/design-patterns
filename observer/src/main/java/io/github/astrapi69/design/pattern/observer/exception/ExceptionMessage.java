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

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link ExceptionMessage} represents a message object used in exception handling It
 * encapsulates information such as a properties key and value, an ID, and additional data that may
 * be related to the exception
 *
 * @version 1.0
 * @param <T>
 *            the generic type of the additional data
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionMessage<T> implements Serializable
{

	/** The serialVersionUID for serialization compatibility */
	private static final long serialVersionUID = 1L;

	/** The key reference for a property in the resource bundle */
	private String propertiesKey;

	/** The value reference for a property in the resource bundle */
	private String propertiesValue;

	/** The unique identifier in the database */
	private String id;

	/** A list of additional data related to the exception */
	private List<T> additions;

	/**
	 * Constructor for creating an {@code ExceptionMessage} with specified key, value, and ID
	 *
	 * @param propertiesKey
	 *            the key reference for a property in the resource bundle
	 * @param propertiesValue
	 *            the value reference for a property in the resource bundle
	 * @param id
	 *            the unique identifier in the database
	 */
	public ExceptionMessage(final String propertiesKey, final String propertiesValue,
		final String id)
	{
		this(propertiesKey, propertiesValue, id, null);
	}

}
