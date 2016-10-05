package ua.epam.xml;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denys_Shmyhin on 10/5/2016.
 */
public class ParserXml {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        DocumentBuilder documentBuilder;
        Document doc;

        try {
            documentBuilder =  factory.newDocumentBuilder();
            InputStream  in = ParserXml.class.getResourceAsStream("/user.xml");
            doc  = documentBuilder.parse(in);
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath =  xPathFactory.newXPath();

            getUsersByFirstName(doc,xpath,"Katya");

            System.out.println(getUserById(doc,xpath,1));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getUsersByFirstName(Document  doc,XPath xpath, String name){
        List<String> list = new ArrayList<>();
        try {
            String template  ="//user[first_name='" +
                              name +
                              "']/*[name()='first_name'or name()='last_name']/text()";

            XPathExpression expr =  xpath.compile(template);

            NodeList node = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < node.getLength(); i+=2) {

                list.add(node.item(i).getNodeValue()+ " " +node.item(i+1).getNodeValue());
            }


        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String  getUserById(Document doc,XPath xpath,int id){
        String  template = "//user[@id='" +
                            id +
                            "']/*/text()";
        StringBuilder result =  new StringBuilder();
        try {
            XPathExpression expr = xpath.compile(template);
            NodeList node = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i <node.getLength() ; i++) {
                result.append(node.item(i).getNodeValue()).append(" ");
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return  result.toString();
    }
}
