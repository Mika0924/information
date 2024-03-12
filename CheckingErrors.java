import java.util.Scanner;

class CheckingErrors extends Exception  {
    static String validateGender(String genderStr) throws CheckingErrors {
        if (genderStr.matches("[fm]")) {
            return genderStr;
        }
        throw new CheckingErrors("Неверный формат пола");

    }
    static String validateBirthDate(String birthDate) throws CheckingErrors {
        if (birthDate.matches("^\\d{2}\\.\\d{2}\\.\\d{4}$")) {
            return birthDate;
        }
        throw new CheckingErrors("Неверный формат даты рождения");
    }

    static String validatePhone(String phoneNumberStr) throws CheckingErrors {
        if (phoneNumberStr.matches("^(\\+7|8)?[0-9]{10,15}$"))
            return phoneNumberStr;
        throw new CheckingErrors("Неверный формат номера. Пример: (+7|8)1234567890");

    }
    static String validateName(String phoneNumberStr) throws CheckingErrors {
        if (!phoneNumberStr.matches("\\D*")) {
            throw new CheckingErrors("Имя содержит цифры");
        }
        return phoneNumberStr;
    }


     public CheckingErrors(String message) {
        super(message);
    }
}
