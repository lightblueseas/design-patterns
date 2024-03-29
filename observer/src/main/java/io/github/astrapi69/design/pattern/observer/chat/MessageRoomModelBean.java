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
import java.util.Date;

/**
 * The class {@link MessageRoomModelBean}.
 *
 */
public class MessageRoomModelBean implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The chat room name. */
	private final String chatRoomName;
	/** The date. */
	private final Date date = new Date();
	/** The user. */
	private final IUser<?> user;
	/** The data. */
	private Byte[] data;
	/** The message. */
	private String message;

	/**
	 * Instantiates a new message room model.
	 *
	 * @param chatRoomName
	 *            the chat room name
	 * @param user
	 *            the user
	 * @param message
	 *            the message
	 * @param data
	 *            the data
	 */
	public MessageRoomModelBean(final String chatRoomName, final IUser<?> user,
		final String message, final Byte[] data)
	{
		super();
		this.chatRoomName = chatRoomName;
		this.user = user;
		this.message = message;
		this.data = data;
	}

	/**
	 * Gets the chat room name.
	 *
	 * @return the chat room name
	 */
	public String getChatRoomName()
	{
		return chatRoomName;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Byte[] getData()
	{
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(final Byte[] data)
	{
		this.data = data;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(final String message)
	{
		this.message = message;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public IUser<?> getUser()
	{
		return user;
	}
}
