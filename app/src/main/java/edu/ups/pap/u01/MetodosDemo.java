package edu.ups.pap.u01;

import java.util.function.Function;

public class MetodosDemo {
    public static void main(String[] args) {
        Caja<String> original = new Caja<>("Algoritmo");
        // Mapear el valor String de la Caja a un integer

        Integer longitud = original.mapear(texto -> texto.length());
        String etiqueta = original.mapear(texto -> "Materia: " + texto);

        //Otra forma ded hacerlo ->
        //Function<String, Integer> fun = texto -> texto.length();
        // Integer longitud = original.mapear(fun);
       
        System.out.println("Original: " + original.obtener());
        System.out.println("Longitud: " + longitud);
        System.out.println(etiqueta);
    }

}
