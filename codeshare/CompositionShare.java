package org.familysearch.test.codeshare;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by tyganshelton on 5/6/2015.
 * Shows example of using common piece of logic from two different classes by composition.
 * Here, LineWriter and XMLWriter both have a TextWriter to share the toFile method.
 */
public class CompositionShare {

    interface Writer {
        void write(WeddingGift[] giftList, String fileName);
        String getFileName();
        String getFileContents();
    }

    public static class TextWriter {

        private Writer writer;

        public TextWriter(Writer writer){
            this.writer = writer;
        }

        public void toFile(){
            try {
                FileWriter output = new FileWriter(writer.getFileName());
                BufferedWriter bf=new BufferedWriter(output);
                bf.append(writer.getFileContents());
                bf.close();
                output.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static class LineWriter implements Writer{
        private TextWriter textWriter = new TextWriter(this);
        private String fileName, fileContents;

        public void write(WeddingGift[] giftList, String fileName) {
            StringBuilder result = new StringBuilder();
            result.append("\nWedding Gift List:\n");
            for (int i = 0; i < giftList.length; i++) {
                result.append("\nGift "+i+"\n");
                result.append("Name: " + giftList[i].getName()+"\n");
                result.append("Price: $" + giftList[i].getPrice()+"\n");
                result.append("Store: "+giftList[i].getStore()+"\n");
            }
            this.fileName = fileName;
            fileContents = result.toString();
            textWriter.toFile();
        }

        public String getFileContents() {
            return fileContents;
        }

        public String getFileName() {
            return fileName;
        }
    }

    public static class XMLWriter implements Writer{
        private TextWriter textWriter = new TextWriter(this);
        private String fileName, fileContents;

        public void write(WeddingGift[] giftList, String fileName) {
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

                for (int i = 0; i < giftList.length; i++) {
                    // set attribute to staff element
                    Attr attr = doc.createAttribute("id");
                    attr.setValue(String.valueOf(i + 1));
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
                this.fileName = fileName;
                fileContents = baos.toString();
                textWriter.toFile();
            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
        }

        public String getFileContents() {
            return fileContents;
        }

        public String getFileName() {
            return fileName;
        }
    }

    public static void main(String[] args){
        WeddingGift gift0 = new WeddingGift("Jacuzzi", 399, "Bed Bath and Beyond");
        WeddingGift gift1 = new WeddingGift("Microwave", 75, "Target");
        WeddingGift[] giftList = new WeddingGift[2];
        giftList[0] = gift0;
        giftList[1] = gift1;
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.write(giftList, "CompositionGifts.xml");
        LineWriter lineWriter = new LineWriter();
        lineWriter.write(giftList, "CompositionGifts.txt");
        System.out.println("Completed");
    }
}
