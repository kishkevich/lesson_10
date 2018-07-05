package by.itacademy.hospital;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class PatientsReadSax implements PatientsRead {
    private String filename;
    private final SAXParserFactory factory = SAXParserFactory.newInstance();


    public PatientsReadSax(String filename) {
        this.filename = filename;
    }

    @Override
    public Set<Patient> execute() throws IOException {
        SAXParser saxParser;
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException(e);
        }
        PatientsHandler patientsHandler = new PatientsHandler();
        try {
            saxParser.parse(new File(filename), patientsHandler);
        } catch (SAXException e) {
            throw new IOException(e);
        }
        return patientsHandler.getPatients();
    }


}
