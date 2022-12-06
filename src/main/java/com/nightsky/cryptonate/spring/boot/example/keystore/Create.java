package com.nightsky.cryptonate.spring.boot.example.keystore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates a key store for encrypting data in the application's database.
 *
 * @author Chris
 */
public class Create {

    public static final String JCE_KEYSTORE_TYPE = "JCEKS";

    public static final String KEY_NAME = "sample-key";

    public static void main(String [] args) {
        Logger log = LoggerFactory.getLogger(Create.class);
        String keyStorePassword = RandomStringUtils.randomAlphanumeric(64);
        String keyName = String.format("%s-v%d", KEY_NAME, 1);
        String keyPassword = RandomStringUtils.randomAlphanumeric(64);
        File keyStoreFile = new File(FilenameUtils.separatorsToSystem("src/main/resources/key-store.ks"));
        File keyStorePasswordFile = new File(FilenameUtils.separatorsToSystem("src/main/resources/key-store.password"));
        File keyPasswordFile = new File(FilenameUtils.separatorsToSystem("src/main/resources/sample-key-v1.password"));

        if ( keyStoreFile.exists() ) {
            log.info("Key store already exists");
            return;
        }

        // Create an AES key and write it into a key store:
        try ( OutputStream os = new FileOutputStream(keyStoreFile, false) ) {
            KeyStore keyStore = KeyStore.getInstance(JCE_KEYSTORE_TYPE);
            keyStore.load(null, keyStorePassword.toCharArray());

            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(256);

            KeyStore.SecretKeyEntry entry = new KeyStore.SecretKeyEntry(kg.generateKey());
            KeyStore.ProtectionParameter param = new KeyStore.PasswordProtection(keyPassword.toCharArray());
            keyStore.setEntry(keyName, entry, param);

            keyStore.store(os, keyStorePassword.toCharArray());
        } catch (Exception e) {
            log.error("Failed to create key store", e);
        }

        // Save the key store password to a file:
        try ( OutputStream os = new FileOutputStream(keyStorePasswordFile, false) ) {
            os.write(keyStorePassword.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("Failed to create key store password file", e);
        }

        // Save the key password to a file:
        try ( OutputStream os = new FileOutputStream(keyPasswordFile, false) ) {
            os.write(keyPassword.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("Failed to create key password file", e);
        }
    }

}
