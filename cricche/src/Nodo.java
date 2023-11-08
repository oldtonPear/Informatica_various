public class Nodo <T>{
    T data;
    double peso;
    Nodo(T data, double peso){
        this.data = data;
        this.peso = peso;
    }
    Nodo(T data){
        this.data = data;
        peso = 1;
    }
    public T getData() {
        return data;
    }
    public double getPeso() {
        return peso;
    }
}
