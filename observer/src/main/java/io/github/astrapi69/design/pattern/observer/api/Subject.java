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
package io.github.astrapi69.design.pattern.observer.api;

import java.util.Collection;
import java.util.List;

/**
 * The interface {@link Subject} represents the "subject" in the Observer design pattern The subject
 * is the object whose state changes are being observed by one or more observers When the state of
 * the subject changes, the observers are notified of the change
 *
 * @param <T>
 *            the generic type of the observable object whose state is being observed
 * @param <O>
 *            the generic type of the observer that is observing the subject
 */
public interface Subject<T, O extends Observer<T>>
{

	/**
	 * Adds the given observer to the list of observers
	 *
	 * @param observer
	 *            the observer to be added
	 */
	default void add(final O observer)
	{
		getObservers().add(observer);
	}

	/**
	 * Adds the given observers to the list of observers
	 *
	 * @param observers
	 *            the observers to be added
	 */
	default void addAll(final Collection<O> observers)
	{
		getObservers().addAll(observers);
	}

	/**
	 * Gets the observable object, which is the object being observed for state changes
	 *
	 * @return the observable object
	 */
	T getObservable();

	/**
	 * Sets the observable object, which is the object being observed for state changes
	 *
	 * @param observable
	 *            the new observable object
	 */
	void setObservable(final T observable);

	/**
	 * Gets the list of observers that wish to be notified of changes to the observable object
	 *
	 * @return the list of observers
	 */
	List<O> getObservers();

	/**
	 * Removes the given observer from the list of observers
	 *
	 * @param observer
	 *            the observer to be removed
	 */
	default void remove(final O observer)
	{
		final int index = getObservers().indexOf(observer);
		if (0 <= index)
		{
			getObservers().remove(observer);
		}
	}

	/**
	 * Removes the given observers from the list of observers
	 *
	 * @param observers
	 *            the observers to be removed
	 */
	default void removeAll(final Collection<O> observers)
	{
		getObservers().removeAll(observers);
	}

	/**
	 * Notifies all observers of a change in the state of the observable object Each observer's
	 * {@code update} method is called with the current state of the observable
	 */
	default void updateObservers()
	{
		for (final O observer : getObservers())
		{
			observer.update(getObservable());
		}
	}
}
