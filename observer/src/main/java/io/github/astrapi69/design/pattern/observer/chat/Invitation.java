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
 * The Interface {@link Invitation} represents an invitation to join a chat room It defines the
 * methods to retrieve the sender, recipient, and the room associated with the invitation, as well
 * as methods to check if the invitation has been accepted and if the denial is visible to the
 * sender
 *
 * @param <M>
 *            the generic type of the message associated with the chat room
 */
public interface Invitation<M extends Message<?>> extends Serializable
{

	/**
	 * Gets the recipient of this invitation
	 *
	 * @return the recipient of this invitation
	 */
	IUser<?> getRecipient();

	/**
	 * Gets the room associated with this invitation
	 *
	 * @return the room for this invitation
	 */
	Room<M> getRoom();

	/**
	 * Gets the sender of this invitation
	 *
	 * @return the sender of this invitation
	 */
	IUser<?> getSender();

	/**
	 * Checks if this invitation has been accepted by the recipient
	 *
	 * @return true if the invitation is accepted, otherwise false
	 */
	boolean isAccepted();

	/**
	 * Checks if the recipient wants the sender to see that the invitation was denied
	 *
	 * @return true if the recipient wants the sender to see the denial, otherwise false
	 */
	boolean isDeniedVisible();
}
