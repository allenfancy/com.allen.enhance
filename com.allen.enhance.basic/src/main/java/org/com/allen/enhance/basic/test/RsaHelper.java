package org.com.allen.enhance.basic.test;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import sun.misc.BASE64Decoder;

/**
 * Created by tommy on 15-11-22.
 */
public class RsaHelper {
    private final static Logger LOGGER = LoggerFactory.getLogger(RsaHelper.class);
    private final String PUBLIC_FORMAT = "PUBLIC KEY";
    private final String PRIVATE_FORMAT = "PRIVATE KEY";

    private final String KEY_CONTENT_REGEX = "----.*----\\n";

    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;

    private static ThreadLocal<Cipher> cipherThreadLocal = new ThreadLocal<Cipher>() {
        @Override
        protected Cipher initialValue() {
            try {
                LOGGER.info("This RsaHelper in thread:{}", Thread.currentThread().getId());
                return Cipher.getInstance("RSA/ECB/PKCS1PADDING", new BouncyCastleProvider());
            } catch (Exception e) {
                return null;
            }
        }
    };

    public static Cipher getCipherInstance()
            throws NoSuchAlgorithmException, NoSuchPaddingException {
        return cipherThreadLocal.get();
    }

    public RsaHelper() {}


    public void loadPrivateKey(String privateKeyStr) throws Exception {
        privateKeyStr = privateKeyStr.replaceAll(KEY_CONTENT_REGEX, "");
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] buffer = base64Decoder.decodeBuffer(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            this.privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("no such algorithm.", e);
        } catch (InvalidKeySpecException e) {
            throw new Exception("invalid private key", e);
        } catch (IOException e) {
            throw new Exception("private key read failed.", e);
        }
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     * @throws Exception 加载公钥时产生的异常
     */
    public void loadPublicKey(String publicKeyStr) throws Exception {
        publicKeyStr = publicKeyStr.replaceAll(KEY_CONTENT_REGEX, "");
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] buffer = base64Decoder.decodeBuffer(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            this.publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("no such algorithm.", e);
        } catch (InvalidKeySpecException e) {
            throw new Exception("invalid public key", e);
        } catch (IOException e) {
            throw new Exception("public key read failed.", e);
        }
    }

    /**
     * 解密过程
     *
     * @param privateKey 私钥
     * @param encrypted 密文数据
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public String decrypt(RSAPrivateKey privateKey, String encrypted) throws Exception {
        if (privateKey == null) {
            throw new Exception("privateKey is empty.");
        }
        Cipher cipher = null;
        try {
            cipher = getCipherInstance();
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output = cipher.doFinal(Base64.decodeBase64(encrypted));
            return new String(output);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("no such algorithm.", e);
        } catch (NoSuchPaddingException e) {
            throw new Exception("no such padding.", e);
        } catch (InvalidKeyException e) {
            throw new Exception("invalid private key", e);
        } catch (IllegalBlockSizeException e) {
            throw new Exception("illegal block size", e);
        } catch (BadPaddingException e) {
            throw new Exception("bad padding", e);
        }
    }

    /**
     * 加密过程
     *
     * @param publicKey 公钥
     * @param date 明文数据
     * @return
     * @throws Exception 加密过程中的异常信息
     */
    public String encrypt(RSAPublicKey publicKey, String date) throws Exception {
        if (publicKey == null) {
            throw new Exception("publicKey is empty.");
        }
        Cipher cipher = null;
        try {
            cipher = getCipherInstance();
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(date.getBytes());
            return Base64.encodeBase64String(output);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("no such algorithm.", e);
        } catch (NoSuchPaddingException e) {
            throw new Exception("no such padding.", e);
        } catch (InvalidKeyException e) {
            throw new Exception("invalid public key", e);
        } catch (IllegalBlockSizeException e) {
            throw new Exception("illegal block size", e);
        } catch (BadPaddingException e) {
            throw new Exception("bad padding", e);
        }
    }

    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    public String getPublic() {
        return getPemFormat(PUBLIC_FORMAT, getPublicKey());
    }

    private String getPemFormat(String type, Key rsaKey) {
        StringWriter write = new StringWriter();
        PemObject pemObject = new PemObject(type, rsaKey.getEncoded());
        PemWriter pemWriter = new PemWriter(write);
        try {
            pemWriter.writeObject(pemObject);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pemWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return write.toString();
    }

    public String getPrivate() {
        return getPemFormat(PRIVATE_FORMAT, getPrivateKey());
    }

    public static void main(String[] args) throws Exception {

    }

}
