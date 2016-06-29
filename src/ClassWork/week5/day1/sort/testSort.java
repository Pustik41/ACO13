package ClassWork.week5.day1.sort;

/**
 * Created by zhabenya on 25.06.16.
 */
public class testSort {

    public static void main(String[] args) {

        int[] array = new int[10];

        for (int i = 0; i < 10 ; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + " ");
        }

        new Sort().selectionSort(array);
        System.out.println();

        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
