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

import io.github.astrapi69.design.pattern.state.wizard.BaseWizardWizardState;
import org.testng.annotations.Test;

import io.github.astrapi69.design.pattern.state.wizard.WizardStateMachine;

public class WizardModelWizardStateMachineTest
{

	/**
	 * Test method for the methods previous and next of the {@link WizardStateMachine}.
	 */
	@Test
	public void testWizardStateMachine()
	{
		BaseWizardModelWizardState expected;
		BaseWizardWizardState<BaseWizardModelWizardStateMachine<WizardModel>> actual;
		final BaseWizardModelWizardStateMachine<WizardModel> stateMachine = BaseWizardModelWizardStateMachine
			.<WizardModel> builder().currentState(BaseWizardModelWizardState.FIRST)
			.modelObject(WizardModel.builder().build()).build();

		expected = BaseWizardModelWizardState.FIRST;
		stateMachine.previous();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = BaseWizardModelWizardState.FIRST;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// next not valid
		expected = BaseWizardModelWizardState.FIRST;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set next to valid
		stateMachine.getModelObject().setValidNext(true);
		expected = BaseWizardModelWizardState.SECOND;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		expected = BaseWizardModelWizardState.SECOND;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set next to valid
		stateMachine.getModelObject().setValidNext(true);
		expected = BaseWizardModelWizardState.THIRD;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// cancel not valid
		expected = BaseWizardModelWizardState.THIRD;
		stateMachine.cancel();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set cancel to valid
		stateMachine.getModelObject().setValidCancel(true);
		expected = BaseWizardModelWizardState.CANCELED;
		stateMachine.cancel();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// finish not valid
		expected = BaseWizardModelWizardState.CANCELED;
		stateMachine.finish();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set cancel to valid
		stateMachine.getModelObject().setValidFinish(true);

		expected = BaseWizardModelWizardState.FINISHED;
		stateMachine.finish();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

	}

}
