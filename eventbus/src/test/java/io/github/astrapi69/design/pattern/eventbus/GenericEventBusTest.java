package io.github.astrapi69.design.pattern.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GenericEventBusTest
{
	private static long counter;
	private static NavigationEventState navigationEventState;

	@Test public void testApplicationEventBus()
	{
		// ApplicationEventBus
		EventBus guavaEventBus = ApplicationEventBus.getInstance().getApplicationEventBus();
		// register this instance as listener
		guavaEventBus.register(this);
		// post an event
		guavaEventBus.post("increment");
		// verify that the counter is incremented
		assertEquals(1, counter);
		// post an event
		guavaEventBus.post(NavigationEventState.UPDATE);
		// verify that the navigationEventState is set to NavigationEventState.UPDATE
		assertEquals(NavigationEventState.UPDATE, navigationEventState);
		// verify that the counter is not incremented
		assertEquals(1, counter);
		// unregister this instance as listener
		guavaEventBus.unregister(this);
		// post an event
		guavaEventBus.post("increment");
		// verify that the counter is not incremented
		assertEquals(1, counter);
		// register again this instance as listener
		guavaEventBus.register(this);
		// post an event
		guavaEventBus.post("increment");
		// verify that the counter is incremented
		assertEquals(2, counter);
		// post an event
		guavaEventBus.post(NavigationEventState.RESET);
		// verify that the navigationEventState is set to NavigationEventState.RESET
		assertEquals(NavigationEventState.RESET, navigationEventState);
		// post an event
		guavaEventBus.post(NavigationEventState.VALIDATE);
		// verify that the navigationEventState is set to NavigationEventState.VALIDATE
		assertEquals(NavigationEventState.VALIDATE, navigationEventState);
		// unregister this instance as listener
		guavaEventBus.unregister(this);
	}


	@Subscribe
	public void onAddition(String event)
	{
		counter++;
	}

	@Subscribe
	public void onAdditionWithObject(NavigationEventState navigationEventState)
	{
		this.navigationEventState = navigationEventState;
	}
}
