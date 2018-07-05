package by.itacademy.hospital;

import java.util.HashSet;
import java.util.Set;

public class Hospital {
    private Set<Patient> patients = new HashSet<>();

    public Patient add(Patient patient) {
        patients.remove(patient);
        patients.add(patient);
        return patient;

    }

    public void addAll(Set<Patient> patients) {
        this.patients.removeAll(patients);
        this.patients.addAll(patients);
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "by.itacademy.hospital.domain.Hospital{" +
                "patients=" + patients +
                '}';
    }
}
