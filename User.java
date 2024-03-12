import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
    private String familiya;
    private String name;
    private String otchestvo;
    private String birthDate;
    private String phone;
    private String gender;
    public User(String familiya,  String name,String otchestvo, String birthDate, String phone, String gender) {
        this.familiya = familiya;
        this.name = name;
        this.phone = phone;
        this.otchestvo = otchestvo;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    public User() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите familiya:");
        this.familiya = scanner.nextLine();
        System.out.println("Введите Имя:");
        this.name = scanner.nextLine();
        System.out.println("Введите otchestvo:");
        this.otchestvo = scanner.nextLine();
        System.out.println("Введите birthDate:");
        this.birthDate = CheckingErrors.validateBirthDate(scanner.nextLine());
        System.out.println("Введите phone:");
        this.phone = CheckingErrors.validatePhoneNumber(scanner.nextLine());
        System.out.println("Введите gender:");
        this.gender = CheckingErrors.validateGender(scanner.nextLine());
        try (FileWriter writer = new FileWriter(name + ".txt")) {
            String dataLine = String.format("%s %s %s %s %d %s", familiya, name, otchestvo, birthDate, phone, gender);
            writer.write(dataLine);
        }
    }



}