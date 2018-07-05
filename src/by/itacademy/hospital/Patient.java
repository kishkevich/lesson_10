package by.itacademy.hospital;

import java.util.Date;
import java.util.Set;

import static java.sql.Date.valueOf;

public class Patient {
    private String name;
    private String surname;
    private Date birth;
    private boolean health;

    public Patient(String name, String surname, Date birth, boolean health) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.health = health;
    }

    public Patient(String name, String surname, String birth, boolean health) {
        this(name, surname, java.sql.Date.valueOf(birth), health);
    }

    public Patient(String patient) {
        this(patient.split(";"));
    }

    public Patient(String[] properties) {
        this(properties[0], properties[1], properties[2], properties[3]);
    }

    public Patient(String name, String surname, String birth, String health) {
        this(name, surname, java.sql.Date.valueOf(birth), Boolean.getBoolean(health));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (!name.equals(patient.name)) return false;
        if (!surname.equals(patient.surname)) return false;
        return birth.equals(patient.birth);
    }



    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirth() {
        return birth;
    }

    public boolean isHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "by.itacademy.hospital.domain.Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                ", health=" + health +
                '}';
    }
}
