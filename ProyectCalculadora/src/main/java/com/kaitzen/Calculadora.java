package com.kaitzen;

public class Calculadora {
    public Integer sumar(Integer num1, Integer num2) {
        Integer result = num1 + num2;
        logResultado("suma", result);
        return result;
    }

    public Integer restar(Integer num1, Integer num2) {
        Integer result = num1 - num2;
        logResultado("resta", result);
        return result;
    }

    public Integer multiplicar(Integer num1, Integer num2) {
        Integer result = 0;
        for (int x=0;x<num2;x++) {
            result += num1;
        }
        logResultado("multiplicación", result);
        return result;
    }

    public Integer dividir(Integer num1, Integer num2) {
        Integer result = 0;
        while (num1>0) {
            num1 -= num2;
            result++;
        }
        if (num1<0) {
            result--;
        }
        logResultado("división", result);
        return result;
    }

    public Float dividirCompleto(Integer num1, Integer num2) {
        Float result = new Float(num1.toString()) / new Float(num2.toString());
        logResultado("división", result);
        return result;
    }

    public Float dividirCompletoDecimal(Float num1, Float num2) {
        Float result = num1 / num2;
        System.out.println(String.format("El resultado de la división decimal es %1$f", result));
        System.out.println(String.format("El resultado de la división decimal es %1$.3f", result));
        return result;
    }

    private void logResultado(String operacion, Object resultado) {
        String salida = String.format("El resultado de la %1$s es %2$s", operacion, resultado.toString());
        System.out.println(salida);
    }
}
