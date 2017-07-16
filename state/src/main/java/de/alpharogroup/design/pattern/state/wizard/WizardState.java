package de.alpharogroup.design.pattern.state.wizard;

import de.alpharogroup.design.pattern.state.State;

/**
 * The interface {@link WizardState} represents a wizard state.
 */
public interface WizardState<ST> extends State<ST>
{

	/**
	 * Cancel the {@link WizardState}.
	 *
	 * @param input
	 *            the {@link WizardStateMachine} object
	 */
	void cancel(ST input);

	/**
	 * Finish the {@link WizardState}.
	 *
	 * @param input
	 *            the {@link WizardStateMachine} object
	 */
	void finish(ST input);

}
