package com.javarush.task.task33.task3309;

import com.sun.java.browser.plugin2.DOM;
import com.sun.xml.internal.messaging.saaj.util.FastInfosetReflection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ContentHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        String out;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder db = factory.newDocumentBuilder();
            Document doc = db.newDocument();


            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.marshal(obj,doc);

            NodeList nodeList = doc.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node n = nodeList.item(i);
                String nodeName = n.getNodeName();
                Comment co = doc.createComment(comment);
                if (n.getNodeName().equals(tagName)){
                    n.insertBefore(co,n.get);
//                    n.appendChild(co);
                }
            }
            StringWriter sw = new StringWriter();
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.STANDALONE,"no");
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            out = sw.toString();
            System.out.println(out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Cats";
        cat.age = 10;
        toXmlWithComment(cat,"name","tmp comment");

    }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat {
        public String name;
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
