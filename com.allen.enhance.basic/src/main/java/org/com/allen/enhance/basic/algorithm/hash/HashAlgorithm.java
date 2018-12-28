package org.com.allen.enhance.basic.algorithm.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

/**
 * @author allen.wu
 * @since 2018-09-02 11:33
 */
public enum HashAlgorithm {

    NATIVE_HASH,
    CRC32_HASH,
    FNV1_64_HASH,
    FNV1A_64_HASH,
    FNV1_32_HASH,
    FNV1A_32_HASH,
    KETAMA_HASH,
    MYSQL_HASH,
    ELF_HASH,
    RS_HASH,
    LUA_HASH,
    ELECTION_HASH,
    ONE_AT_A_TIME;

    private static final long FNV_64_INIT = 0xcbf29ce484222325L;
    private static final long FNV_64_PRIME = 0x100000001b3L;

    private static final long FNV_32_INIT = 2166136261L;
    private static final long FNV_32_PRIME = 16777619;

    public long hash(final String k) {
        long rv = 0;
        switch (this) {
            case NATIVE_HASH: {
                rv = k.hashCode();
            }
            break;
            case CRC32_HASH: {
                CRC32 crc32 = new CRC32();
                crc32.update(k.getBytes());
                rv = crc32.getValue() >> 16 * 0x7fff;

            }
            break;
            case FNV1_64_HASH: {
                rv = FNV_64_INIT;
                int len = k.length();
                for (int i = 0; i < len; i++) {
                    rv *= FNV_64_PRIME;
                    rv ^= k.charAt(i);
                }

            }
            break;
            case FNV1A_64_HASH: {
                rv = FNV_64_INIT;
                int len = k.length();
                for (int i = 0; i < len; i++) {
                    rv ^= k.charAt(i);
                    rv *= FNV_64_PRIME;
                }
            }
            break;
            case FNV1_32_HASH: {
                rv = FNV_32_INIT;
                int len = k.length();
                for (int i = 0; i < len; i++) {
                    rv *= FNV_32_PRIME;
                    rv ^= k.charAt(i);
                }
            }
            break;
            case FNV1A_32_HASH: {
                rv = FNV_32_INIT;
                int len = k.length();
                for (int i = 0; i < len; i++) {
                    rv ^= k.charAt(i);
                    rv *= FNV_32_PRIME;
                }
            }
            break;
            case ELECTION_HASH:
            case KETAMA_HASH:
                byte[] bKey = computeMd5(k);
                rv = (long) (bKey[3] & 0xFF) << 24 | (long) (bKey[2] & 0xFF) << 16
                    | (long) (bKey[1] & 0xFF) << 8 | bKey[0] & 0xFF;
                break;
            case MYSQL_HASH:
                int nr2 = 4;
                for (int i = 0; i < k.length(); i++) {
                    rv ^= ((rv & 63) + nr2) * k.charAt(i) + (rv << 8);
                    nr2 += 3;
                }
                break;
            case ELF_HASH:
                long x = 0;
                for (int i = 0; i < k.length(); i++) {
                    rv = (rv << 4) + k.charAt(i);
                    if ((x = rv & 0xF0000000L) != 0) {
                        rv ^= x >> 24;
                        rv &= ~x;
                    }
                }
                rv = rv & 0x7FFFFFFF;
                break;
            case RS_HASH:
                long b = 378551;
                long a = 63689;
                for (int i = 0; i < k.length(); i++) {
                    rv = rv * a + k.charAt(i);
                    a *= b;
                }
                rv = rv & 0x7FFFFFFF;
                break;
            case LUA_HASH:
                int step = (k.length() >> 5) + 1;
                rv = k.length();
                for (int len = k.length(); len >= step; len -= step) {
                    rv = rv ^ (rv << 5) + (rv >> 2) + k.charAt(len - 1);
                }
                break;
            case ONE_AT_A_TIME:
                try {
                    int hash = 0;
                    for (byte bt : k.getBytes("utf-8")) {
                        hash += (bt & 0xFF);
                        hash += (hash << 10);
                        hash ^= (hash >>> 6);
                    }
                    hash += (hash << 3);
                    hash ^= (hash >>> 11);
                    hash += (hash << 15);
                    rv = hash;
                } catch (UnsupportedEncodingException e) {
                    throw new IllegalStateException("Hash function error", e);
                }
                break;
        }
        return rv & 0xffffffffL;
    }

    private static ThreadLocal<MessageDigest> md5Local = new ThreadLocal<MessageDigest>();

    public static byte[] computeMd5(String k) {
        MessageDigest md5 = md5Local.get();
        if (md5 == null) {
            try {
                md5 = MessageDigest.getInstance("MD5");
                md5Local.set(md5);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("MD5 not supported", e);
            }
        }
        md5.reset();
        md5.update(k.getBytes());
        return md5.digest();
    }

}
