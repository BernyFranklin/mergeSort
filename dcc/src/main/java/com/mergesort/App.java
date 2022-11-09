package com.mergesort;

import java.util.LinkedList;

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
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(4);
        list.add(1);
        list.add(-3);
        list.add(99);
        System.out.printf("\nList Size: %d", list.size());
        System.out.printf("\nOriginal List: ");

        for(Integer item: list) {
            System.out.printf("%d\t", item);
        }

        mergeSort(list);
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
        // Test Print
        System.out.printf("\nLeft list: ");
        for (int item: leftList) {
            System.out.printf("%d\t", item);
        }
        // Populate right
        for (int j = middleIndex; j < inputLength; j++) {
            rightList.add(inputList.get(j));
        }
        // Test Print
        System.out.printf("\nRight list: ");
        for (int item: rightList) {
            System.out.printf("%d\t", item);
        }
        // Use recursion to keep splitting
        mergeSort(leftList);
        mergeSort(rightList);

    }
}
