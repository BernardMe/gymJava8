package org.learnit.cryptogram;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.learnit.weight.WeightRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

@Slf4j
public class EncryptUtil {
    private static final Logger log = LoggerFactory.getLogger(WeightRandom.class);

    private static final String KEY_ALGORITHM = "AES";
    /**
     * 算法/模式/补码方式
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String CODE = "utf-8";

    @Setter
    @Getter
    public static String encryptKey;

    public static String encrypt(String content) {
        return encrypt(content, encryptKey);
    }

    /**
     * 加密
     *
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(String content, String key) {
        try {
            byte[] encrypted = encrypt2bytes(content, key);
            return Base64Utils.encodeToString(encrypted);
        } catch (Exception e) {
            log.error("failed to encrypt: {} of {}", content, e);
            return null;
        }
    }

    public static byte[] encrypt2bytes(String content, String key) {
        try {
            byte[] raw = key.getBytes(CODE);
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return cipher.doFinal(content.getBytes(CODE));
        } catch (Exception e) {
            log.error("failed to encrypt: {} of {}", content, e);
            return null;
        }
    }

    public static String decrypt(String content) {
        try {
            return decrypt(content, encryptKey);
        } catch (Exception e) {
            log.error("failed to decrypt: {}, e: {}", content, e);
            return null;
        }
    }

    /**
     * 解密
     *
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static String decrypt(String content, String key) throws Exception {
        return decrypt(Base64Utils.decodeFromString(content), key);
    }

    public static String decrypt(byte[] content, String key) throws Exception {
        if (key == null) {
            log.error("AES key should not be null");
            return null;
        }

        byte[] raw = key.getBytes(CODE);
        SecretKeySpec keySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        try {
            byte[] original = cipher.doFinal(content);
            return new String(original, CODE);
        } catch (Exception e) {
            log.error("failed to decrypt content: {}/ key: {}, e: {}", content, key, e);
            return null;
        }
    }
}