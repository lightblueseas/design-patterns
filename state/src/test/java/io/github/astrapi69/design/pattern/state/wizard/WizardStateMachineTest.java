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
package io.github.astrapi69.design.pattern.state.wizard;

import static org.testng.AssertJUnit.assertEquals;

import io.github.astrapi69.design.pattern.state.wizard.WizardState;
import io.github.astrapi69.design.pattern.state.wizard.WizardStateMachine;
import org.testng.annotations.Test;

import io.github.astrapi69.design.pattern.state.StateMachine;

public class WizardStateMachineTest
{


	/**
	 * Test method for the methods previous and next of the {@link StateMachine}.
	 */
	@Test
	public void testWizardStateMachine()
	{
		CustomState expected;
		WizardState<WizardStateMachine> actual;
		final WizardStateMachine stateMachine = WizardStateMachine.builder()
			.currentState(CustomState.FIRST).build();

		expected = CustomState.FIRST;
		stateMachine.previous();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = CustomState.FIRST;
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = CustomState.SECOND;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = CustomState.THIRD;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = CustomState.CANCELED;
		stateMachine.cancel();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = CustomState.FINISHED;
		stateMachine.finish();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

	}

}
