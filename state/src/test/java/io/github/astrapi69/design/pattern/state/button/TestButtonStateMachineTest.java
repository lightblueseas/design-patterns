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
package io.github.astrapi69.design.pattern.state.button;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

/**
 * Test class for class {@link TestButtonStateMachine}
 */
public class TestButtonStateMachineTest
{

	@Test
	public void testState()
	{
		ButtonStateEnum expected;
		SigninButtonState<TestButtonStateMachine> actual;
		TestButtonStateMachine buttonStateMachine = TestButtonStateMachine.builder()
			.button(Button.builder().text("OK").enabled(false).build())
			.current(ButtonStateEnum.DISABLED).build();
		// test case that no operation the current state is initial ButtonStateEnum.DISABLED
		expected = ButtonStateEnum.DISABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertFalse(buttonStateMachine.getButton().isEnabled());
		// test case that add application file the current state is still ButtonStateEnum.DISABLED
		// because both application file and password should be true for get enabled state
		buttonStateMachine.onApplicationFileAdded(buttonStateMachine);
		expected = ButtonStateEnum.DISABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertFalse(buttonStateMachine.getButton().isEnabled());
		// test case both application file and password are true so the current state is
		// ButtonStateEnum.ENABLED
		buttonStateMachine.onChangeWithMasterPassword(buttonStateMachine);
		expected = ButtonStateEnum.ENABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertTrue(buttonStateMachine.getButton().isEnabled());
		// toggle password to false will cause the disable state transition
		buttonStateMachine.onChangeWithMasterPassword(buttonStateMachine);
		expected = ButtonStateEnum.DISABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertFalse(buttonStateMachine.getButton().isEnabled());
		// toggle password to true will cause the enable state transition
		buttonStateMachine.onChangeWithMasterPassword(buttonStateMachine);
		expected = ButtonStateEnum.ENABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertTrue(buttonStateMachine.getButton().isEnabled());
	}
}
