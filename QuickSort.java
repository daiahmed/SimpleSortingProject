/**
 * Quicksort is a highly efficient sorting algorithm that employs a divide-and-conquer strategy.
 * It involves selecting a 'pivot' element,
 * partitioning the array around the pivot,
 * and recursively sorting the resulting subarrays
 */

public class QuickSort implements Sortable{
    /**
     * 
     * @param arr
     * @param low
     * @param high
     */

    @Override
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            // Choose the rightmost element as pivot
            int pivotIndex = partitionDescending(arr, low, high);

            // Sort elements before partition (greater than pivot)
            sort(arr, low, pivotIndex - 1);

            // Sort elements after partition (less than pivot)
            sort(arr, pivotIndex + 1, high);
        }
    }

    /**
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partitionDescending(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (arr[j] >= pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }

            swap(arr, i + 1, high);
            return i + 1;
        }

    /**
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        }


