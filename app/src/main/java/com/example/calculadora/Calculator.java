package com.example.calculadora;

public class Calculator {

    public static int calculate(String operacion) {
        if (!operacion.contains("+") && !operacion.contains("-") && !operacion.contains("*")) {
            try {
                return Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                return -1;
            }
        } else {
            int indiceMas = operacion.lastIndexOf("+");
            int indiceMenos = operacion.lastIndexOf("-");
            int indiceMultiplicacion = operacion.lastIndexOf("*");
            int indiceOperador;

            // Encuentra el índice del operador
            if (indiceMultiplicacion != -1) {
                indiceOperador = indiceMultiplicacion;
            } else if (indiceMas != -1 && indiceMenos != -1) {
                indiceOperador = Math.max(indiceMas, indiceMenos);
            } else {
                indiceOperador = (indiceMas != -1) ? indiceMas : indiceMenos;
            }

            String string1 = operacion.substring(0, indiceOperador);
            String string2 = operacion.substring(indiceOperador + 1);

            int resultado1 = calculate(string1);
            int resultado2 = calculate(string2);

            if (resultado1 == -1 || resultado2 == -1) {
                return -1;
            }

            char o = operacion.charAt(indiceOperador);
            switch (o) {
                case '+':
                    return resultado1 + resultado2;
                case '-':
                    return resultado1 - resultado2;
                case '*':
                    return resultado1 * resultado2;
                default:
                    return -1;
            }
        }
    }


}
