package com.example.calculadora;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testAdd2Operands() {
        int total = Calculator.calculate("5+3");
        assertEquals("La operación de suma no funciona correctamente", 8, total);
    }

    @Test
    public void testAdd1Operand(){
        int total = Calculator.calculate("4+3+1");
        assertEquals("Las operaciones consecutivas no funcionan correctamente.", 8, total);
    }

    @Test
    public void testMultiply2Operands(){
        int total = Calculator.calculate("4*2");
        assertEquals("Las operaciones de multiplicacion no funcionan correctamente", 8, total);
    }
}