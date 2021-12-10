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
