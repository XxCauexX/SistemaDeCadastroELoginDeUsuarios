/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author cauea
 */
public class SenhaFormatada {
    public static String formatarParaMD5(String password) {
        try {
            // Cria uma instância de MessageDigest com o algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Converte a senha em um array de bytes
            byte[] passwordBytes = password.getBytes();
            
            // Calcula o hash MD5 da senha
            byte[] digest = md.digest(passwordBytes);
            
            // Converte o resultado para uma representação hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
