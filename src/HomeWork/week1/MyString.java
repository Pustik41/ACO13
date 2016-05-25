package HomeWork.week1;

import java.util.Arrays;

/**
 * Created by dfsdfsddfsdf on 23.05.16.
 */
public class MyString {
//    todo if your methods receive reference type - make checks on NullPointerException

    private  char[] str;

    public MyString( String original){
        this.str = original.toCharArray();
    }

    public MyString(char[] str) {
        this.str = Arrays.copyOf(str, str.length);
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

    public MyString concat (MyString value2){

        char[] concatenation = new char[str.length + value2.length()];

        System.arraycopy(str, 0, concatenation, 0, str.length);
        System.arraycopy(value2.str, 0, concatenation, str.length, value2.length());

       return new MyString(concatenation);
    }

    public  MyString subMyString(int start, int end){
//      refactored
        char[] sub = new char[end - start];
        for (int id = 0; start < end; start++) {
            sub[id++] = str[start];
        }

        return new MyString(sub);
    }

    public  MyString subMyString(int start){
//      refactored

        char[] sub = new char[str.length - start];
        for (int id = 0; start <str.length; start++) {
            sub[id++] = str[start];
        }

        return new MyString(sub);
    }
//todo you can have ArrayOutOfBoundException
    public char charAt(int index){
        return str[index];
    }

    public boolean equals(Object value){
//        todo refactoring

        char[] same = new char[0];

        if(value instanceof String){
            same = ((String) value).toCharArray();
        }

        if(value instanceof char[]){
            same = Arrays.copyOf((char[])value, ((char[]) value).length);
        }

        if(value instanceof MyString){
            same = Arrays.copyOf(((MyString) value).str, ((MyString) value).str.length);
        }

        if(str.length == same.length){

            for (int i = 0; i <str.length; i++) {

                if(str[i] != same[i]){
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public MyString toLowerCase(){

        char[] lower = new char[str.length];

        for (int i = 0; i < str.length ; i++) {
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

    public boolean contains(String value){
// at first check on null!!!
        if(value.equals("") || value == null) {return false;}

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

}
