package io.github.astrapi69.design.pattern.state.button;

public interface SigninButtonState<TestButtonStateMachine> extends ButtonState<TestButtonStateMachine>
{
	void onApplicationFileAdded(TestButtonStateMachine context);
	void onChangeWithMasterPassword(TestButtonStateMachine context);

}
