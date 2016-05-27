package ClassWork.utils;

import java.util.Arrays;

/**
 * Created by dfsdfsddfsdf on 25.05.16.
 */
public class MyArrayList<E>  {

    private E[] arr;
    private int counter = 0;
    private static final int DEFAULT_ARRAY_SIZE = 10;

    public MyArrayList() {
        this.arr = (E[])new Object[DEFAULT_ARRAY_SIZE];

    }

    public MyArrayList(int size) {
        this.arr = (E[])new Object[size];
    }

    public int size(){
        return counter;
    }

//    Fixed boolean
    public boolean add(E value){

        if(!checkValue(value)) return false;

        int newSize = arr.length;

        if(!checkSize(counter + 1)){
            newSize = moreSize(arr.length);
        }

        E[] mas = (E[]) new Object[newSize];

        System.arraycopy(arr, 0, mas, 0, counter);
        mas[counter] = value;

        counter++;

        this.arr = Arrays.copyOf(mas, newSize);

        return true;
    }
// Fixed boolean
    public boolean add(int index, E value){

        if(!checkIndex(index) || !checkValue(value)) return false;

        int newSize = arr.length;

        if(!checkSize(counter + 1)){
            newSize = moreSize(arr.length);
        }

        E[] mas = (E[]) new Object[newSize];

        System.arraycopy(arr, 0, mas, 0, index);
        mas[index] = value;
        System.arraycopy(arr, index, mas, index + 1, counter - index);

        counter++;

        this.arr = Arrays.copyOf(mas, newSize);

        return  true;
    }

    public E get(int index){

        if(!checkIndex(index)) return null;

        return arr[index];
    }

    public E set(int index, E value){

        if(!checkIndex(index) || !checkValue(value) ) return null;

        E origin = arr[index];
        arr[index] = value;

        return origin;
    }

    public void clear(){
        this.arr = (E[]) new Object[0];
        counter = 0;
    }
    //     Fixed KISS
    public E remove(int index){

        if(!checkIndex(index)) return null;

        E origin = arr[index];

        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);

        counter--;

        return origin;
    }
//   Fixed KISS
    public boolean remove(E value){

        if(!checkValue(value)) return false;

        for (int i = 0; i <arr.length ; i++) {

            if(value.equals(arr[i])){

                System.arraycopy(arr, i + 1, arr, i, arr.length - i - 1);

                counter--;

                return  true;
            }
        }
        System.err.println(value + " - not found, try again");

        return false;
    }

    public boolean contains(E value){

        if(!checkValue(value)) return false;

        for (int i = 0; i < arr.length ; i++) {

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