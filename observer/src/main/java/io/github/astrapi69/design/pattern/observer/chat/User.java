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
 * The class {@link User}.
 */
public class User implements IUser<User>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/**
	 * User Name.
	 */
	private String name;
	/**
	 * User id number.
	 */
	private Integer id;

	/**
	 * Instantiates a new user.
	 *
	 * @param name
	 *            the name
	 * @param id
	 *            the id
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
	public Integer getId()
	{
		return id;
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
	 * {@inheritDoc}
	 */
	@Override
	public void setApplicationUser(final User user)
	{


	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(final Integer id)
	{
		this.id = id;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(final String name)
	{
		this.name = name;
	}
}
