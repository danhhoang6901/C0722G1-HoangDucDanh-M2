package ss11_stack_queue.exercise.check_string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckStringPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        System.out.print("Nhập chuỗi bất kỳ: ");
        String string = scanner.nextLine();
        for (int i = 0; i < string.length(); i++) {
            queue.add(String.valueOf(string.charAt(i)));
            stack.add(String.valueOf(string.charAt(i)));
        }
        for (int i = 0; i < string.length(); i++) {
            if (!stack.pop().equalsIgnoreCase(queue.poll())) {
                System.out.println("Đây không phải là chuỗi Palindrome ");
                return;
            }
        }
        System.out.println("Đây là chuỗi Palindrome ");
    }
}
