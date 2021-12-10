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
package io.github.astrapi69.design.pattern.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Getter;
import io.github.astrapi69.design.pattern.observer.api.Observer;
import io.github.astrapi69.design.pattern.observer.api.Subject;

/**
 * The Class AbstractSubject is an implementation from the interface Subject. This class
 * encapsulates the observable and fires an update if the observable changes. The update informs all
 * registered observers about the change of the observable.
 *
 * @param <T>
 *            the generic type of the observable.
 * @param <O>
 *            the generic type of the observer
 */
public abstract class AbstractSubject<T, O extends Observer<T>> implements Subject<T, O>
{

	/** The observers. */
	@Getter
	private final List<O> observers;
	/** The observable object. */
	@Getter
	private T observable;

	/**
	 * Initialize block.
	 **/
	{
		observers = new ArrayList<>();
	}

	/**
	 * Default constructor for a new subject.
	 */
	public AbstractSubject()
	{
	}

	/**
	 * Constructor for a new subject with an observable.
	 *
	 * @param observable
	 *            the observable
	 */
	public AbstractSubject(final T observable)
	{
		this.observable = observable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void add(final O observer)
	{
		getObservers().add(observer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void addAll(final Collection<O> observers)
	{
		getObservers().addAll(observers);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void remove(final O observer)
	{
		final int index = getObservers().indexOf(observer);
		if (0 <= index)
		{
			getObservers().remove(observer);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void removeAll(final Collection<O> observers)
	{
		getObservers().removeAll(observers);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void setObservable(final T observable)
	{
		this.observable = observable;
		updateObservers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void updateObservers()
	{
		for (final O observer : getObservers())
		{
			observer.update(getObservable());
		}
	}

}
