package ss11_stack_queue.exercise.check_bracket;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Nhập 1 biểu thức: ");
        String string = scanner.nextLine();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.push(string.charAt(i));
            }
            if (string.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return;
                } else if (stack.pop() != '(') {
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty() ? "Well" : "No");
    }
}
