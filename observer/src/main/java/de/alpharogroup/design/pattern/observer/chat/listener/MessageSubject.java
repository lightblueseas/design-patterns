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
package de.alpharogroup.design.pattern.observer.chat.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The class {@link MessageSubject}.
 *
 * @param <T>
 *            the generic type
 */
public class MessageSubject<T> implements MessageSource<T>
{
	/**
	 * Initialize block.
	 **/
	{
		messageListeners = new ArrayList<>();
	}

	/** The source. */
	private T source;

	/** The event listeners. */
	private final List<MessageListener<T>> messageListeners;

	/**
	 * Instantiates a new message subject.
	 */
	public MessageSubject()
	{
	}

	/**
	 * Instantiates a new message subject.
	 *
	 * @param source
	 *            the source
	 */
	public MessageSubject(final T source)
	{
		this.source = source;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void add(final MessageListener<T> messageListener)
	{
		messageListeners.add(messageListener);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void addAll(final Collection<MessageListener<T>> messageListeners)
	{
		this.messageListeners.addAll(messageListeners);
	}

	/**
	 * Fire message.
	 */
	private synchronized void fireMessage()
	{
		for (final MessageListener<T> messageListener : messageListeners)
		{
			messageListener.onMessage(source);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void fireMessage(final T source)
	{
		this.source = source;
		fireMessage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void remove(final MessageListener<T> messageListener)
	{
		messageListeners.remove(messageListener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void removeAll(final Collection<MessageListener<T>> messageListeners)
	{
		this.messageListeners.removeAll(messageListeners);
	}

}
