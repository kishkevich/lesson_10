package by.itacademy.hospital;

import java.io.IOException;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.add(new Patient("John", "Jonson", "1984-12-12", true));
//        hospital.add(new Patient("Jack", "Daniel", "1861-12-12", false));

        PatientsReadSax patientsReadSax = new PatientsReadSax("ListPatient");
        try {
            Set<Patient> patientSet = patientsReadSax.execute();
            System.out.println(patientSet);

        } catch (IOException e) {
            e.printStackTrace();
        }

        PatientReadConsole readConsole = new PatientReadConsole();
        hospital.add(readConsole.addPatient());
        PatientsWriteDOM patientsWriteDOM = new PatientsWriteDOM("ListPatient");
        try {
            patientsWriteDOM.execute(hospital.getPatients());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(hospital);

    }
}

