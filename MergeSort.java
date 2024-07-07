/**
 * This class implements the Merge Sort algorithm,
 * which can sort an array of numbers efficiently with a time complexity of O(n log n).
 * Merge Sort follows the divide-and-conquer principle.
 * It works by recursively dividing the input array into two halves until
 * each half contains only one element.
 * Then, it merges the sorted sub-arrays back together to create the final sorted array.
 */
public class MergeSort implements Sortable{
    /**
     * Sorts an array of integers in descending order using the Merge Sort algorithm.
     * Merge Sort is a divide-and-conquer sorting algorithm with a time complexity of
     *
     * @param array the array to be sorted
     */
    public void sort(int[] array , int low , int high){
        if (array.length < 2) return;  // Base case: Array with less than 2 elements is already single element

        int middle = array.length/2 ;  // Divide the array into two halves


        int [] left = new int[middle] ;
        for (int i = 0 ; i < middle ; i++){
            left[i] = array[i] ;    // Copy elements to left sub-arrays
        }

        int[] right = new int[array.length - middle] ;
        for (int i = middle ; i < array.length ; i++){
            right[i-middle] = array[i] ;   // Copy elements to right sub-arrays
        }
        // Sort the left and right sub-arrays recursively
        sort(left , 0 , left.length-1);
        sort(right , 0 , right.length-1);
        // Merge the sorted sub-arrays back into the original array
        merge(left,right,array);

    }
    /**
     * Merges two sorted arrays `left` and `right` into a single sorted array `result`.
     * This function assumes that both `left` and `right` are already sorted in descending order.
     *
     * @param left the first sorted array
     * @param right the second sorted array
     * @param result the target array to store the merged elements
     */
    private void merge (int[] left , int[] right , int[] result){

        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        // Merge elements while there are elements remaining in both left and right arrays
        while (i < left.length && j < right.length ){
            if (left[i] > right[j])
                result[k++] = left[i++] ; // Add the bigger element from left to result and increment both indexes
                else
                    result[k++] = right[j++] ; // Add the bigger element from right to result and increment both indexes
            }
        // Copy remaining elements from left array (if any)
        while (i < left.length){
            result[k++] = left[i++] ;
        }
        // Copy remaining elements from right array (if any)
        while (j < right.length){
            result[k++] = right[j++] ;
        }
    }

}
