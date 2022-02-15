package io.github.astrapi69.design.pattern.eventbus.eventobject;

import io.github.astrapi69.design.pattern.eventbus.ApplicationEventBus;
import io.github.astrapi69.design.pattern.observer.event.EventObject;
import lombok.Getter;
import lombok.Setter;

public class ImportWizardPanel {
    @Getter
    @Setter
    ImportWizardModel model;

    ImportWizardPanel() {
        this.model = ImportWizardModel.builder()
                .bundleAppName("foobar")
                .build();
    }

    public void fireNewEvent() {
        ApplicationEventBus
                .getImportWizardModel().
                fireEvent(EventObject.<ImportWizardModel>builder()
                        .source(this.model)
                        .build());
    }
}
