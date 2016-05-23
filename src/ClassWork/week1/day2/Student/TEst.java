package ClassWork.week1.day2.Student;

/**
 * Created by dfsdfsddfsdf on 23.05.16.
 */
public class TEst {

    public static void main(String[] args) {
        int arr1[] = { 0, 1, 6, 3, 4, 5 };
        int arr2[] = new int[7];
        int pos = 0;

        // copies an array from the specified source array
        System.arraycopy(arr1, 0, arr2, 0, pos);
        System.arraycopy(arr1, pos + 1, arr2, pos, arr1.length - pos -1);
        arr2[arr1.length -1 ] = arr1[pos];
        for(int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }
    }
}
