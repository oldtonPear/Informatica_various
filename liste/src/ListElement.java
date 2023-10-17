public class ListElement <T>{
    private ListElement <T> next;
    private T data;
    ListElement(T newData){
        data = newData;
    }
    public T getData() {
        return data;
    }
    public ListElement<T> getNext() {
        return next;
    }
    public void setNext(ListElement<T> next) {
        this.next = next;
    }
}
