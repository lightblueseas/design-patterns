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
package io.github.astrapi69.design.pattern.eventbus.eventobject;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertNotNull;

public class ImportProgressPanelTest
{


	@Test
	public void testApplicationEventBus()
	{
		ImportProgressPanel importProgressPanel = new ImportProgressPanel();
		ImportWizardModel importWizardModel = importProgressPanel.getImportWizardModel();
		assertNull(importWizardModel);
		ImportWizardPanel importWizardPanel = new ImportWizardPanel();
		importWizardPanel.fireNewEvent();
		importWizardModel = importProgressPanel.getImportWizardModel();
		assertNotNull(importWizardModel);
		ImportWizardModel model = importWizardPanel.getModel();
		assertEquals(importWizardModel, model);
		importWizardPanel.setModel(ImportWizardModel.builder().bundleAppName("blabla").build());
		model = importWizardPanel.getModel();
		assertNotEquals(importWizardModel, model);
		importWizardPanel.fireNewEvent();
		importWizardModel = importProgressPanel.getImportWizardModel();
		assertEquals(importWizardModel, model);
	}
}
