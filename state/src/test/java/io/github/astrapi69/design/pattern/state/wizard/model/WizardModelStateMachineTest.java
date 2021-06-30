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
package io.github.astrapi69.design.pattern.state.wizard.model;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import io.github.astrapi69.design.pattern.state.StateMachine;
import io.github.astrapi69.design.pattern.state.wizard.WizardState;

public class WizardModelStateMachineTest
{

	/**
	 * Test method for the methods previous and next of the {@link StateMachine}.
	 */
	@Test
	public void testWizardStateMachine()
	{
		WizardModelState expected;
		WizardState<WizardModelStateMachine<WizardModel>> actual;
		final WizardModelStateMachine<WizardModel> stateMachine = WizardModelStateMachine
			.<WizardModel> builder().currentState(WizardModelState.FIRST)
			.modelObject(WizardModel.builder().build()).build();

		expected = WizardModelState.FIRST;
		stateMachine.previous();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = WizardModelState.FIRST;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// next not valid
		expected = WizardModelState.FIRST;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set next to valid
		stateMachine.getModelObject().setValidNext(true);
		expected = WizardModelState.SECOND;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = WizardModelState.SECOND;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set next to valid
		stateMachine.getModelObject().setValidNext(true);
		expected = WizardModelState.THIRD;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// cancel not valid
		expected = WizardModelState.THIRD;
		stateMachine.cancel();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set cancel to valid
		stateMachine.getModelObject().setValidCancel(true);
		expected = WizardModelState.CANCELED;
		stateMachine.cancel();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// finish not valid
		expected = WizardModelState.CANCELED;
		stateMachine.finish();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set cancel to valid
		stateMachine.getModelObject().setValidFinish(true);

		expected = WizardModelState.FINISHED;
		stateMachine.finish();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

	}

}
