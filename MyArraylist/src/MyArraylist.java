import java.lang.reflect.*;;
public class MyArraylist <T>{
    private T[] arr;
    Class<T> classe;
    MyArraylist(Class<T> classe){
        this.classe = classe;
        arr = (T[]) Array.newInstance(this.classe, 0);
    }
    public void add(T n){
        arr = allunga1(arr);
        arr[arr.length-1] = n;
    }
    public void set(int pos, T valore){
        arr[pos] = valore;
    }
    public T get(int n){
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
        arr = (T[]) Array.newInstance(this.classe, 0);
    }
    public int size(){
        return arr.length;
    }
    public void printa(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    private T[] allunga1(T[] arr){
        T[] arr2 = (T[]) Array.newInstance(classe, arr.length+1);
        for (int i = 0; i < arr2.length-1; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }
    private T[] accorcia1(T[] arr){
        T[] arr2 = (T[]) Array.newInstance(classe, arr.length-1);
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
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
    public int get(int n){
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
    }
    */
}
