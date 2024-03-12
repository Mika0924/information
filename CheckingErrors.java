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

    static String validatePhoneNumber(String phoneNumberStr) throws CheckingErrors {
        if (phoneNumberStr.matches("^(\\+7|8)?[0-9]{10,15}$"))
            return phoneNumberStr;
        throw new CheckingErrors("Неверный формат phone");
    }

    public CheckingErrors(String message) {
        super(message);
    }
}
