package de.alpharogroup.design.pattern.state;


/**
 * The interface {@link IStateMachine}.
 *
 * @param <S>
 *            the generic type of the state object
 */
public interface IStateMachine<S>
{

	/**
	 * Go to the next {@link State} object.
	 */
	void next();

	/**
	 * Go to the previous {@link State} object.
	 */
	void previous();

	/**
	 * Gets the current state.
	 *
	 * @return the current state
	 */
	S getCurrentState();

	/**
	 * Sets the current state.
	 *
	 * @param currentState
	 *            the new current state
	 */
	void setCurrentState(S currentState);

}