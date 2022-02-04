package io.github.astrapi69.design.pattern.state.component;

import io.github.astrapi69.crypto.algorithm.KeyPairGeneratorAlgorithm;
import io.github.astrapi69.crypto.factories.KeyPairFactory;
import io.github.astrapi69.crypto.key.KeySize;
import io.github.astrapi69.file.search.PathFinder;
import org.testng.annotations.Test;

import javax.swing.JButton;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class BtnSaveStateMachineTest {

    @Test
    public void testState() throws NoSuchAlgorithmException, NoSuchProviderException {
        boolean enabled;
        JButton btnSave;
        PrivateKey expected;
        KeyPair keyPair;

        btnSave = new JButton();
        NewPrivateKeyModelBean modelObject = NewPrivateKeyModelBean.builder().build();
        BtnSaveStateMachine btnSaveStateMachine = BtnSaveStateMachine.builder().component(btnSave)
                .modelObject(modelObject).build();
        btnSaveStateMachine.onInitialize();
        enabled = btnSave.isEnabled();
        assertFalse(enabled);

        modelObject.setFilenameOfPrivateKey("master.key");
        btnSaveStateMachine.onChangeFilename();
        enabled = btnSave.isEnabled();
        assertFalse(enabled);

        modelObject.setPrivateKeyDirectory(PathFinder.getSrcMainResourcesDir());
        btnSaveStateMachine.onChangeDirectory();
        enabled = btnSave.isEnabled();
        assertFalse(enabled);

        keyPair = KeyPairFactory.newKeyPair(KeyPairGeneratorAlgorithm.RSA, KeySize.KEYSIZE_2048);
        expected = keyPair.getPrivate();
        modelObject.setPrivateKey(expected);
        btnSaveStateMachine.onGenerate();
        enabled = btnSave.isEnabled();
        assertTrue(enabled);
    }
}
