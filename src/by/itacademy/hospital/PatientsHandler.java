package by.itacademy.hospital;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class PatientsHandler extends DefaultHandler {
    private Set<Patient> patients = new HashSet<>();
    private String name;
    private String surName;
    private String date;
    private String health;
    private boolean isName;
    private boolean isSurName;
    private boolean isDate;
    private boolean isHealth;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("surname"))
            isSurName = true;
        else if (qName.equalsIgnoreCase("name"))
            isName = true;
        else if (qName.equalsIgnoreCase("dateOfBirth"))
            isDate = true;
        else if (qName.equalsIgnoreCase("health"))
            isHealth = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Patient" ))
            patients.add(new Patient(surName, name, date, health));
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            name = new String(ch, start, length);
            isName = false;
        } else if (isSurName) {
            surName = new String(ch, start, length);
            isSurName = false;
        } else if (isDate) {
            date = new String(ch, start, length);
            isDate = false;
        } else if (isHealth) {
            health = new String(ch, start, length);
            isHealth = false;
        }
    }

    public Set<Patient> getPatients() {
        return patients;
    }
}
