package io.github.astrapi69.design.pattern.state.component;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The abstact class {@link ComponentStateMachine} can provide states on buttons. For an example see
 * the unit tests
 *
 * @param <C>
 *            the generic type of the component
 * @param <S>
 *            the generic type of the current state
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class ComponentStateMachine<C, S>
{

	/**
	 * the component
	 */
	@NonNull
	C component;

	/**
	 * the current state, can be a model object or a bean
	 */
	S currentState;

	/**
	 * update the component state
	 */
	protected abstract void updateComponentState();

	/**
	 * Sets the enabled flag for the component
	 * 
	 * @param enabled
	 *            the enabled flag for the component
	 */
	protected abstract void setEnabled(boolean enabled);
}
