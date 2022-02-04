package io.github.astrapi69.design.pattern.state.component;

import java.io.File;
import java.security.PrivateKey;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import io.github.astrapi69.crypto.key.KeySize;

/**
 * The class {@link NewPrivateKeyModelBean}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewPrivateKeyModelBean
{
	int keyLength;

	@Builder.Default
	KeySize keySize = KeySize.KEYSIZE_2048;

	PrivateKey privateKey;

	/** The private key directory */
	File privateKeyDirectory;

	String filenameOfPrivateKey;

	/** The private key file */
	File privateKeyFile;
}
