import java.util.*;
public class MyArraylist <E>{
    private final Object[] arr;
    public final int length;
 
    // constructor
    public MyArraylist(int length)
    {
        // Creates a new object array of the specified length
        arr = new Object[length];
        this.length = length;
    }
 
    // Method to get object present at index `i` in the array
    E get(int i) {
        @SuppressWarnings("unchecked")
        final E e = (E)arr[i];
        return e;
    }
 
    // Method to set a value `e` at index `i` in the array
    void set(int i, E e) {
        arr[i] = e;
    }
 
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
/* 
    int[] arr = new int[0];
    
    public void add(int n){
        arr = allunga1(arr);
        arr[arr.length-1] = n;
    }
    public void set(int pos, int valore){
        arr[pos] = valore;
    }
    /*public int get(int n){
        return arr[n];
    }
    public void remove(int n){
        boolean trovato = false;
        for (int i = 0; i < arr.length-1; i++) {
            if(i == n) trovato = true;
            if(trovato) arr[i] = arr[i+1];
        }
        if(!trovato && n == arr.length) trovato = true;
        if(trovato) arr = accorcia1(arr);
    }
    public void clear(){
        arr = new int[0];
    }
    public int size(){
        return arr.length;
    }
    public void printa(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    private int[] allunga1(int[] arr){
        int[] arr2 = new int[arr.length+1];
        for (int i = 0; i < arr2.length-1; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }
    private int[] accorcia1(int[] arr){
        int[] arr2 = new int[arr.length-1];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }*/
}
