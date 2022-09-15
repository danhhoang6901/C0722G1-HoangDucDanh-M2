package ss11_stack_queue.exercise.invert_element;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class InvertElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int size;
        do {
            System.out.print("Nhập kích thước mảng: ");
            size = Integer.parseInt(scanner.nextLine());
        } while (size >= 10 || size <= 0);

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " vào mảng: ");
            arr[i] = Integer.parseInt(scanner.nextLine());
            stack.push(arr[i]);
        }
        System.out.println(stack);
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }
}
