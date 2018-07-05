package by.itacademy.hospital;

import java.io.IOException;
import java.net.MalformedURLException;

public class Secretary {
    private Hospital hospital;
   /// private PatientsRead read = new PatientsReadSax("C:\\Users\\hp\\Desktop\\ListPatient");
    private PatientReadConsole readConsole = new PatientReadConsole();

    public Secretary(Hospital hospital) throws MalformedURLException {
        this.hospital = hospital;
    }




    public void console(){
        readConsole.addPatient();
    }
}
