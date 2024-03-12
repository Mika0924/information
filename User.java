import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
    private final String familiya;
    private final String name;
    private final String otchestvo;
    private final String birthDate;
    private final String phone;
    private final String gender;

    public User() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите familiya:");
            this.familiya = CheckingErrors.validateName(scanner.nextLine());
            System.out.println("Введите Имя:");
            this.name = CheckingErrors.validateName(scanner.nextLine());
            System.out.println("Введите otchestvo:");
            this.otchestvo = CheckingErrors.validateName(scanner.nextLine());
            System.out.println("Введите birthDate:");
            this.birthDate = CheckingErrors.validateBirthDate(scanner.nextLine());
            System.out.println("Введите phone:");
            this.phone = CheckingErrors.validatePhone(scanner.nextLine());
            System.out.println("Введите gender:");
            this.gender = CheckingErrors.validateGender(scanner.nextLine());
            createUser();
        }
    void createUser() throws Exception {
        try (FileWriter writer = new FileWriter(name + ".txt")) {
            String dataLine = String.format("%s %s %s %s %s %s", familiya, name, otchestvo, birthDate, phone, gender);
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
        else return;
    }

}


