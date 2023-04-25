import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class HomeWork {

    public static void main(String[] args) {
        boolean flag = false;
        while (!flag) {
            try {
                getData();
                flag = true;

            } catch (EmptyDataException | DataElementException | InvalidValueException | IOException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void getData() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------\n" +
                "Введите данные в порядке указанном ниже:\n" +
                "Фамилия, Имя, Отчество, Дата рождения, Телефон, Пол\n" +
                "Данные указывать через пробел" +
                "Дата рождения - строка формата dd.mm.yyyy \n" +
                "Номер телефона - целое беззнаковое число без форматирования \n" +
                "Пример: Щукин Илья Андреевич 02.02.2002 8005553535 m");
        String inputData;
        inputData = scanner.nextLine();
        if (inputData.isEmpty()) {
            throw new EmptyDataException("Данные не введены");
        }

        inputData = inputData.replaceAll("\\s+", " ");
        inputData = inputData.trim();
        String[] bufferArray = inputData.split(" ");
        if (bufferArray.length == 6) {
            checkDateFormat(bufferArray[3]);
            checkPhoneNumberFormat(bufferArray[4]);
            checkGenderFormat(bufferArray[5]);
            createFile(bufferArray);

        } else {
            throw new DataElementException("Введены не все данные пользователя или\n" +
                    "при заполнении была допущена ошибка");
        }

    }


    public static void checkDateFormat(String date) throws InvalidValueException {

        char[] checkData = date.toCharArray();
        if (checkData.length == 10 && (checkData[2] == '.' && checkData[5] == '.')) {

        } else {
            throw new InvalidValueException("Дата введена неправильно. Правильный формат ввода данных dd.mm.yyyy");
        }
    }


    public static void checkPhoneNumberFormat(String phoneNumber) throws InvalidValueException {
        try {
            long check = Long.parseLong(phoneNumber);
        } catch (InvalidValueException e) {
            throw new InvalidValueException("Телефон введен неверно. " +
                    "Правильный формат ввода данных \"111222334455\". Без ковычек ");
        }
    }


    public static void checkGenderFormat(String gender) throws InvalidValueException {
        gender = gender.toLowerCase();
        if (gender.equals("m") || gender.equals("f")) {
            char[] charArray = gender.toCharArray();
            char convertedGender = charArray[0];
        } else {
            throw new InvalidValueException("Непрвльно указан пол !\n" +
                    "Правильный формат ввода данных для мужчины 'm', для женщины 'f'.");
        }

    }

    public static void createFile(String[] bufferArray) throws IOException {
        String fileName = bufferArray[0] + ".txt";
        File path = new File(fileName);
        if (!path.exists()) {
            path.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            String writeString = String.join(" ", bufferArray);
            bw.write(writeString);
            bw.newLine();

        } catch (IOException e) {
            throw new IOException("Произошла ошибка во время создания или записи файла");
        }

    }

    
}
