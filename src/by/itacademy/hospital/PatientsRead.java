package by.itacademy.hospital;

import java.io.IOException;
import java.util.Set;

public interface PatientsRead {
    Set<Patient> execute() throws IOException;
}