
package edu.ups.pap;

import edu.ups.pap.models.Lectura;
import edu.ups.pap.models.Reporte;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        runLectura();
        runTransformaciones();
        
    }

    private static void runLectura() {
        Lectura<Double> temperatura = new Lectura<>(
                "S01", 22.5, "°C");
        Lectura<Integer> lectura1 = new Lectura<>("S02", 18, "Personas");

        System.out.println("Lecturas de CampusMonitor");
        System.out.println(temperatura.getIdSensor() + " | " + temperatura.getValor() + " " + temperatura.getUnidad());
        System.out.println(lectura1.getIdSensor() + " | " + lectura1.getValor() + " " + lectura1.getUnidad());

        System.out.println("Valores recuperados sin casting:");
        System.out.println("Temperatura: " + temperatura.getValor());
        System.out.println("Ocupación: " + lectura1.getValor());


    }
    private static void runTransformaciones() {
        Lectura<Double> temperatura = new Lectura<>("S01", 22.5, "°C");
        Lectura<Integer> lectura1 = new Lectura<>("S02", 18, "Personas");

        Lectura<Double> fahrenheit = temperatura.transformar( c -> c * 9.0 / 5.0 + 32, "°F");

        Lectura<String> ocupacionTexto = lectura1.transformar(o -> o + " personas", "texto");
        String resultado = ocupacionTexto.getValor();


        System.out.println();
        System.out.println("Original: " + temperatura.getIdSensor() + "|" + temperatura.getValor() 
        + "|" + temperatura.getUnidad() );
        System.out.println("Transformada: " + fahrenheit.getIdSensor() 
        + " | " + fahrenheit.getValor() + " " + fahrenheit.getUnidad());
        System.out.println("Original: " + lectura1.getIdSensor()
        + " | " + lectura1.getValor() + " " + lectura1.getUnidad());
        System.out.println("Transformada: " + ocupacionTexto.getIdSensor()
        + " | " + resultado + " | unidad: " + ocupacionTexto.getUnidad());
        
        System.out.println();

        System.out.println("Temperatura original "  + temperatura.getValor());
        System.out.println("ocupacion original " + lectura1.getValor() );

        try {
            temperatura.transformar(null, "°F");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            temperatura.transformar(c -> null, "°F");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
        try {
            temperatura.transformar(c -> c, "");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        System.out.println();
        
        Lectura<Double> temperatura2 = new Lectura<>("S01", 22.5, "°C");
        Lectura<Reporte> reporte = temperatura2.transformar(datos -> new Reporte(temperatura2.getIdSensor(), datos, temperatura2.getUnidad()), "Reporte");

        System.out.println( reporte.getIdSensor() + "|" + reporte.getValor() + reporte.getUnidad());
    }
}
        

