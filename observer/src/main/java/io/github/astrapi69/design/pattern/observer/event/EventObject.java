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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The class {@link EventObject} serves, as its name suggests, as an event object It encapsulates
 * the source object on which an event initially occurred
 *
 * @param <T>
 *            the generic type of the source object
 */
@Getter
@EqualsAndHashCode
@ToString
@SuperBuilder
public class EventObject<T>
{

	/**
	 * The object on which the Event initially occurred
	 */
	protected transient T source;

	/**
	 * Instantiates a new {@link EventObject} object
	 *
	 * @param source
	 *            the source object on which the event occurred
	 */
	public EventObject(final @NonNull T source)
	{
		this.source = source;
	}

	/**
	 * Factory method to create a new {@link EventObject} object
	 *
	 * @param <T>
	 *            the generic type of the source object
	 * @param source
	 *            the source object on which the event occurred
	 * @return the newly created {@link EventObject} object
	 */
	public static <T> EventObject<T> of(final @NonNull T source)
	{
		return EventObject.<T> builder().source(source).build();
	}

}
