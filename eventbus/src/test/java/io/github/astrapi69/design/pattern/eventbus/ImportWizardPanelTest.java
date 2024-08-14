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

import io.github.astrapi69.design.pattern.observer.event.EventListener;
import io.github.astrapi69.design.pattern.observer.event.EventObject;
import io.github.astrapi69.design.pattern.observer.event.EventSource;

/**
 * The class {@link ImportWizardPanelTest} provides unit tests for the {@link ImportWizardPanel}
 * class It implements the {@link EventListener} interface to listen for
 * {@link NavigationEventState} events and verify the correct behavior of the event handling and
 * state update logic
 */
public class ImportWizardPanelTest implements EventListener<EventObject<NavigationEventState>>
{

	/** The current state of the navigation event, set by the event listener */
	private NavigationEventState navigationEventState;

	/**
	 * Handles the given event by updating the navigation state of the panel
	 *
	 * @param event
	 *            the event containing the new {@link NavigationEventState}
	 */
	@Override
	public void onEvent(EventObject<NavigationEventState> event)
	{
		updateButtonState(event.getSource());
	}

	/**
	 * Updates the button state based on the given navigation state
	 *
	 * @param navigationState
	 *            the new navigation state to be applied
	 */
	protected void updateButtonState(NavigationEventState navigationState)
	{
		this.navigationEventState = navigationState;
	}

	/**
	 * Test method for verifying the event handling functionality of the {@link ImportWizardPanel}
	 * It registers the test class as a listener for {@link NavigationEventState} events, fires
	 * events, and verifies that the {@code navigationEventState} is updated correctly
	 */
	@Test
	public void testApplicationEventBus()
	{
		// Register as listener...
		final EventSource<EventObject<NavigationEventState>> eventSource = ApplicationEventBus
			.getImportNavigationState();
		eventSource.add(this);
		// Create an event source object
		final EventSource<EventObject<NavigationEventState>> navigationEventStateEventSource = ApplicationEventBus
			.getImportNavigationState();
		// Fire a new event
		navigationEventStateEventSource.fireEvent(new EventObject<>(NavigationEventState.UPDATE));
		// Verify that the navigationEventState is set to NavigationEventState.UPDATE
		assertEquals(NavigationEventState.UPDATE, this.navigationEventState);
		// Fire a new event
		navigationEventStateEventSource.fireEvent(new EventObject<>(NavigationEventState.VALIDATE));
		// Verify that the navigationEventState is set to NavigationEventState.VALIDATE
		assertEquals(NavigationEventState.VALIDATE, this.navigationEventState);
		// Fire a new event
		navigationEventStateEventSource.fireEvent(new EventObject<>(NavigationEventState.RESET));
		// Verify that the navigationEventState is set to NavigationEventState.RESET
		assertEquals(NavigationEventState.RESET, this.navigationEventState);
	}
}
