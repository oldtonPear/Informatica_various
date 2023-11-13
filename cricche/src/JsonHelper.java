public class JsonHelper <T> {
    Nodo[] nodi;
    Arco[] archi;
    class Nodo{
        T data;
    }
    class Arco{
        Nodo nodo1;
        Nodo nodo2;
        double value;
    }
}
