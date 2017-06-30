package com.kaitzen;

import java.io.IOException;
import java.util.Scanner;

public class App 
{
	private static final boolean CLEAR_SCREEN = true;
	static Scanner scanner = new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	Integer mainOption = null;
        do {
            System.out.print("Ingrese:\n"
            		+ "1 - Ingresar cliente\n"
            		+ "2 - Ingresar auto\n"
            		+ "3 - Ingresar alquiler\n"
            		+ "4 - Buscar cliente\n"
            		+ "5 - Buscar auto\n"
            		+ "6 - Buscar alquiler\n"
            		+ "0 - Salir\n"
            		+ "Opcion: ");
            mainOption = scanner.nextInt();
            if (mainOption != 0){
            	switch (mainOption) {
            	case 1:
            		inputCustomer();
            		break;
            	case 2:
            		inputCar();
            		break;
            	case 3:
            		inputRent();
            		break;
            	case 4:
            		searchCustomer();
            		break;
            	case 5:
            		searchCar();
            		break;
            	case 6:
            		searchRent();
            		break;
            	default:
            		System.out.println("Opcion no valida");
            	}
            }
        } while (mainOption != 0);
    }

    private static void inputCustomer() {
		Integer again = null;
		do {
			//leer por consola y asignar valores al customer y llamar al método save()
			again = shouldInputAgain();
		} while (again != 0);
	}
    
    private static void inputCar() {
		Integer again = null;
		do {
			//leer por consola y asignar valores al car y llamar al método save()
			again = shouldInputAgain();
		} while (again != 0);
	}
    
    private static void inputRent() {
		Integer again = null;
		do {
			//leer por consola y asignar valores al rent y llamar al método save()
			again = shouldInputAgain();
		} while (again != 0);
	}
    
    private static void searchCustomer() {
    	Integer again = null;
		do {
			System.out.print("Ingrese el atributo por el cual buscar (nombre, edad, dni): ");
            String atributo = scanner.nextLine();
            System.out.print("Ingrese el valor que debe tener: ");
            String valor = scanner.nextLine();
            //llamar al search() salvo que pase el DNI y ahi buscamos el valor exacto
            //mostrar los datos del customer (ayuda: método toString)
			again = shouldSearchAgain();
			if (again == 2) {
				//leer por consola y asignar valores al customer y llamar al método update() 
			}
		} while (again != 0);
	}
    
    private static void searchCar() {
    	Integer again = null;
		do {
			System.out.print("Ingrese el atributo por el cual buscar (dominio, puertas, color, combustible, km, equipaje, pasajeros): ");
            String atributo = scanner.nextLine();
            System.out.print("Ingrese el valor que debe tener: ");
            String valor = scanner.nextLine();
            //llamar al search() salvo que pase el dominio y ahi buscamos el valor exacto
            //mostrar los datos del car (ayuda: método toString)
            again = shouldSearchAgain();
            if (again == 2) {
				//leer por consola y asignar valores al car y llamar al método update() 
			}
		} while (again != 0);
	}
    
    private static void searchRent() {
    	Integer again = null;
		do {
			System.out.print("Ingrese el DNI del cliente: ");
            String documento = scanner.nextLine();
            System.out.print("Ingrese el dominio del automóvil: ");
            String dominio = scanner.nextLine();
            //llamar al search con los valores recibidos
            //mostrar los datos del car (ayuda: método toString)
            again = shouldSearchAgain();
            if (again == 2) {
				//leer por consola y asignar valores al rent y llamar al método update() 
			}
		} while (again != 0);
	}
    
    private static Integer shouldInputAgain() {
    	System.out.print("Ingresar otro?\n"
				+ "1 - Si\n"
        		+ "0 - No, volver atrás\n"
        		+ "Opcion + Enter: ");
        return scanner.nextInt();
    }
    
    private static Integer shouldSearchAgain() {
    	System.out.print("Buscar otro?\n"
				+ "1 - Si\n"
				+ "2 - No, actualizar datos\n"
        		+ "0 - No, volver atrás\n"
        		+ "Opcion + Enter: ");
        return scanner.nextInt();
    }
}
