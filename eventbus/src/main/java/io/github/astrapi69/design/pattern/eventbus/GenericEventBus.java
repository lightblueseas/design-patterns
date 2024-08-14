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
package io.github.astrapi69.design.pattern.eventbus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.NonNull;
import io.github.astrapi69.design.pattern.observer.event.EventObject;
import io.github.astrapi69.design.pattern.observer.event.EventSource;
import io.github.astrapi69.design.pattern.observer.event.EventSubject;

/**
 * The {@code GenericEventBus} is a final utility class that provides a centralized event bus
 * mechanism for managing and dispatching events using {@code EventSource} objects. It maintains a
 * registry of event sources keyed by strings or class types, enabling efficient event dispatching
 * and management.
 */
public final class GenericEventBus
{
	// A static map holding event sources keyed by their string representation
	private static final Map<String, EventSource<?>> eventSources = new HashMap<>();

	// Private constructor to prevent instantiation
	private GenericEventBus()
	{
	}

	/**
	 * Retrieves the event source associated with the specified key
	 *
	 * @param key
	 *            the key associated with the event source
	 * @return the event source associated with the given key or null if none is found
	 */
	public static EventSource<?> get(final String key)
	{
		return eventSources.get(key);
	}

	/**
	 * Checks if the event bus contains an event source associated with the specified key
	 *
	 * @param key
	 *            the key to check
	 * @return {@code true} if the event source is present, {@code false} otherwise
	 */
	public static boolean containsKey(final String key)
	{
		return eventSources.containsKey(key);
	}

	/**
	 * Checks if the event bus contains an event source associated with the specified class type
	 *
	 * @param <T>
	 *            the type of the event source
	 * @param eventSourceTypeClass
	 *            the class type of the event source to check
	 * @return {@code true} if the event source is present, {@code false} otherwise
	 */
	public static <T> boolean containsKey(@NonNull final Class<T> eventSourceTypeClass)
	{
		return eventSources.containsKey(eventSourceTypeClass.getSimpleName());
	}

	/**
	 * Retrieves the event source associated with the specified class type. If it does not exist, a
	 * new {@code EventSubject} is created and associated with the class type.
	 *
	 * @param <T>
	 *            the type of the event source
	 * @param eventSourceTypeClass
	 *            the class type of the event source
	 * @return the event source associated with the specified class type
	 */
	@SuppressWarnings("unchecked")
	public static <T> EventSource<EventObject<T>> getEventSource(
		@NonNull final Class<T> eventSourceTypeClass)
	{
		if (!containsKey(eventSourceTypeClass))
		{
			put(eventSourceTypeClass.getSimpleName(), new EventSubject<EventObject<T>>());
		}
		return (EventSource<EventObject<T>>)get(eventSourceTypeClass.getSimpleName());
	}

	/**
	 * Removes the event source associated with the specified class type
	 *
	 * @param <T>
	 *            the type of the event source
	 * @param eventSourceTypeClass
	 *            the class type of the event source to be removed
	 * @return an {@code Optional} containing the removed event source, or {@code Optional.empty()}
	 *         if none existed
	 */
	public static <T> Optional<EventSource<EventObject<T>>> remove(
		@NonNull final Class<T> eventSourceTypeClass)
	{
		if (containsKey(eventSourceTypeClass))
		{
			EventSource<EventObject<T>> removedEventSource = (EventSource<EventObject<T>>)eventSources
				.remove(eventSourceTypeClass.getSimpleName());
			return Optional.of(removedEventSource);
		}
		return Optional.empty();
	}

	/**
	 * Associates the specified event source with the specified key
	 *
	 * @param key
	 *            the key with which the event source is to be associated
	 * @param value
	 *            the event source to be associated with the key
	 * @return the previous event source associated with the key, or {@code null} if there was no
	 *         mapping for the key
	 */
	public static synchronized EventSource<?> put(final String key, final EventSource<?> value)
	{
		return eventSources.put(key, value);
	}

}
