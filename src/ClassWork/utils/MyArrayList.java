package ClassWork.utils;

import java.util.Arrays;

/**
 * Created by dfsdfsddfsdf on 25.05.16.
 */
public class MyArrayList<E>  {

    Object[] arr;

    private int counter = 0;

    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    public MyArrayList() {
        this.arr = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;

    }

    public MyArrayList(int size) {
        this.arr = new Object[size];
    }

    public int size(){
        return counter;
    }

    public void add(E value){

        if(!checkValue(value)) return;

        int newSize = arr.length;

        if(!checkSize(counter + 1)){
            newSize = moreSize(arr.length);
        }

        E[] mas = (E[]) new Object[newSize];

        System.arraycopy((E[]) arr, 0, mas, 0, counter);
        mas[counter] = value;

        counter++;

        this.arr = Arrays.copyOf(mas, newSize);

    }

    public void add(int index, E value){

        if(!checkIndex(index)) return;
        if(!checkValue(value)) return;

        int newSize = arr.length;

        if(!checkSize(counter + 1)){
            newSize = moreSize(arr.length);
        }

        E[] mas = (E[]) new Object[newSize];

        System.arraycopy((E[]) arr, 0, mas, 0, index);
        mas[index] = value;
        System.arraycopy((E[]) arr, index, mas, index + 1, counter - index);

        counter++;

        this.arr = Arrays.copyOf(mas, newSize);
    }

    public E get(int index){

        if(!checkIndex(index)) return null;

        return (E) arr[index];
    }

    public void set(int index, E value){

        if(!checkIndex(index)) return;
        if(!checkValue(value)) return;

        arr[index] = (E) value;
    }

    public void clear(){
        this.arr = (E[]) new Object[0];
    }

    public void remove(int index){

        if(!checkIndex(index)) return;

        E[] tmp = (E[]) new Object[arr.length - 1];

        System.arraycopy((E[]) arr, 0, tmp, 0, index);
        System.arraycopy((E[]) arr, index + 1, tmp, index, arr.length - index - 1);

        counter--;

        this.arr = Arrays.copyOf(tmp, tmp.length);
    }

    public void remove(E value){

        if(!checkValue(value)) return;

        E[] tmp = (E[]) new Object[arr.length - 1];

        for (int i = 0; i <arr.length ; i++) {

            if(value.equals(arr[i])){

                System.arraycopy(arr, 0, tmp, 0, i);
                System.arraycopy(arr, i + 1, tmp, i, arr.length - i - 1);

                counter--;

                arr = Arrays.copyOf(tmp, tmp.length);
                break;
            }
        }

        System.out.println(value + " - not found, try again");

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

        if(index < 0 || index >= counter){
            System.out.println("Index not valid");
            return false;
        }

        return true;
    }

    private boolean checkValue(Object value){

        if(value == null){
            System.out.println("Value not valid");
            return false;
        }

        return true;
    }

    private boolean checkSize(int count){

        if(count > arr.length) {return false;}

        return true;
    }

    private int moreSize(int size){

        return (size * 3) / 2 + 1;
    }

}