package com.oumar.learn.application;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

public class StringUtils {

    public static String passwordHash(String password){
        String hashPass = null;
        try {
            byte[] salt = new byte[128];
            Random random = new Random();
            random.nextBytes(salt);
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            hashPass = enc.encodeToString(hash);
        }catch (InvalidKeySpecException ikse){
            ikse.printStackTrace();
        }catch (NoSuchAlgorithmException nsae){
            nsae.printStackTrace();
        }
        return hashPass;
    }
}
