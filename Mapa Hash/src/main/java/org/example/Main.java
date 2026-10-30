package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        int[] numeros = {2, 14, 6, 11, 8, 15, 7};
        int objetivo = 9;

        HashMap<Integer, Integer> tabla = new HashMap<>();
        //Creamos la tabla La clave es el número y el valor es el índice
        //  Guardamos el índice  ya que el problema nos pide índices,

        for (int i = 0; i < numeros.length; i++) {
         // hacemos el recorrido una  sola vez , donde i es la posicion actual

            int faltante = objetivo - numeros[i];


            if (tabla.containsKey(faltante)) {
                int indiceAnterior = tabla.get(faltante);
                System.out.println("Indices: " + indiceAnterior + " y " + i);
                System.out.println(numeros[indiceAnterior] + " + " + numeros[i] + " = " + objetivo);
                return;
             // aqui lo que indica   es que si encontro el par nos da el índice donde
                // lo vimos antes, e i es el índice actual. Imprimimos y terminamos con return
            }

           // Si no estaba, guardamos el número actual con su índice para que
            // el siguiente puedan encontrarlo.
            tabla.put(numeros[i], i);
        }
         // si no encontramos pareja esto se imprime
        System.out.println("No hay dos numeros que sumen " + objetivo);
    }
}