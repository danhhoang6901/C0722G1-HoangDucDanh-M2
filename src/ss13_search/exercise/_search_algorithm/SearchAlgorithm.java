package ss13_search.exercise._search_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SearchAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập kích thước của mảng: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size <= 0 || size > 20) {
                System.out.print("Kích thước mảng không hợp lệ! Hãy nhập lại: ");
            }
        } while (size <= 0 || size > 20);
        int[] arr = new int[size];
        int number;
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập phần từ thứ " + (i + 1) + " vào mảng: ");
            number = Integer.parseInt(scanner.nextLine());
            arr[i] = number;
        }
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Mảng được sắp xếp tăng dần: " + Arrays.toString(arr));
        System.out.print("Nhập số muốn tìm ví trí: ");
        int value = Integer.parseInt(scanner.nextLine());
        int index = binarySearch(arr, 0, arr.length - 1, value);
        System.out.println("Vị trí của số bạn nhập là: " + index);
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (right >= left) {
            int middle = (left + right) / 2;
            if (arr[middle] == value) {
                return middle;
            } else if (value > arr[middle]) {
                return binarySearch(arr, middle + 1, right, value);
            }
            return binarySearch(arr, left, middle - 1, value);
        }
        return -1;
    }
}

