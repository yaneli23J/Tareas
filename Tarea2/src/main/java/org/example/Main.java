package org.example;

class Nodo {
    int valor;
    Nodo superior;
    Nodo medio;
    Nodo inferior;

    public Nodo(int valor) {
    this.valor = valor;
    this.superior = null;
    this.medio = null;
    this.inferior = null;
    }


}
    //se instancia los nodos con sus valores
public class Main {
        public static void main(String[] args) {
            Nodo n20 = new Nodo(20);
            Nodo n23 = new Nodo(23);
            Nodo n19 = new Nodo(19);
            Nodo n57 = new Nodo(57);
            Nodo n67 = new Nodo(67);
            Nodo n99 = new Nodo(99);

            // se define el punto de inicio
            Nodo head = n20;
            // se hace las conexciones
            head.superior = n23;
            head.medio = n19;
            head.inferior = null;

            // conexion del 23
            n23.medio = n57;

            //conexion 19
            n23.superior = null;
            n19.inferior = n67;

            //conexion del valor 67
            n67.medio = n99;


            // se imprime el nodo 99 usando la variable head
            //como indica  la imagen el camina hacia el 99 seria asi
            System.out.println("nodo 99: " + head.medio.inferior.medio.valor);

            //se imprime el nodo  57
            System.out.println("nodo 57: " + head.superior.medio.valor);


        }

}



