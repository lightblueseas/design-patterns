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

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * The class {@link GenericEventBusTest} provides unit tests for the integration
 * of the {@link GenericEventBus} with the {@link ApplicationEventBus} using the Guava {@link EventBus}
 * The tests verify the registration, event posting, and unregistration of event listeners,
 * ensuring correct behavior of the event bus system
 */
public class GenericEventBusTest
{
	/** Counter to track the number of events processed */
	private static long counter;

	/** Stores the current state of the {@link NavigationEventState} as set by the event handler */
	private static NavigationEventState navigationEventState;

	/**
	 * Test method for verifying the functionality of the {@link ApplicationEventBus} using the Guava {@link EventBus}
	 * It checks the correct registration and unregistration of listeners,
	 * the proper handling of different types of events, and the integrity of event-driven state changes
	 */
	@Test
	public void testApplicationEventBus()
	{
		// ApplicationEventBus from guava
		EventBus guavaEventBus = ApplicationEventBus.getInstance().getApplicationEventBus();
		// Register this instance as listener
		guavaEventBus.register(this);
		// Post an event
		guavaEventBus.post("increment");
		// Verify that the counter is incremented
		assertEquals(1, counter);
		// Post an event
		guavaEventBus.post(NavigationEventState.UPDATE);
		// Verify that the navigationEventState is set to NavigationEventState.UPDATE
		assertEquals(NavigationEventState.UPDATE, navigationEventState);
		// Verify that the counter is not incremented
		assertEquals(1, counter);
		// Unregister this instance as listener
		guavaEventBus.unregister(this);
		// Post an event
		guavaEventBus.post("increment");
		// Verify that the counter is not incremented
		assertEquals(1, counter);
		// Register again this instance as listener
		guavaEventBus.register(this);
		// Post an event
		guavaEventBus.post("increment");
		// Verify that the counter is incremented
		assertEquals(2, counter);
		// Post an event
		guavaEventBus.post(NavigationEventState.RESET);
		// Verify that the navigationEventState is set to NavigationEventState.RESET
		assertEquals(NavigationEventState.RESET, navigationEventState);
		// Post an event
		guavaEventBus.post(NavigationEventState.VALIDATE);
		// Verify that the navigationEventState is set to NavigationEventState.VALIDATE
		assertEquals(NavigationEventState.VALIDATE, navigationEventState);
		// Unregister this instance as listener
		guavaEventBus.unregister(this);
	}

	/**
	 * Event handler method for string-based events
	 * This method increments the counter each time it is called
	 *
	 * @param event the event string, typically a command or action indicator
	 */
	@Subscribe
	public void onAddition(String event)
	{
		counter++;
	}

	/**
	 * Event handler method for {@link NavigationEventState} events
	 * This method updates the {@code navigationEventState} field to reflect the state passed in the event
	 *
	 * @param navigationEventState the event containing the new navigation state
	 */
	@Subscribe
	public void onAdditionWithObject(NavigationEventState navigationEventState)
	{
		GenericEventBusTest.navigationEventState = navigationEventState;
	}
}
