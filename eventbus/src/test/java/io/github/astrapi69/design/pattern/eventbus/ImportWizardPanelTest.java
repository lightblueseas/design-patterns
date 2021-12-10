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

public class ImportWizardPanelTest implements EventListener<EventObject<NavigationEventState>>
{

	private NavigationEventState navigationEventState;

	/**
	 * Handles the given event.
	 *
	 * @param event
	 *            the event
	 */
	@Override
	public void onEvent(EventObject<NavigationEventState> event)
	{
		updateButtonState(event.getSource());
	}

	protected void updateButtonState(NavigationEventState navigationState)
	{
		this.navigationEventState = navigationState;
	}

	@Test
	public void testApplicationEventBus()
	{
		// register as listener...
		final EventSource<EventObject<NavigationEventState>> eventSource = ApplicationEventBus
			.getImportNavigationState();
		eventSource.add(this);
		// create an event source object
		final EventSource<EventObject<NavigationEventState>> navigationEventStateEventSource = ApplicationEventBus
			.getImportNavigationState();
		// fire a new event
		navigationEventStateEventSource.fireEvent(new EventObject<>(NavigationEventState.UPDATE));
		// verify that the navigationEventState is set to NavigationEventState.UPDATE
		assertEquals(NavigationEventState.UPDATE, this.navigationEventState);
		// fire a new event
		navigationEventStateEventSource.fireEvent(new EventObject<>(NavigationEventState.VALIDATE));
		// verify that the navigationEventState is set to NavigationEventState.VALIDATE
		assertEquals(NavigationEventState.VALIDATE, this.navigationEventState);
		// fire a new event
		navigationEventStateEventSource.fireEvent(new EventObject<>(NavigationEventState.RESET));
		// verify that the navigationEventState is set to NavigationEventState.RESET
		assertEquals(NavigationEventState.RESET, this.navigationEventState);
	}
}
