package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Solucion1_FuerzaBruta {
//se definen los nombres de los archivos por defecto.
    private static final String ARCHIVO_ENTRADA = "campo.in";
    private static final String ARCHIVO_SALIDA = "campo.out";

    /** Representa un poste con coordenadas enteras. */
    static class Punto {
        final int x;
        final int y;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static long dobleAreaConSigno(Punto a, Punto b, Punto c) {
        return (long) (b.x - a.x) * (c.y - a.y)
                - (long) (b.y - a.y) * (c.x - a.x);
    }

    /** A qui lee los puntos de la entrada hasta encontrar el centinela que es  "-1 -1". */
    static List<Punto> leerPuntos(String ruta) throws IOException {
        List<Punto> puntos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                StringTokenizer st = new StringTokenizer(linea);
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (x == -1 && y == -1) break; // fin de la lista
                puntos.add(new Punto(x, y));
            }
        }
        return puntos;
    }

    /**
     * Prueba todas las combinaciones de tres puntos y devuelve el triángulo
     * de mayor área como arreglo {A, B, C}.
     */
    static Punto[] trianguloMaximo(List<Punto> p) {
        int n = p.size();
        long mejor = -1;
        Punto[] resultado = null;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long area2 = Math.abs(dobleAreaConSigno(p.get(i), p.get(j), p.get(k)));
                    if (area2 > mejor) {
                        mejor = area2;
                        resultado = new Punto[]{p.get(i), p.get(j), p.get(k)};
                    }
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        String entrada = args.length > 0 ? args[0] : ARCHIVO_ENTRADA;
        String salida = args.length > 1 ? args[1] : ARCHIVO_SALIDA;

        try {
            List<Punto> puntos = leerPuntos(entrada);
            if (puntos.size() < 3) {
                System.out.println("Se requieren al menos 3 postes.");
                return;
            }

            long inicio = System.nanoTime();
            Punto[] t = trianguloMaximo(puntos);
            long fin = System.nanoTime();

            try (PrintWriter pw = new PrintWriter(salida)) {
                for (Punto q : t) {
                    pw.println(q.x + " " + q.y);
                }
            }

            System.out.println("Postes leídos: " + puntos.size());
            System.out.println("Doble del área máxima: "
                    + Math.abs(dobleAreaConSigno(t[0], t[1], t[2])));
            System.out.println("Tiempo (ms): " + (fin - inicio) / 1_000_000.0);
            System.out.println("Resultado escrito en " + salida);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }
}
 