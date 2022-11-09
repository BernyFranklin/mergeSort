package com.mergesort;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * Give a linked list, sort in O(n log n) time and constant space
 * 
 * For example, the linked list 4 -> 1 -> -3 -> 99
 * Should become               -3 -> 1 ->  4 -> 99
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int userInput = 0;
        boolean isValid;
        Scanner scan = new Scanner(System.in);
        do{
            try{
                isValid = true;
                System.out.printf("\nEnter size of list: ");
                userInput = scan.nextInt();
                System.out.println();
            }
            catch(InputMismatchException e) {
                System.out.printf("Numeric input only, please try again");
                isValid = false;
                scan.nextLine();
            }
        }
        while(!isValid);

        LinkedList<Integer> list = new LinkedList<Integer>();
        Random rand = new Random();

        for (int i = 0; i < userInput; i++) {
            list.add(rand.nextInt(100000));
        }
    
        System.out.printf("\nList Size: %d", list.size());
        System.out.printf("\nOriginal List: ");

        for(Integer item: list) {
            System.out.printf("\n%d", item);
        }

        mergeSort(list);

        System.out.printf("\nSorted list: ");
        for (Integer item: list) {
            System.out.printf("\n%d", item);
        }
        System.out.println();
        scan.close();
    }

    private static void mergeSort(LinkedList<Integer> inputList) {
        // Get size of list
        int inputLength = inputList.size();
        // If size only has 1 element, return
        if (inputLength < 2) {
            return;
        }
        // Establish middle index
        int middleIndex = inputLength / 2;

        // Split array into two arrays
        LinkedList<Integer> leftList = new LinkedList<Integer>();
        LinkedList<Integer> rightList = new LinkedList<Integer>();

        // Populate left
        for (int i = 0; i < middleIndex; i++) {
            leftList.add(inputList.get(i));
        }
        // Populate right
        for (int j = middleIndex; j < inputLength; j++) {
            rightList.add(inputList.get(j));
        }
        // Use recursion to keep splitting
        mergeSort(leftList);
        mergeSort(rightList);

        // Merge
        merge(inputList, leftList, rightList);
    }

    private static void merge(LinkedList<Integer> inputList, LinkedList<Integer> leftHalf, LinkedList<Integer> rightHalf) {
        // Get size of left and right
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();
        // Set up counters
        int listIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        // Start comparing values
        while ((leftIndex < leftSize) && (rightIndex < rightSize)) {
            // Left < Right
            if (leftHalf.get(leftIndex) <= (rightHalf.get(rightIndex))) {
                // Add element to list
                inputList.set(listIndex, leftHalf.get(leftIndex));
                // Move to next index in left
                leftIndex++;
            }
            // Right < Left
            else {
                // Add element to list
                inputList.set(listIndex, rightHalf.get(rightIndex));
                // Move to next element in right
                rightIndex++;
            }
            // Move to next element in list
            listIndex++;
        }
        // Clean up left if elements remain
        while (leftIndex < leftSize) {
            inputList.set(listIndex, leftHalf.get(leftIndex));
            leftIndex++;
            listIndex++;
        }
        // Clean up right if elements remain
        while (rightIndex < rightSize) {
            inputList.set(listIndex, rightHalf.get(rightIndex));
            rightIndex++;
            listIndex++;
        }

    }
}
