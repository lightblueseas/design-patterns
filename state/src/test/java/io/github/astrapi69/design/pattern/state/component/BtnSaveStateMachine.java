package io.github.astrapi69.design.pattern.state.component;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.swing.JButton;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BtnSaveStateMachine
        extends
        AbstractJComponentStateMachine<JButton, BtnSaveComponentState>
        implements
        BtnSaveComponentState {
    NewPrivateKeyModelBean modelObject;

    @Override
    protected void updateComponentState() {
        if(modelObject == null) {
            setEnabled(false);
            return;
        }
        boolean filenameOfPrivateKeyPresent = modelObject.getFilenameOfPrivateKey() != null;
        boolean privateKeyDirectoryPresent = modelObject.getPrivateKeyDirectory() != null;
        boolean privateKeyObjectPresent = modelObject.getPrivateKey() != null;
        boolean keySizePresent = modelObject.getKeySize() != null;
        if (filenameOfPrivateKeyPresent && privateKeyDirectoryPresent && privateKeyObjectPresent
                && keySizePresent) {
            setEnabled(true);
            return;
        }
        setEnabled(false);
    }


    @Override
    public void onInitialize() {
        updateComponentState();
    }

    @Override
    public void onGenerate() {
        updateComponentState();
    }

    @Override
    public void onClear() {
        updateComponentState();
    }

    @Override
    public void onChangeFilename() {
        updateComponentState();
    }

    @Override
    public void onChangeDirectory() {
        updateComponentState();
    }

    @Override
    public void onChangeKeySize() {
        updateComponentState();
    }

    public boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof Optional) {
            return !((Optional<?>) obj).isPresent();
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        }

        // else
        return false;
    }
}
