package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IdentifierTest {

    private Identifier identifier;

    @Before
    public void setUp() {
        identifier = new Identifier();
    }

    // Deve ter de 1 a 6 caracteres de comprimento (inclusive).
    @Test
    public void deveAceitarIdentificadorComComprimentoValido() {
        assertTrue(identifier.validateIdentifier("a"));
    }

    @Test
    public void deveRejeitarIdentificadorComComprimentoInvalido() {
        assertFalse(identifier.validateIdentifier("Abcdefg"));
    }

    // Deve começar com uma letra (a-z ou A-Z);
    @Test
    public void deveAceitarIdentificadorQueComecaComLetra() {
        assertTrue(identifier.validateIdentifier("A1b2c3"));
    }

    @Test
    public void deveRejeitarIdentificadorQueNaoComecaComLetra() {
        assertFalse(identifier.validateIdentifier("1abcde"));
    }

    // Pode conter apenas letras ou dígitos;
    @Test
    public void deveAceitarIdentificadorComLetrasEDigitos() {
        assertTrue(identifier.validateIdentifier("A1b2c3"));
    }

    @Test
    public void deveRejeitarIdentificadorComCaracteresEspeciais() {
        assertFalse(identifier.validateIdentifier("A@b"));
    }

    // Testa condição: id == null (true)
    @Test
    public void deveRejeitarIdentificadorNulo() {
        assertFalse(identifier.validateIdentifier(null));
    }

    // Testa condição: id.isEmpty() (true)
    @Test
    public void deveRejeitarIdentificadorVazio() {
        assertFalse(identifier.validateIdentifier(""));
    }

    // Testa condição: id.length() <= 6 - comprimento válido máximo
    @Test
    public void deveAceitarIdentificadorCom6Caracteres() {
        assertTrue(identifier.validateIdentifier("Abcdef")); // 6 caracteres
    }

    // Testa condição: !Character.isLetter(firstChar) - começa com caractere especial
    @Test
    public void deveRejeitarIdentificadorQueComeçaComCaractereEspecial() {
        assertFalse(identifier.validateIdentifier("@abc"));
    }

    // Testa condição: Character.isLetter(firstChar) - começa com letra minúscula
    @Test
    public void deveAceitarIdentificadorQueComeçaComLetraMinuscula() {
        assertTrue(identifier.validateIdentifier("abc"));
    }

    // Testa condição: Character.isLetter(firstChar) - começa com letra maiúscula
    @Test
    public void deveAceitarIdentificadorQueComeçaComLetraMaiuscula() {
        assertTrue(identifier.validateIdentifier("Abc"));
    }

    // Testa condição: !Character.isLetterOrDigit(c) - caractere especial no final
    @Test
    public void deveRejeitarIdentificadorComCaractereEspecialNoFinal() {
        assertFalse(identifier.validateIdentifier("Ab@"));
    }

    // Testa condição: !Character.isLetterOrDigit(c) - espaço no identificador
    @Test
    public void deveRejeitarIdentificadorComEspaco() {
        assertFalse(identifier.validateIdentifier("A b"));
    }

    // Testa condição: Character.isLetterOrDigit(c) - apenas letras
    @Test
    public void deveAceitarIdentificadorApenasComLetras() {
        assertTrue(identifier.validateIdentifier("AbcDef"));
    }

    // Testa condição: Character.isLetterOrDigit(c) - apenas dígitos após primeira letra
    @Test
    public void deveAceitarIdentificadorComDigitosAposLetra() {
        assertTrue(identifier.validateIdentifier("A12345"));
    }

    // Exatamente no limite inferior de comprimento
    @Test
    public void deveAceitarIdentificadorComprimentoLimiteInferior() {
        assertTrue(identifier.validateIdentifier("X")); // 1 caractere
    }

    // Exatamente no limite superior de comprimento
    @Test
    public void deveAceitarIdentificadorComprimentoLimiteSuperior() {
        assertTrue(identifier.validateIdentifier("X12345")); // 6 caracteres
    }

    // Logo acima do limite superior de comprimento
    @Test
    public void deveRejeitarIdentificadorLogoAcimaDoLimite() {
        assertFalse(identifier.validateIdentifier("X123456")); // 7 caracteres
    }
}