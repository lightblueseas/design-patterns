package de.alpharogroup.design.pattern.state.wizard.model;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import de.alpharogroup.design.pattern.state.StateMachine;
import de.alpharogroup.design.pattern.state.wizard.WizardState;

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
		// reset next
		stateMachine.getModelObject().setValidNext(false);

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
		// reset next
		stateMachine.getModelObject().setValidNext(false);

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
