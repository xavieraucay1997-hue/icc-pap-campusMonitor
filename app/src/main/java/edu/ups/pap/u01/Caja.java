package edu.ups.pap.u01;
// CLASES GENERICAS
public class Caja<T> {
    //DATO GENERICO
    private final T valor;

    public Caja(T valor) {
        this.valor = valor;
    }
    //METODO GENRICO 
    //GETTER
    public T obtener(){
        return valor;
    }
    


    
}