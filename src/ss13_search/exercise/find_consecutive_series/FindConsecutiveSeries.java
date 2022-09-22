package ss13_search.exercise.find_consecutive_series;

import java.util.LinkedList;
import java.util.Scanner;

public class FindConsecutiveSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi bất kỳ: ");
        String str = scanner.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > list.getLast()) {
                    list.add(str.charAt(j));
                } else {
                    break;
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        System.out.print("Chuỗi có độ dài lớn nhất là: ");
        for (Character linkedList : max) {
            System.out.print(linkedList);
        }

    }
}

