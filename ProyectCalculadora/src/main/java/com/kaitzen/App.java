package com.kaitzen;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculadora calc = new Calculadora();
        System.out.println("SUMA");
        calc.sumar(2, 3);
        System.out.println("RESTA");
        calc.restar(5, 9);
        System.out.println("MULTI");
        calc.multiplicar(5, 10);
        System.out.println("DIV");
        calc.dividir(8, 7);
        System.out.println("DIV /");
        calc.dividirCompleto(8, 7);
        System.out.println("DIV DEC");
        calc.dividirCompletoDecimal(8f, 7f);
    }
}
