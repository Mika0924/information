import java.io.FileWriter;
import java.util.Scanner;

public class User {
    private final String surname;
    private final String name;
    private final String fathername;
    private final String birthDate;
    private final String phone;
    private final String gender;

    public User() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите Фамилию:");
            this.surname = CheckingErrors.validateName(scanner.nextLine());
            System.out.println("Введите Имя:");
            this.name = CheckingErrors.validateName(scanner.nextLine());
            System.out.println("Введите Отчество:");
            this.fathername = CheckingErrors.validateName(scanner.nextLine());
            System.out.println("Введите дату рождения в формате dd.mm.yyyy:");
            this.birthDate = CheckingErrors.validateBirthDate(scanner.nextLine());
            System.out.println("Введите номер:");
            this.phone = CheckingErrors.validatePhone(scanner.nextLine());
            System.out.println("Введите гендер(f/m):");
            this.gender = CheckingErrors.validateGender(scanner.nextLine());
            createUser();
        }
    void createUser() throws Exception {
        try (FileWriter writer = new FileWriter(name + ".txt")) {
            String dataLine = String.format("%s %s %s %s %s %s", surname, name, fathername, birthDate, phone, gender);
            writer.write(dataLine);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            reverse();
        }
    }
    void reverse() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("хотите повторить попытку?(да/нет)");
        String input = s.nextLine();
        if (input == "да") {
            User u = new User();
        }
    }

}


