package by.itacademy.hospital;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Set;

public class PatientsWriteDOM implements PatientsWrite {
    private String filename;
    private final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    public PatientsWriteDOM(String filename) {
        this.filename = filename;
    }

    @Override
    public void execute(Set<Patient> patients) throws IOException {
        Document doc = document();
        Element hospitalElement = doc.createElement("hospital");
        for (Patient patient : patients) {
            Element patientElement = doc.createElement("patient");
            Element nameElement = doc.createElement("surName");
            nameElement.setTextContent(patient.getName());
            Element surnameElement = doc.createElement("surname");
            surnameElement.setTextContent(patient.getSurname());
            Element birthdayElement = doc.createElement("dateOfBirth");
            birthdayElement.setTextContent(new java.sql.Date(patient.getBirth().getTime()).toString());
            Element healthElement = doc.createElement("health");
            healthElement.setTextContent(Boolean.toString(patient.isHealth()));

            patientElement.appendChild(nameElement);
            patientElement.appendChild(surnameElement);
            patientElement.appendChild(birthdayElement);
            patientElement.appendChild(healthElement);
            hospitalElement.appendChild(patientElement);
        }
        doc.appendChild(hospitalElement);

        Transformer transformer;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new IOException(e);
        }

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new IOException(e);
        }
    }

    private Document document() throws IOException {
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IOException(e);
        }
        return dBuilder.newDocument();
    }
}
