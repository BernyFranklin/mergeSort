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
    }

    private static void mergeSort(LinkedList<Integer> inputList) {
        int inputLength = inputList.size();
    }
}
