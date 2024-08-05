/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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
 * The abstract class {@link ButtonStateMachine} can provide states on buttons. It manages the
 * current state of a button and defines abstract methods for updating the button state and
 * enabling/disabling the button. For an example, see the unit tests.
 *
 * @param <T>
 *            the type parameter for the button
 * @param <ST>
 *            the type parameter for the state
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
	/**
	 * The current state of the button.
	 */
	ButtonState<ST> current;

	/**
	 * The button associated with this state machine.
	 */
	@NonNull
	T button;

	/**
	 * Updates the state of the button.
	 */
	protected abstract void updateButtonState();

	/**
	 * Sets the enabled state of the button.
	 *
	 * @param enabled
	 *            the new enabled state
	 */
	protected abstract void setEnabled(final boolean enabled);
}
