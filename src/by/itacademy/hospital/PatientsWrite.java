package by.itacademy.hospital;

import java.io.IOException;
import java.util.Set;

public interface PatientsWrite {
    void execute(Set<Patient> patients) throws IOException;
}
