import java.util.*;
public class sortingAlgos {
    static int times = 0;
    public static void main (String[] args) {
        int[] main = {9, 5, 4, 8, 2, 0, 7, 6};

        sortingAlgos.quicksort(main, 0, main.length - 1);
        //System.out.println(Arrays.toString(main));


        //System.out.println(Sorting.bubblesort(main), 0, main.length - 1);
        //System.out.println(Sorting.quicksort(main), 0, main.length -1);
    }

    // easy
    public static void bubblesort (int[] list) {
        int n = list.length;
        boolean swapped;

        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = i + 1; j < n; j++) {
                if (list[i] > list[j]) {
                    swapped = true;
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                    /*
                    list[i] = list[i] ^ list[j];
                    list[j] = list[i] ^ list[j];
                    list[i] = list[i] ^ list[j];
                    */
                }

                if (!swapped) {
                    break;
                }
            }
        }
    }


    public static void insertionsort (int[] list) {
        int n = list.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && list[j-1] > list[j]) {
                list[j-1] = list[j-1] ^ list[j];
                list[j] = list[j-1] ^ list[j];
                list[j-1] = list[j-1] ^ list[j];
                j--;
            }
        }
    }

    public static void selectionsort (int[] list) {
        int n = list.length;
        int minIndex;

        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }

    // medium
    public static void mergesort (int[] list) {
        if (list.length <= 1) {
            return;
        }

        int mid = list.length / 2;
        int[] left = new int[mid];
        int[] right = new int[list.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = list[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = list[mid + i];
        }

        mergesort (left);
        mergesort (right);

        int[] res = sortingAlgos.merge (left, right);
        System.arraycopy(res, 0, list, 0, res.length);
    }

    private static int[] merge (int[] a, int[] b) {
        int[] result = new int [a.length + b.length];

        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length){
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
           result[k] = a[i];
           i++;
           k++;
        }

        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }
        return result;
    }
    // o(nlogn)
    // why? looping array through once times the height of the tree made during mergesort
    public static void quicksort (int[] list, int l, int h) {
        System.out.println (times + " recursive calls have been... called");
        System.out.println(Arrays.toString(list));
        times++;
        if (l < h) {
            int pivot = sortingAlgos.partition (list, l, h);
            if (times < 3) {
                //step through
                int piv = pivot - 1;

                System.out.println("Left Function call: ");
                System.out.println("quicksort (list, " + l + ", " + piv + " )");
                quicksort (list, l, pivot-1);

                System.out.println("");

                piv += 2;
                System.out.println("Right Function call: ");
                System.out.println("quicksort (list, " + piv + ", " + h + " )");
                System.out.println("");
                quicksort (list, pivot+1, h);

            }
        }
    }

    public static int partition (int[] list, int l, int h) {
        int pivot = list[h];
        int leftwall = l;

        for (int i = l; i < h; i++) {
            if (list[i] < pivot) {
                int temp = list[i];
                list[i] = list[leftwall];
                list[leftwall] = temp;
                leftwall++;
            }
        }
        int temp = list[h];
        list[h] = list[leftwall];
        list[leftwall] = temp;
        return leftwall;
    }
    // o(nlogn) : average case
    // o(n^2) : worst case
    // difference? change the pivot location
}
