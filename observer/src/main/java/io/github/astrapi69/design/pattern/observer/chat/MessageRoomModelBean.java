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
 * The class {@link MessageRoomModelBean} represents a model for a message in a chat room It
 * includes details such as the chat room name, the user who sent the message, the message content,
 * and any associated data, as well as the date the message was created
 */
public class MessageRoomModelBean implements Serializable
{

	/** The Constant serialVersionUID for serialization compatibility */
	private static final long serialVersionUID = 1L;

	/** The name of the chat room */
	private final String chatRoomName;

	/** The date the message was created */
	private final Date date = new Date();

	/** The user who sent the message */
	private final IUser<?> user;

	/** Any additional data associated with the message */
	private Byte[] data;

	/** The content of the message */
	private String message;

	/**
	 * Instantiates a new {@code MessageRoomModelBean} with the specified details
	 *
	 * @param chatRoomName
	 *            the name of the chat room
	 * @param user
	 *            the user who sent the message
	 * @param message
	 *            the content of the message
	 * @param data
	 *            any additional data associated with the message
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
	 * Gets the name of the chat room
	 *
	 * @return the chat room name
	 */
	public String getChatRoomName()
	{
		return chatRoomName;
	}

	/**
	 * Gets the additional data associated with the message
	 *
	 * @return the data
	 */
	public Byte[] getData()
	{
		return data;
	}

	/**
	 * Sets the additional data associated with the message
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(final Byte[] data)
	{
		this.data = data;
	}

	/**
	 * Gets the date the message was created
	 *
	 * @return the creation date of the message
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * Gets the content of the message
	 *
	 * @return the message content
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * Sets the content of the message
	 *
	 * @param message
	 *            the new message content
	 */
	public void setMessage(final String message)
	{
		this.message = message;
	}

	/**
	 * Gets the user who sent the message
	 *
	 * @return the user who sent the message
	 */
	public IUser<?> getUser()
	{
		return user;
	}
}
