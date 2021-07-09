package io.github.astrapi69.design.pattern.state.button;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The abstact class {@link ButtonStateMachine} can provide states on buttons. For an example see
 * the unit tests
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class ButtonStateMachine<T, ST> implements ButtonState<ST>
{
	ButtonState<ST> current;
	@NonNull
	T button;

	protected abstract void updateButtonState();

	protected abstract void setEnabled(boolean b);
}
