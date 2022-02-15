package io.github.astrapi69.design.pattern.eventbus.eventobject;

import io.github.astrapi69.design.pattern.eventbus.ApplicationEventBus;
import io.github.astrapi69.design.pattern.observer.event.EventListener;
import io.github.astrapi69.design.pattern.observer.event.EventObject;
import io.github.astrapi69.design.pattern.observer.event.EventSource;
import lombok.Getter;

public class ImportProgressPanel implements
        EventListener<EventObject<ImportWizardModel>> {

    @Getter
    ImportWizardModel importWizardModel;

    ImportProgressPanel() {
        // register as listener...
        final EventSource<EventObject<ImportWizardModel>> eventSource = ApplicationEventBus
                .getImportWizardModel();
        eventSource.add(this);
    }

    @Override
    public void onEvent(EventObject<ImportWizardModel> event) {
        this.importWizardModel = event.getSource();
    }
}
