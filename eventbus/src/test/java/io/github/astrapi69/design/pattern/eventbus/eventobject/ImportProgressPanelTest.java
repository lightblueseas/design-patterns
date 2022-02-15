package io.github.astrapi69.design.pattern.eventbus.eventobject;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertNotNull;

public class ImportProgressPanelTest {


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
        importWizardPanel.setModel(ImportWizardModel.builder()
                        .bundleAppName("blabla")
                .build());
        model = importWizardPanel.getModel();
        assertNotEquals(importWizardModel, model);
        importWizardPanel.fireNewEvent();
        importWizardModel = importProgressPanel.getImportWizardModel();
        assertEquals(importWizardModel, model);
    }
}
