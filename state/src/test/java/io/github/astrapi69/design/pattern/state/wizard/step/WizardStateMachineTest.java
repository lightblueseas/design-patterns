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
package io.github.astrapi69.design.pattern.state.wizard.step;

import static org.testng.AssertJUnit.assertEquals;

import io.github.astrapi69.design.pattern.state.wizard.WizardState;
import io.github.astrapi69.design.pattern.state.wizard.WizardStateMachine;
import org.testng.annotations.Test;

/**
 * Test class for class {@link WizardStateMachine}.
 */
public class WizardStateMachineTest
{

	/**
	 * Test method for the methods previous and next of the {@link WizardStateMachine}.
	 */
	@Test
	public void testStateMachine()
	{
		WizardState<WizardStateMachine> expected;
		WizardState<WizardStateMachine> actual;
		WizardStateMachine wizardStateMachine = WizardStateMachine.builder().currentState(
			WizardStep.FIRST).build();
		// test case that no operation the current state is WizardStep.FIRST
		expected = WizardStep.FIRST;
		actual = wizardStateMachine.getCurrentState();
		assertEquals(expected, actual);
		// test case that previous operation the current state is still WizardStep.FIRST
		expected = WizardStep.FIRST;
		wizardStateMachine.previous();
		actual = wizardStateMachine.getCurrentState();
		assertEquals(expected, actual);
		// test case that next operation the current state goes from WizardStep.FIRST to WizardStep.SECOND
		expected = WizardStep.SECOND;
		wizardStateMachine.next();
		actual = wizardStateMachine.getCurrentState();
		assertEquals(expected, actual);
		// test case that next operation the current state goes from WizardStep.SECOND to WizardStep.THIRD
		expected = WizardStep.THIRD;
		wizardStateMachine.next();
		actual = wizardStateMachine.getCurrentState();
		assertEquals(expected, actual);
		// test case that next operation the current state is still WizardStep.THIRD because it is the last step
		wizardStateMachine.next();
		actual = wizardStateMachine.getCurrentState();
		assertEquals(expected, actual);

	}

}
