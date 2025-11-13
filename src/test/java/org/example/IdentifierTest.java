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
}