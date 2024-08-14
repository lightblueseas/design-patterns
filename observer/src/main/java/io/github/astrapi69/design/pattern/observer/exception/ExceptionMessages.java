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
package io.github.astrapi69.design.pattern.observer.exception;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The class {@link ExceptionMessages} manages a collection of exception messages organized by keys
 * It allows adding, retrieving, and removing exception messages based on specific keys
 *
 * @param <T>
 *            the generic type of the additional data contained in the exception messages
 */
public class ExceptionMessages<T>
{

	/** A map that contains all exception messages, organized by keys */
	private final Map<String, Set<ExceptionMessage<T>>> exceptions = new HashMap<>();

	/**
	 * Adds a map of exception messages to the existing collection
	 *
	 * @param keyListMap
	 *            the map of keys and corresponding sets of exception messages to be added
	 */
	public void add(final Map<? extends String, ? extends Set<ExceptionMessage<T>>> keyListMap)
	{
		this.exceptions.putAll(keyListMap);
	}

	/**
	 * Adds an exception message to the collection under the specified key
	 *
	 * @param key
	 *            the key under which the exception message should be stored
	 * @param value
	 *            the exception message to be added
	 */
	public void add(final String key, final ExceptionMessage<T> value)
	{
		Set<ExceptionMessage<T>> values = this.exceptions.get(key);
		if (values == null)
		{
			values = new HashSet<>();
			this.exceptions.put(key, values);
		}
		values.add(value);
	}

	/**
	 * Checks if the collection contains exception messages associated with the specified key
	 *
	 * @param key
	 *            the key to be checked
	 * @return true if the key exists in the collection, otherwise false
	 */
	public boolean containsKey(final String key)
	{
		return this.exceptions.containsKey(key);
	}

	/**
	 * Retrieves the set of exception messages associated with the specified key
	 *
	 * @param key
	 *            the key whose associated exception messages are to be returned
	 * @return the set of exception messages associated with the specified key, or null if no
	 *         messages are found
	 */
	public Set<ExceptionMessage<T>> get(final String key)
	{
		return this.exceptions.get(key);
	}

	/**
	 * Retrieves the set of all keys used in the collection
	 *
	 * @return the set of all keys
	 */
	public Set<String> getKeys()
	{
		return this.exceptions.keySet();
	}

	/**
	 * Gets the number of unique keys in the collection
	 *
	 * @return the number of unique keys
	 */
	public int getSize()
	{
		return this.exceptions.size();
	}

	/**
	 * Checks if the collection is empty
	 *
	 * @return true if the collection contains no entries, otherwise false
	 */
	public boolean isEmpty()
	{
		return this.exceptions.isEmpty();
	}

	/**
	 * Removes all exception messages associated with the specified key
	 *
	 * @param key
	 *            the key whose associated exception messages are to be removed
	 * @return the set of exception messages that were removed, or null if the key was not found
	 */
	public Set<ExceptionMessage<T>> remove(final String key)
	{
		return this.exceptions.remove(key);
	}

	/**
	 * Removes all exception messages associated with the specified collection of keys
	 *
	 * @param keys
	 *            the collection of keys whose associated exception messages are to be removed
	 */
	public void removeAll(final Collection<String> keys)
	{
		for (final String key : keys)
		{
			this.remove(key);
		}
	}

}
