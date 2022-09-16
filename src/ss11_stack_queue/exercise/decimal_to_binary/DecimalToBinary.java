package ss11_stack_queue.exercise.decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Nhập số thập phân: ");
        int decimal = Integer.parseInt(scanner.nextLine());
        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }
        System.out.print("Nhị phân: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
