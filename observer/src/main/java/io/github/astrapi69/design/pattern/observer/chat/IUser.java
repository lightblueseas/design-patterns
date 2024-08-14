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

import java.io.Serializable;

/**
 * The interface {@link IUser} represents a user in a chat application It provides methods to manage
 * the user's identity, including getting and setting the application user, retrieving the user's
 * unique identifier, and obtaining the user's name
 *
 * @param <U>
 *            the generic type representing the application user
 */
public interface IUser<U> extends Serializable
{

	/**
	 * Gets the application user associated with this {@link IUser}
	 *
	 * @return the application user
	 */
	U getApplicationUser();

	/**
	 * Sets the application user associated with this {@link IUser}
	 *
	 * @param user
	 *            the new application user
	 */
	void setApplicationUser(final U user);

	/**
	 * Gets the unique identifier for this {@link IUser}
	 *
	 * @return the unique identifier
	 */
	Serializable getId();

	/**
	 * Gets the name of this {@link IUser}
	 *
	 * @return the name of the user
	 */
	String getName();
}
