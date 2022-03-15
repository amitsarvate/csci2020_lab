package com.example.lab05;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ReadXMLParser {

    public static final String XMLFILE = "/Users/amit.sar21/University/Second Year/Semester 2 /Systems Development and Integration - CSCI 2020/labs/lab05/src/main/resources/com/example/lab05/about.xml";
    private static String result[] = new String[4];


    public static String[] readXML() {

        // Instantiate the Factory
        DocumentBuilderFactory docbuildfact = DocumentBuilderFactory.newInstance();

        try {

            docbuildfact.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder docbuilder = docbuildfact.newDocumentBuilder();
            Document document = docbuilder.parse(new File(XMLFILE));
            document.getDocumentElement().normalize();
            NodeList list = document.getElementsByTagName("info");


            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    NodeList studentNoteList = element.getElementsByTagName("student");
                    String id = studentNoteList.item(0).getAttributes().getNamedItem("id").getTextContent();

                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String email = element.getElementsByTagName("email").item(0).getTextContent();
                    String software_description = element.getElementsByTagName("software-description").item(0).getTextContent();

                    result[0] = id;
                    result[1] = name;
                    result[2] = email;
                    result[3] = software_description;

                    return result;
                }

            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String[] result = ReadXMLParser.readXML();
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
    }

}
