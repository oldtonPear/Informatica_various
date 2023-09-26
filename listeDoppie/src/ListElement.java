public class ListElement <T>{
    protected ListElement <T> next;
    protected ListElement <T> prev;
    private T data;
    ListElement(T newData){
        data = newData;
    }
    public T getData() {
        return data;
    }
}
