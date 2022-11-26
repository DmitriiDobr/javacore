import java.util.Arrays;

public class AlgosCheck {

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++) {
                System.out.println(Arrays.toString(array));
                System.out.println(i);
                System.out.println(j);

                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }
        return array;

    }

    public static int[] vstavkaSort(int[] arraySort) {

        for (int i = 0; i < arraySort.length - 1; i++) {
            int j = i + 1;
            int cnt = i;
            while (j != 0) {
                if (arraySort[cnt] > arraySort[j]) {
                    int cache = arraySort[j];
                    arraySort[j] = arraySort[cnt];
                    arraySort[cnt] = cache;
                } else {
                    break;
                }

                cnt--;
                j--;

            }

        }
        return arraySort;


    }

    public static int linearSearch(int[] array, int searchNumber) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchNumber) {
                return i;
            }

        }
        return -1;
    }

}




