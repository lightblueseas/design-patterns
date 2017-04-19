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
package de.alpharogroup.design.pattern.observer;

import de.alpharogroup.design.pattern.observer.api.ActionCommand;
import de.alpharogroup.design.pattern.observer.api.Observer;
import de.alpharogroup.design.pattern.observer.api.Subject;


/**
 * A generic implementation from the Observer-Pattern.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class AbstractObserver<T> implements Observer<T>, ActionCommand
{

	/** The subject. */
	protected Subject<T, Observer<T>> subject;

	/** The observable. */
	private T observable;

	/**
	 * Constructor for a new observer object.
	 *
	 * @param subject
	 *            the subject
	 */
	public AbstractObserver(final Subject<T, Observer<T>> subject)
	{
		this.subject = subject;
		this.observable = subject.getObservable();
		this.subject.add(this);
	}

	/**
	 * Gets the observable object.
	 *
	 * @return the observable
	 */
	public synchronized T getObservable()
	{
		return observable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void update(final T observable)
	{
		this.observable = observable;
		execute();
	}

}
