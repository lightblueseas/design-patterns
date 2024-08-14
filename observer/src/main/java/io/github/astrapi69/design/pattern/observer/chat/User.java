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
 * The class {@link User} represents a user in a chat application It implements the {@link IUser}
 * interface and provides methods to manage the user's identity, including their name and ID
 */
public class User implements IUser<User>
{

	/** The Constant serialVersionUID for serialization compatibility */
	private static final long serialVersionUID = 1L;

	/** The name of the user */
	private String name;

	/** The ID number of the user */
	private Integer id;

	/**
	 * Instantiates a new user with the given name and ID
	 *
	 * @param name
	 *            the name of the user
	 * @param id
	 *            the ID number of the user
	 */
	public User(final String name, final Integer id)
	{
		super();
		this.name = name;
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getApplicationUser()
	{
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setApplicationUser(final User user)
	{
		// This method is intentionally left blank as this class represents the application user
		// itself
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getId()
	{
		return id;
	}

	/**
	 * Sets the ID number of the user
	 *
	 * @param id
	 *            the new ID number
	 */
	public void setId(final Integer id)
	{
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the user
	 *
	 * @param name
	 *            the new name of the user
	 */
	public void setName(final String name)
	{
		this.name = name;
	}
}
