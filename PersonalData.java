import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersonalData {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ФИО, дату рождения, номер телефона и пол (через пробел):");
        String input = scanner.nextLine();

        try {
            parseData(input);
        } catch (InvalidDataFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Данные успешно сохранены!");
    }

    private static void parseData(String input) throws InvalidDataFormatException, IOException {
        String[] parts = input.split(" ");

        if (parts.length != 6) {
            throw new InvalidDataFormatException("Неверное количество данных");
        }

        String lastName = parts[0];
        String firstName = parts[1];
        String fathername = parts[2];
        String birthDate = parts[3];
        String phoneNumberStr = parts[4];
        String genderStr = parts[5];

        validateBirthDate(birthDate);
        validatePhoneNumber(phoneNumberStr);
        validateGender(genderStr);

        long phoneNumber = Long.parseLong(phoneNumberStr);
        char gender = genderStr.charAt(0);

        String dataLine = String.format("%s %s %s %s %d %c", lastName, firstName, fathername, birthDate, phoneNumber, gender);

        try (FileWriter writer = new FileWriter(new File(lastName + ".txt"))) {
            writer.write(dataLine);
        }
    }















    private static void validateBirthDate(String birthDate) throws InvalidDataFormatException {
        if (!birthDate.matches("^\\d{2}\\.\\d{2}\\.\\d{4}$")) {
            throw new InvalidDataFormatException("Неверный формат даты рождения");
        }
    }

    private static void validatePhoneNumber(String phoneNumberStr) throws InvalidDataFormatException {
        if (!phoneNumberStr.matches("^\\d+$")) {
            throw new InvalidDataFormatException("Неверный формат номера телефона");
        }
    }

    private static void validateGender(String genderStr) throws InvalidDataFormatException {
        if (!genderStr.matches("[fm]")) {
            throw new InvalidDataFormatException("Неверный формат пола");
        }
    }
    class InvalidDataFormatException extends Exception {

        public InvalidDataFormatException(String message) {
            super(message);
        }
    }
}


