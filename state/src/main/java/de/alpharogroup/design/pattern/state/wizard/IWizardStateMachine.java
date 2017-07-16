package de.alpharogroup.design.pattern.state.wizard;

import de.alpharogroup.design.pattern.state.IStateMachine;

public interface IWizardStateMachine<S> extends IStateMachine<S>
{
	void finish();

	void cancel();
}