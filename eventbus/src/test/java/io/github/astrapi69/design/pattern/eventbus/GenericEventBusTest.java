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

public class GenericEventBusTest
{
	private static long counter;
	private static NavigationEventState navigationEventState;

	@Test
	public void testApplicationEventBus()
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
		GenericEventBusTest.navigationEventState = navigationEventState;
	}
}
