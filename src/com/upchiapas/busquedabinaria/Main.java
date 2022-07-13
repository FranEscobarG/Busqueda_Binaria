package com.upchiapas.busquedabinaria;

import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }
    public static void mostrarMenu(){
        int[] datos = new int[11];
        byte opcion;
        do {
            System.out.println("\n***  BUSQUEDA BINARIA   ***");
            System.out.println(" * [1]- Ingresar Datos    *");
            System.out.println(" * [2]- Ordenar Datos     *");
            System.out.println(" * [3]- Buscar Valor      *");
            System.out.println(" **      [3]- SALIR      **");
            System.out.println("Ingrese una opcion: ");
            opcion = entrada.nextByte();

            switch (opcion) {
                case 1:
                    ingresarDatos(datos);
                    break;
                case 2:
                    ordenarDatos(datos);
                    break;
                case 3:
                    mostrarDatoBuscado(datos);
                    break;
                case 4:
                    System.out.println("** Ah salido con exito **");
                    break;
                default:
                    System.out.println("Opcion invalida. Intentalo de nuevo");
            }
        }while (opcion!=3);
    }
    public static void ingresarDatos(int[] datos){
        entrada.nextLine();
        for (int i=0; i<datos.length; i++){
            System.out.print("Ingrese un numero: ");
            datos[i]=entrada.nextInt();
        }
    }

    public static void ordenarDatos(int[] datos){
        int aux;
        for (int i=0 ; i<datos.length ; i++ ){
            for (int j=0 ; j<datos.length-1 ; j++ ){
                if ( datos[j] > datos[j+1] ){
                    aux = datos[j];
                    datos[j] = datos[j+1];
                    datos[j+1] = aux;
                }
            }
        }
        mostrarDatos(datos);
    }

    public static void mostrarDatos(int[] datos){
        System.out.println("Edades ordenadas Ascendentemente: ");
        for (int i=0 ; i<datos.length ; i++){
            System.out.print("Edad " + i +": " + datos[i] + ",\t");
        }
    }

    public static int buscarValor(int[] datos,int valorBuscado){
        int indiceCentral, valorCentral;
        int inicioA=0, finA=datos.length-1; //(datos.length / datos[0]);


        while (inicioA <= finA){
            indiceCentral=(inicioA + finA)/2;
            valorCentral=datos[indiceCentral];

            if (valorBuscado == valorCentral)
                return indiceCentral;
            else if (valorBuscado < valorCentral)
                finA = indiceCentral-1;
            else
                inicioA = indiceCentral+1;
        }
        return -1; //Elemento no encontrado
    }
    public static void mostrarDatoBuscado(int[] datos){
        int valorBuscado;
        System.out.print("Valor a buscar: ");
        valorBuscado=entrada.nextInt();

        if (buscarValor(datos,valorBuscado)==-1)
            System.out.println("Valor no encontrado");
        else
            System.out.println("Dato encontrado en la posicion: "+buscarValor(datos,valorBuscado));
    }
}
