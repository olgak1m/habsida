import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        Scanner inline = new Scanner(System.in); // создает обьект inline на основе класса Scanner
        String expr = inline.nextLine(); // используем класс String для обьявлениЯ и инициализации строковой переменной
        String[] separate = expr.split(" "); //  разбиваем строку expr на массив символов separate
        int x, y, z, mid, result;

        if (separate.length == 3) {
            x = convStr(separate, 0);
            y = convStr(separate, 2);
            result = calc2(separate[1], x, y);
            System.out.println(result);

        }
        else if (separate.length == 5) {
            x = convStr(separate, 0);
            y = convStr(separate, 2);
            z = convStr(separate, 4);
            if (separate[3].equals("*") || separate[3].equals("/") && !separate[1].equals("*") || !separate[1].equals("/")) {
                mid = calc2(separate[3], y, z);
                result = calc2(separate[1], x, mid);
                System.out.println(result);
            } else {
                mid = calc2(separate[1], x, y);
                result = calc2(separate[3], mid, z);
                System.out.println(result);
            }

        }
        else {
            System.out.println("Ошибка ввода");
        }
    }


    public static int convStr(String[] line, int index) {
        int a = 0;
        try {
            a = Integer.valueOf(line[index]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
        }
        return a;
    }

    public static int calc2(String sign, int b, int c) {
        int d = 0;
        switch (sign) {
            case "*":
                d = b * c;
                break;
            case "/":
                d = b / c;
                break;
            case "+":
                d = b + c;
                break;
            case "-":
                d = b - c;
                break;
        }
        return d;
    }

}

