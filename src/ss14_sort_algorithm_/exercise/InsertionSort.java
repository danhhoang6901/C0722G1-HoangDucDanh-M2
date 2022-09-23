package ss14_sort_algorithm_.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập kích thước mảng: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size >= 20 || size <= 0) {
                System.out.print("Kích thước không hợp lệ! Nhập lại: ");
            }
        } while (size >= 20 || size <= 0);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " vào mảng: ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Mảng sau khi được sắp xếp tăng dần: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }
}
