package io.github.astrapi69.design.pattern.eventbus.eventobject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link ImportWizardModel} act as a model for the start wizard.<br>
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ImportWizardModel
{

	private String bundleAppName;

	private boolean dbImport;

	private File rootDir;

}
