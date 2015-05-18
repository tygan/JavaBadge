package org.familysearch.test.codeshare;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by tyganshelton on 5/6/2015.
 * Shows example of using common piece of logic from two different classes by inheritance.
 * Here, LineWriter and XMLWriter both inherit from TextWriter to share the toFile method.
 */
public class InheritanceShare {

    public static class Writer {

        public void toFile(String fileContents, String fileName){
            try {
                FileWriter output = new FileWriter(fileName);
                BufferedWriter writer=new BufferedWriter(output);
                writer.append(fileContents);
                writer.close();
                output.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

        public void write(WeddingGift[] giftList, String fileName){}
    }

    public static class LineWriter extends Writer{

        public void write(WeddingGift[] giftList, String fileName) {
            StringBuilder result = new StringBuilder();
            result.append("\nWedding Gift List:\n");
            for (int i = 0; i < giftList.length; i++) {
                result.append("\nGift "+i+"\n");
                result.append("Name: " + giftList[i].getName()+"\n");
                result.append("Price: $" + giftList[i].getPrice()+"\n");
                result.append("Store: "+giftList[i].getStore()+"\n");
            }
            toFile(result.toString(), fileName);
        }
    }

    public static class XMLWriter extends Writer{
        public void write(WeddingGift[] giftList, String fileName){
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                // root elements
                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("WeddingGiftList");
                doc.appendChild(rootElement);

                // staff elements
                Element staff = doc.createElement("WeddingGift");
                rootElement.appendChild(staff);

                for(int i=0; i<giftList.length; i++) {
                    // set attribute to staff element
                    Attr attr = doc.createAttribute("id");
                    attr.setValue(String.valueOf(i+1));
                    staff.setAttributeNode(attr);

                    // name elements
                    Element name = doc.createElement("name");
                    name.appendChild(doc.createTextNode(giftList[i].getName()));
                    staff.appendChild(name);

                    // price elements
                    Element lastname = doc.createElement("price");
                    lastname.appendChild(doc.createTextNode(String.valueOf(giftList[i].getPrice())));
                    staff.appendChild(lastname);

                    // store elements
                    Element store = doc.createElement("store");
                    store.appendChild(doc.createTextNode(giftList[i].getStore()));
                    staff.appendChild(store);
                }

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                //StreamResult result = new StreamResult(new File("C:\\file.xml"));
                OutputStream baos = new ByteArrayOutputStream();
                StreamResult result = new StreamResult(baos);

                transformer.transform(source, result);
                toFile(baos.toString(), fileName);
            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe){
                tfe.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        WeddingGift gift0 = new WeddingGift("Jacuzzi", 399, "Bed Bath and Beyond");
        WeddingGift gift1 = new WeddingGift("Microwave", 75, "Target");
        WeddingGift[] giftList = new WeddingGift[2];
        giftList[0] = gift0;
        giftList[1] = gift1;
        Writer xmlWriter = new XMLWriter();
        xmlWriter.write(giftList, "InheritanceGifts.xml");
        Writer lineWriter = new LineWriter();
        lineWriter.write(giftList, "InheritanceGifts.txt");
        System.out.println("Completed");
    }
}
