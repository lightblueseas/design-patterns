package de.alpharogroup.design.pattern.state.wizard.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link WizardModel} act as a model for a wizard. This is only for example wizard model.
 * You can create a specific wizard model to your requirements.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class WizardModel
{
	boolean validNext;

	boolean validPrevious;

	boolean validCancel;

	boolean validFinish;
}
