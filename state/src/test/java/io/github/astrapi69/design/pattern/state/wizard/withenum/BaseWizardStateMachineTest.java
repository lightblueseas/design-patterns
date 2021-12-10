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
package io.github.astrapi69.design.pattern.state.wizard.withenum;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import io.github.astrapi69.design.pattern.state.wizard.BaseWizardWizardState;
import io.github.astrapi69.design.pattern.state.wizard.BaseWizardWizardStateMachine;
import io.github.astrapi69.design.pattern.state.wizard.WizardStateMachine;

public class BaseWizardStateMachineTest
{


	/**
	 * Test method for the methods previous and next of the {@link WizardStateMachine}.
	 */
	@Test
	public void testWizardStateMachine()
	{
		EnumBaseWizardWizardState expected;
		BaseWizardWizardState<BaseWizardWizardStateMachine> actual;
		final BaseWizardWizardStateMachine stateMachine = BaseWizardWizardStateMachine.builder()
			.currentState(EnumBaseWizardWizardState.FIRST).build();

		expected = EnumBaseWizardWizardState.FIRST;
		stateMachine.previous();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = EnumBaseWizardWizardState.FIRST;
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = EnumBaseWizardWizardState.SECOND;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = EnumBaseWizardWizardState.THIRD;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = EnumBaseWizardWizardState.CANCELED;
		stateMachine.cancel();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = EnumBaseWizardWizardState.FINISHED;
		stateMachine.finish();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

	}

}
