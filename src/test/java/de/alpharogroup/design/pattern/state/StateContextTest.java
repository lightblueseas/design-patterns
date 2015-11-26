package de.alpharogroup.design.pattern.state;

import org.testng.annotations.Test;

public class StateContextTest {

	@Test
	public void testStart() throws InterruptedException {
		final StateContext context = new StateContext();
		context.start();
		Thread.sleep(1000);
		context.pause();
		Thread.sleep(2000);
		context.start();
		Thread.sleep(3000);
		context.stop();
		context.reset();
		context.start();
	}

}
