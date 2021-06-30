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
package io.github.astrapi69.design.pattern.state;

/**
 * The interface {@link State} represents a State.
 *
 * @param <ST>
 *            the generic type of the state machine
 */
public interface State<ST>
{

	/**
	 * Gets the simple name of this {@link State} object.
	 *
	 * @return the simple name of this {@link State} object.
	 */
	default String getName()
	{
		return this.getClass().getSimpleName();
	}

	/**
	 * Go to the next {@link State} object.
	 *
	 * @param input
	 *            the {@link StateMachine} object
	 */
	void goNext(ST input);

	/**
	 * Go to the previous {@link State} object.
	 *
	 * @param input
	 *            the {@link StateMachine} object
	 */
	void goPrevious(ST input);

	/**
	 * Checks if this {@link State} object has a next {@link State} object.
	 *
	 * @return true, if this {@link State} object has a next {@link State} object otherwise false.
	 */
	default boolean hasNext()
	{
		return true;
	}

	/**
	 * Checks if this {@link State} object has a previous {@link State} object.
	 *
	 * @return true, if this {@link State} object has a previous {@link State} object otherwise
	 *         false.
	 */
	default boolean hasPrevious()
	{
		return true;
	}

	/**
	 * Checks if this {@link State} object is the first {@link State} object.
	 *
	 * @return true, if this {@link State} object is the first {@link State} object otherwise false.
	 */
	default boolean isFirst()
	{
		return false;
	}

	/**
	 * Checks if this {@link State} object is the last {@link State} object.
	 *
	 * @return true, if this {@link State} object is the last {@link State} object otherwise false.
	 */
	default boolean isLast()
	{
		return false;
	}
}
