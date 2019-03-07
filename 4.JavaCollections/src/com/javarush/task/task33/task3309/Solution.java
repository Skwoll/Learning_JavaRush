package com.javarush.task.task33.task3309;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        String out = "";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder db = factory.newDocumentBuilder();
            Document doc = db.newDocument();

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.STANDALONE,"no");
            transformer.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS,"yes");
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");

            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            marshaller.marshal(obj,doc);

            NodeList nodeList = doc.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node n = nodeList.item(i);
                String nodeName = n.getNodeName();
                Comment co = doc.createComment(comment);
                if (n.getNodeName().equals(tagName)){
                    n.getParentNode().insertBefore(co,n);

                }

                if(n.getFirstChild().getNodeType() == Node.TEXT_NODE &&
                        n.getFirstChild().getTextContent().matches(".*[<>&'\"].*")){
                    CDATASection cdataSection = doc.createCDATASection(n.getFirstChild().getTextContent());
                    n.setTextContent("");
                    n.appendChild(cdataSection);
                }
            }
            StringWriter sw = new StringWriter();

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            out = sw.toString();
//            System.out.println(out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        return out;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Cats";
        cat.age = 10;
        System.out.println(toXmlWithComment(cat,"item","tmp comment"));

    }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat {
        public String name;
        @XmlElement(name = "item")
        public String item1 = "asdasds";
        @XmlElement(name = "item")
        public String item2 = "<asdasfasfds>";
        @XmlElement(name = "item")
        public String item3 = "<![CDATA[need CDATA because of <item />]]>";
        @XmlElement(name = "item")
        public String item4 = "sdfdsfasasdas & <dsfds.>";
        public int age;
        public int weight;

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }
    }
}
