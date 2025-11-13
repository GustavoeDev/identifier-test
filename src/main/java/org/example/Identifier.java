package org.example;

public class Identifier {

    public boolean validateIdentifier(String id) {
        // Verifica se é nulo ou vazio
        if (id == null || id.isEmpty()) {
            return false;
        }

        // Verifica o comprimento (1 a 6 caracteres)
        if (id.length() > 6) {
            return false;
        }

        // Verifica se o primeiro caractere é uma letra
        char firstChar = id.charAt(0);
        if (!Character.isLetter(firstChar)) {
            return false;
        }

        // Verifica se todos os caracteres são letras ou dígitos
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }
}