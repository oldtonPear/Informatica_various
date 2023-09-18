public class ListElement <T>{
    ListElement <T> next;
    private T data;
    ListElement(T newData){
        data = newData;
    }
    public T getData() {
        return data;
    }
}
