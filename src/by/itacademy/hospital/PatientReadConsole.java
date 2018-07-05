package by.itacademy.hospital;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class PatientReadConsole {
    private Scanner scanner = new Scanner(System.in);
    Hospital hospital;

    public Patient addPatient() {
        return new Patient(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
    }
}

