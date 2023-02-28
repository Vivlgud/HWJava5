package Java.HWork5;

import java.util.Arrays;

/*Реализовать алгоритм пирамидальной сортировки (HeapSort). */

public class task3 {

    public static void heapSort(int[] array, int length) {
        int temp;
        int size = length - 1;
        for (int i = (length / 2); i >= 0; i--) {
            heapify(array, i, size);
        }
        for (int i = size; i >= 0; i--) {
            temp = array[0];
            array[0] = array[size];
            array[size] = temp;
            size--;
            heapify(array, 0, size);
        }
        System.out.print("Отсортированный массив: ");
        System.out.println(Arrays.toString(array));
    }

    public static void heapify(int[] array, int i, int heapSize) {
        int leftNumber = 2 * i;
        int rightNumber = 2 * i + 1;
        int largestElement;
        if (leftNumber <= heapSize && array[leftNumber] > array[i]) {
            largestElement = leftNumber;
        } else {
            largestElement = i;
        }
        if (rightNumber <= heapSize && array[rightNumber] > array[largestElement]) {
            largestElement = rightNumber;
        }
        if (largestElement != i) {
            int temp = array[i];
            array[i] = array[largestElement];
            array[largestElement] = temp;
            heapify(array, largestElement, heapSize);
        }
    }

    public static void main(String args[]) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        heapSort(array, array.length);
    }
}