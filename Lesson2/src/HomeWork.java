import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork {

    public static void main(String[] args) {
        System.out.println(task1());
        task2();
        task3();
        task4();
    }

    public static float task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число через запятую");
        float num = 0;
        try {
            num = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Неверный формат числа");
            num = task1();
        }
        return num;
    }

    public static void task2() {
        double[] intArray = new double[9];
        intArray[8] = 10;
        try {
            int d = 1; // Т.к на 0 делить нельзя исправил на 1
            double catchedRes1 = intArray[8] / d; // Т.к массива intArray не существовало, создал массив и записал в ячейку с индексом 8 число 10
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }

    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2}; // Массив создан но нигде не используется
            abc[3] = 9; //  IndexOutOfBoundsException можно  поменять на инекс "1" например.
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) { //catch (Throwable ex) Переставил в конец
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) { // Тут лишний throws FileNotFoundException
        System.out.println(a + b);
    }

    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите не пустую строку");
        String str = scanner.nextLine();
        if (str.length() < 1) throw new RuntimeException("Пустые строки вводить нельзя");
    }


}

