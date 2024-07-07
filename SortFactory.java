/**
 * this factory class represents encapsulation for main functionality
 * This class provides a user interface for choosing and performing sorting algorithms.
 *
 * It utilizes JOptionPane for user interaction and sorting algorithms implemented in separate classes (like MergeSort and QuickSort).
 **/

import javax.swing.*;
import java.util.Arrays;
public class SortFactory {
    /**
     * This function presents the user interface for choosing and performing a sorting operation.
     * It allows the user to select a sorting algorithm (Merge Sort or Quick Sort), enter numbers to be sorted,
     * displays the sorted results, and prompts the user for the next action (cancel or perform another sort).
     */
    public void run(){
        String[] choices = { "Merge Sort" , "Quick Sort" };
        String input = (String) JOptionPane.showInputDialog(null, "Choose algorithms...",
                " ", JOptionPane.CLOSED_OPTION, null,

                choices, // Array of choices
                choices[0]); // Initial choice
        switch (input){
            case "Merge Sort":{
                MergeSort merge = new MergeSort();
                String in = JOptionPane.showInputDialog("Enter numbers separated by commas (e.g., 1,2,3):");
                String[] numbersAsString = in.split(",");
                int[] numbers = new int[numbersAsString.length];
                for (int i = 0; i < numbersAsString.length; i++) {
                    numbers[i] = Integer.parseInt(numbersAsString[i].trim());
                    merge.sort(numbers,0,numbers.length-1);
                }

                String[] options = { "Cancel", "New Operation" };
                var selection = JOptionPane.showOptionDialog(null, "The sorted numbers are : \n" + (Arrays.toString(numbers)), "Sort algorithms",
                        0, 3, null , options , options[0]);


                if (selection == 0) {
                    System.exit(0);
                } else if (selection== 1) {
                    run();
                }
            }
            case "Quick Sort":{

                QuickSort quick = new QuickSort();
                String in = JOptionPane.showInputDialog("Enter numbers separated by commas (e.g., 1,2,3):");
                String[] numbersAsString = in.split(",");
                int[] numbers = new int[numbersAsString.length];
                for (int i = 0; i < numbersAsString.length; i++) {
                    numbers[i] = Integer.parseInt(numbersAsString[i].trim());
                    quick.sort(numbers,0,numbers.length-1);
                }

                String[] options = { "Cancel", "New Operation" };
                var selection = JOptionPane.showOptionDialog(null, "The sorted numbers are : \n" + (Arrays.toString(numbers)), "Sort algorithms",
                        0, 3, null , options , options[0]);

                if (selection == 0) {
                    System.exit(0);
                } else if (selection== 1) {
                    run();
                }

            }
        }
    }

}
