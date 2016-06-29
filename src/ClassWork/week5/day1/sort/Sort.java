package ClassWork.week5.day1.sort;

/**
 * Created by zhabenya on 25.06.16.
 */
public class Sort {

    public static void selectionSort(int[] array){

        if(array == null || array.length <= 1) return;

        for (int i = 0; i < array.length; i++) {
            int minId = i;

            for (int j = i+1; j < array.length; j++) {

                if (array[j] < array[minId]) {
                    minId = j;
                }
            }

            swap(array, i, minId);
        }

    }

    private static void swap(int[] array, int i, int minId) {
        int tmp = array[i];
        array[i] = array[minId];
        array[minId] = tmp;
    }
}
