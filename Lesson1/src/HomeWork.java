public class HomeWork {

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,3,4};
        int[] arr2 = new int[] {1,2,3};
       // exception1("f", 5); //Тут будет ошибка java.lang.NumberFormatException
        int num = exception2(10,0);  //Тут будет ошибка java.lang.ArithmeticException: / by zero
        exception3(arr1,arr2); //Тут будет ошибка java.lang.ArrayIndexOutOfBoundsException


    }

    public static int exception1(String s, int num) {
        return Integer.parseInt(s) + num;
    }

    public static int exception2(int num1, int num2) {
        return num1 / num2;
    }

    public static int[] exception3(int[] arr1, int[] arr2) { // Тут будет ошибка
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] += arr2[i];
        }
        return arr1;
    }

    public static int[] arraysDifference(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) throw new RuntimeException("Длины массивов не равны");
        int [] resultArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            resultArr[i] = arr1[i] - arr2[i];
        }
        return resultArr;
    }

    public static int[] arraysDivision(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) throw new RuntimeException("Один или несколько массивов не передан");
        if (arr1.length != arr2.length) throw new RuntimeException("Длины массивов не равны");
        int [] resultArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0 || arr2[i] == 0) throw new RuntimeException("Один из элементов массивов являеться 0(получить частное невозможно)");
            resultArr[i] = arr1[i] / arr2[i];
        }
        return resultArr;
    }




}
