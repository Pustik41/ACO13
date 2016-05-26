package ClassWork.utils;

import java.util.Arrays;

/**
 * Created by dfsdfsddfsdf on 25.05.16.
 */
public class MyArrayList<E>  {
// why static?
    private  E[] arr;

    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    public MyArrayList() {
        this.arr = (E[])DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }

    public int size(){
        return arr.length;
    }

    public void add(E value){

        if(!checkValue(value)) return;

        E[] mas = (E[]) new Object[arr.length + 1];

        System.arraycopy((E[]) arr, 0, mas, 0, arr.length);
        mas[arr.length] = value;

        this.arr = Arrays.copyOf(mas, mas.length);
    }

    public void add(int index, E value){

        if(!checkIndex(index)) return;
        if(!checkValue(value)) return;

        E[] mas = (E[]) new Object[arr.length + 1];

        System.arraycopy((E[]) arr, 0, mas, 0, index);
        mas[index] = value;
        System.arraycopy((E[]) arr, index, mas, index + 1, arr.length - index);

        this.arr = Arrays.copyOf(mas, mas.length);
    }

    public E get(int index){

        if(!checkIndex(index)) return null;

        return arr[index];
    }

    public void set(int index, E value){

        if(!checkIndex(index)) return;
        if(!checkValue(value)) return;

        arr[index] = value;
    }

    public void clear(){
        this.arr = (E[]) new Object[0];
    }

    public void remove(int index){

        if(!checkIndex(index)) return;

        E[] tmp = (E[]) new Object[arr.length - 1];

        System.arraycopy((E[]) arr, 0, tmp, 0, index);
        System.arraycopy((E[]) arr, index + 1, tmp, index, arr.length - index - 1);

        this.arr = Arrays.copyOf(tmp, tmp.length);
    }

    public void remove(E value){

        if(!checkValue(value)) return;

        E[] tmp = (E[]) new Object[arr.length - 1];

        for (int i = 0; i <arr.length ; i++) {

            if(value.equals(arr[i])){
                System.arraycopy(arr, 0, tmp, 0, i);
                System.arraycopy(arr, i + 1, tmp, i, arr.length - i - 1);
                arr = Arrays.copyOf(tmp, tmp.length);
                break;
            }
        }

    }

    public boolean contains(E value){

        if(!checkValue(value)) return false;

        for (int i = 0; i <arr.length ; i++) {

            if(value.equals(arr[i])){
                return true;
            }

        }

        return false;
    }

    private boolean checkIndex(int index){

        if(index < 0 || index >= arr.length){
            System.out.println("Index not valid");
            return false;
        }

        return true;
    }

    private static boolean checkValue(Object value){

        if(value == null){
            System.out.println("Value not valid");
            return false;
        }

        return true;
    }

}
