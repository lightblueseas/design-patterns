package io.github.astrapi69.design.pattern.state.button;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TestButtonStateMachine extends ButtonStateMachine<Button, TestButtonStateMachine>
	implements
		SigninButtonState<TestButtonStateMachine>
{
	SigninButtonState<TestButtonStateMachine> current;
	boolean withMasterPassword;
	boolean applicationFilePresent;

	@Override
	public void onApplicationFileAdded(TestButtonStateMachine context)
	{
		boolean applicationFilePresent = !isApplicationFilePresent();
		setApplicationFilePresent(applicationFilePresent);
		updateButtonState();
	}

	@Override
	public void onChangeWithMasterPassword(TestButtonStateMachine context)
	{
		boolean withMasterPassword = !isWithMasterPassword();
		setWithMasterPassword(withMasterPassword);
		updateButtonState();
	}

	protected void updateButtonState()
	{
		if (applicationFilePresent && withMasterPassword)
		{
			current = ButtonStateEnum.ENABLED;
			setEnabled(true);
		}
		else
		{
			current = ButtonStateEnum.DISABLED;
			setEnabled(false);
		}
	}

	public void setEnabled(boolean b)
	{
		button.setEnabled(b);
	}

}
