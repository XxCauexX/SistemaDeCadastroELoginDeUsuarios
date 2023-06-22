/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author cauea
 */
public class ValidarEmail {
    public static boolean validarEnderecoEmail(String email) {
    boolean emailValido = false;
    if (email != null && email.length() > 0) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            emailValido = true;
        }
    }
    return emailValido;
}
    
}
