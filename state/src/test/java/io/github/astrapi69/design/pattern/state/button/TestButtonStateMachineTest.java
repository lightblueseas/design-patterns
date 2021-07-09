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
