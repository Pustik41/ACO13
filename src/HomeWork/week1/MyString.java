package HomeWork.week1;

import java.util.Arrays;

/**
 * Created by dfsdfsddfsdf on 23.05.16.
 */
public class MyString {

//    it can't be static

    private char[] str;

    public MyString(String original){

        str = original != null ? original.toCharArray() : new char[0];
    }

    public MyString(char[] array) {


        str = array != null ? Arrays.copyOf(array, array.length) : new char[0];
    }

    public int length(){
        return str.length;
    }

    public void showMyString() {
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.println();
    }

    public MyString concat(MyString value2){

        char[] concatenation = new char[str.length + value2.length()];

        System.arraycopy(str, 0, concatenation, 0, str.length);
        System.arraycopy(str, 0, concatenation, str.length, value2.length());

       return new MyString(concatenation);
    }

    public  MyString subMyString(int start, int end){

        if(!checkIndex(start) || !checkIndex(end)) return null;

        char[] sub = new char[end - start];

        for (int id = 0; start < end; start++) {
            sub[id++] = str[start];
        }

        return new MyString(sub);
    }

    public  MyString subMyString(int start){

        if(!checkIndex(start)) return null;

        char[] sub = new char[str.length - start];

        for (int id = 0; start <str.length; start++) {
            sub[id++] = str[start];
        }

        return new MyString(sub);
    }

    public char charAt(int index){

        return checkIndex(index) ? str[index] : '\u0000';

    }

    public boolean equals(Object value){

        if(this == value) return true;

        if(value == null) return false;


        if(value.getClass() != MyString.class) return false;
        MyString tmp = (MyString) value;
        if(this.str.length != tmp.str.length) return false;

        for (int i = 0; i < str.length; i++) {

            if(this.str[i] != tmp.str[i]){
                return false;
            }
        }

        return true;

    }

    public MyString toLowerCase(){

        char[] lower = new char[str.length];

        for (int i = 0; i < str.length; i++) {
            lower[i] = Character.toLowerCase(str[i]);
        }

        return new MyString(lower);
    }

    public MyString toUpperCase(){

        char[] upper = new char[str.length];

        for (int i = 0; i < str.length ; i++) {
            upper[i] = Character.toUpperCase(str[i]);
        }

        return new MyString(upper);
    }

//    must receive MyString, not String
    public boolean contains(String value){

        if(value == null || value.equals("")) return false;

        MyString original = new MyString(str);
        MyString contain = new MyString(value);

        if(contain.length() <= original.length()){

            for (int i = 0; i < original.length() - contain.length() + 1 ; i++) {

                if(original.subMyString(i, i + contain.length()).equals(contain)){
                    return true;
                }
            }
        }

        return false;
    }

    public MyString trim(){

        int start = 0;
        int end = str.length - 1;

        while (str[start] == ' '){
            start++;
            if(start == end) return new MyString(new char[0]);
        }

        while (str[end] == ' '){
            end--;
        }

        return new MyString(str).subMyString(start, end + 1);
    }

    private boolean checkIndex(int index){

        if(index < 0 || index >= str.length){
            System.err.println("Index not valid");
            return false;
        }

        return true;
    }

}
