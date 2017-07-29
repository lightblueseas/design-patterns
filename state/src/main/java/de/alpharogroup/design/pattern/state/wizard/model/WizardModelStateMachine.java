package de.alpharogroup.design.pattern.state.wizard.model;


import de.alpharogroup.design.pattern.state.wizard.IWizardStateMachine;
import de.alpharogroup.design.pattern.state.wizard.WizardState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class WizardModelStateMachine<T> implements IWizardStateMachine<WizardState<WizardModelStateMachine<T>>>
{
	private WizardState<WizardModelStateMachine<T>> currentState;

	private T modelObject;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void next()
	{
		getCurrentState().goNext(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void previous()
	{
		getCurrentState().goPrevious(this);
	}

	@Override
	public void finish() {
		getCurrentState().finish(this);
	}

	@Override
	public void cancel() {
		getCurrentState().cancel(this);
	}

}
