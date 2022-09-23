package ss14_sort_algorithm_.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class SortAlgorithmIllustration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập kích thước mảng: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size >= 20 || size <= 0) {
                System.out.println("Kích thước không hợp lệ!");
                System.out.print("Mời bạn nhập lại: ");
            }
        } while (size >= 20 || size <= 0);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " vào mảng: ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        System.out.println("Bắt đầu xử lý sắp xếp...\n");
        insertionSort(arr);
        System.out.println("Mảng sau khi được sắp xếp tăng dần: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            System.out.println("Gán phần tử arr[i] = " + arr[i] + " tại vị trí " + i + " cho key");
            System.out.println("key = " + key);
            System.out.println("...");
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                System.out.println("Đủ điểu kiện duyệt vòng lặp j");
                System.out.println("Gán phần tử arr[j] = " + arr[j] + " tại vị trí " + j + " cho phần tử arr[j + 1] = " + arr[j + 1] + " tại vị trí " + (j + 1));
                arr[j + 1] = arr[j];
                System.out.println("arr[j + 1] = " + arr[j]);
                System.out.println("arr = " + Arrays.toString(arr) + "\n");
            }
            System.out.println("Sai điều kiện duyệt vòng lặp j");
            System.out.println("Gán key = " + key + " cho phần tử arr[j + 1] = " + arr[j + 1] + " tại vị trí " + (j + 1));
            arr[j + 1] = key;
            System.out.println("arr[j + 1] = " + key);
            System.out.println("arr = " + Arrays.toString(arr) + "\n");
        }
    }
}
