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
package io.github.astrapi69.design.pattern.state.component;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;

import javax.swing.JButton;

import org.testng.annotations.Test;

import io.github.astrapi69.crypto.algorithm.KeyPairGeneratorAlgorithm;
import io.github.astrapi69.crypto.factory.KeyPairFactory;
import io.github.astrapi69.crypto.key.KeySize;
import io.github.astrapi69.file.search.PathFinder;

public class BtnSaveStateMachineTest
{

	@Test
	public void testState() throws NoSuchAlgorithmException, NoSuchProviderException
	{
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
