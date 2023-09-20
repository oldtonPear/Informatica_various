public class ListElement <T>{
    ListElement <T> next;
    ListElement <T> prev;
    private T data;
    ListElement(T newData){
        data = newData;
    }
    public T getData() {
        return data;
    }
}
