package ss13_search.exercise.find_ascending_serie;

import java.util.Scanner;

public class FindAscendingSerie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi bất kỳ: ");
        String str = scanner.nextLine();
        String strings = "";
        String result = "";

        for (int i = 0; i < str.length() - 1; i++) {
            strings += str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    strings += str.charAt(j);
                    i = j;
                }
            }
            result = strings.length() > result.length() ? strings : result;
            strings = "";
        }
        System.out.println(result);
    }
}
