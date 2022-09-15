package ss11_stack_queue.exercise.invert_element;

import java.util.Scanner;
import java.util.Stack;

public class Reversestring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        System.out.print("Nhập 1 chuỗi bất kỳ: ");
        String string = scanner.nextLine();
        String str = "";
        for (int i = 0; i < string.length(); i++) {
            stack.push(String.valueOf(string.charAt(i)));
        }
//        System.out.println(stack);
        for (int i = 0; i < string.length(); i++) {
            str += stack.pop();
        }
        System.out.println(str);
    }
}
