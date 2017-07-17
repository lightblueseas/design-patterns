package de.alpharogroup.design.pattern.state.wizard;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import de.alpharogroup.design.pattern.state.StateMachine;

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
		final WizardStateMachine stateMachine = WizardStateMachine.builder().currentState(CustomState.FIRST).build();

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
