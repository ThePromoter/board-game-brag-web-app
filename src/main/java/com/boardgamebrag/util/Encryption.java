package com.boardgamebrag.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encryption {

    private static final byte[] defaultSalt = { 1, 114, -19, 98, -57, -12, 33, -73};
    private static final int defaultIterations = 21;
    private static final String defaultAlgorithm = "PBEWithMD5AndDES";
    public static final byte[] defaultIV = { 1, 114, -19, 98, -57, -12, 33, -73, 1, 114, -19, 98, -57, -12, 33, -73 };
    
    public static byte[] encrypt(byte[] data, String password, byte[] salt, String algorithm) throws Exception
    {
        // Create a key from the supplied passphrase.
        KeySpec ks = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
        SecretKey key = skf.generateSecret(ks);
        
        // Create the algorithm parameters.
        AlgorithmParameterSpec aps = new PBEParameterSpec(salt, defaultIterations);
        
        // Encrypt or decrypt the input.
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, aps);
        
        return cipher.doFinal(data);
    }

    public static byte[] encrypt(byte[] data, String password, byte[] salt)throws Exception
    {       
        return encrypt(data, password, salt, defaultAlgorithm);
    }
    
    public static byte[] encrypt(String data, String password, byte[] salt)throws Exception
    {
        return encrypt(data.getBytes(), password, salt, defaultAlgorithm);
    }

    public static byte[] encrypt(String data, String password)throws Exception
    {
        return encrypt(data.getBytes(), password, defaultSalt, defaultAlgorithm);
    }
    
    public static byte[] encryptAES(byte[] data, byte[] password)throws Exception
    {
        return encryptAES(data, password, defaultIV);
    }
    
    public static byte[] encryptAES(byte[] data, byte[] password, byte[] iv)throws Exception
    {
        //byte[] raw = password.getBytes();
        
        // Create a key from the supplied passphrase.
        SecretKeySpec keySpec = new SecretKeySpec(password, "AES");
        
        // Create the algorithm parameters.
        AlgorithmParameterSpec aps = new IvParameterSpec(iv);
        
        // Instantiate the cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, aps);
        
        return cipher.doFinal(data);
    }

    public static String encryptToBase64(String data, String password, byte[] salt)throws Exception
    {
        
        return new BASE64Encoder().encode(encrypt(data, password, salt));
    }

    public static String encryptToBase64(String data, String password)throws Exception
    {
        return new BASE64Encoder().encode(encrypt(data, password, defaultSalt));
    }
    
//  public static String encryptToHex(String data, String password)throws Exception
//  {
//      return new String(Hex.encodeHex(encrypt(data, password, defaultSalt)));
//  }

    public static byte[] decrypt(byte[] data, String password, byte[] salt, String algorithm)throws Exception
    {
        // Create a key from the supplied passphrase.
        KeySpec ks = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
        SecretKey key = skf.generateSecret(ks);
        
        // Create the algorithm parameters.
        AlgorithmParameterSpec aps = new PBEParameterSpec(salt, defaultIterations);
        
        // Encrypt or decrypt the input.
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, aps);
        
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, String password)throws Exception
    {
        return decrypt(data, password, defaultSalt, defaultAlgorithm);
    }
    
    public static byte[] decryptAES(byte[] data, byte[] password)throws Exception
    {
        return decryptAES(data, password, defaultIV);
    }
    
    public static byte[] decryptAES(byte[] data, byte[] password, byte[] iv) throws Exception
    {
        //byte[] raw = password.getBytes();
        
        // Create a key from the supplied passphrase.
        SecretKeySpec keySpec = new SecretKeySpec(password, "AES"); 
        
        // Create the algorithm parameters.
        AlgorithmParameterSpec aps = new IvParameterSpec(iv);
        
        // Instantiate the cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, aps);
        
        return cipher.doFinal(data);
    }

    public static byte[] decryptFromBase64(String data, String password, byte[] salt)throws Exception
    {       
        return decrypt(new BASE64Decoder().decodeBuffer(data), password, defaultSalt, defaultAlgorithm);
    }

    public static byte[] decryptFromBase64(String data, String password)throws Exception
    {
        return decryptFromBase64(data, password, defaultSalt);
    }
    
//  public static byte[] decryptFromHex(String data, String password)throws Exception
//  {
//      return decrypt(Hex.decodeHex(data.toCharArray()), password, defaultSalt, defaultAlgorithm);
//  }
    
    public static byte[] hash(byte[] data, byte[] salt)throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
            
        md.reset();
        
        md.update(data);
        md.update(salt);
        
        return md.digest();
    }

    public static byte[] hash(String data, String salt)throws NoSuchAlgorithmException, IOException
    {       
        return hash(data.getBytes(), new BASE64Decoder().decodeBuffer(salt));
    }

    public static byte[] hash(String data, byte[] salt)throws NoSuchAlgorithmException
    {       
        return hash(data.getBytes(), salt);
    }

    public static byte[] hash(byte[] data)throws NoSuchAlgorithmException
    {       
        return hash(data, defaultSalt);
    }

    public static byte[] hash(String data)throws NoSuchAlgorithmException
    {       
        return hash(data.getBytes(), defaultSalt);
    }
    
    public static String hashToBase64(byte[] data, byte[] salt)throws NoSuchAlgorithmException
    {
        return new BASE64Encoder().encode(hash(data, salt));
    }
    
    public static byte[] hashToSHA256(byte[] data, byte[] salt)throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        
        digest.reset();
        digest.update(data);
        
        byte[] digestedBytes = digest.digest(salt);
        
        
        return digestedBytes;
    }
    
    public static byte[] hashToSHA256(byte[] data)throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        
        digest.reset();
        digest.update(data);
        
        byte[] digestedBytes = digest.digest();
        
        
        return digestedBytes;
    }

    public static String hashToBase64(String data, String salt) 
    {
        try
        {
            if(salt != null && salt.length() > 0)
            {
                byte[] decodedSalt = new BASE64Decoder().decodeBuffer(salt);
                byte[] hashedData = hash(data.getBytes(), decodedSalt);
            
                return new BASE64Encoder().encode(hashedData);
            }
            else
            {
                return hashToBase64(data);
            }
        } catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static String hashToBase64(String data, byte[] salt)throws NoSuchAlgorithmException
    {       
        return new BASE64Encoder().encode(hash(data.getBytes(), salt));
    }

    public static String hashToBase64(byte[] data)throws NoSuchAlgorithmException
    {       
        return new BASE64Encoder().encode(hash(data, defaultSalt));
    }

    public static String hashToBase64(String data)
    {
        try
        {
            return new BASE64Encoder().encode(hash(data.getBytes(), defaultSalt));
        } catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public static String md5Hex(String s)
    {
        String result = null;
        try
        {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(s.getBytes());
            result = toHex(digest);
        } catch (NoSuchAlgorithmException e)
        {
        }
        return result;
    }
    
    public static String toHex(byte[] a)
    {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (int i = 0; i < a.length; i++)
        {
            sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
            sb.append(Character.forDigit(a[i] & 0x0f, 16));
        }
        return sb.toString();
    }
}
