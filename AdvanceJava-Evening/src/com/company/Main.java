package com.company;
import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class Main {

    private static Document document;
    private static Document validDocument;
    private static Document invalidDocument;
    private static Element csr_body;
    private static Element valid_details;
    private static Element invalid_details;

    public static void  mergesimilarnodes(NodeList first,NodeList second,String Key)
    {
        for(int i=0;i<first.getLength();i++)
        {
            Element firstElement=(Element) first.item(i);
            for(int j=0;j<second.getLength();j++)
            {
                Element cisr_producer=document.createElement("CISR_PRODUCER");

                Element secondElement=(Element) second.item(j);
                String firstNipr=(firstElement.getAttribute(Key));
                String secondNipr=secondElement.getAttribute(Key);

                if(firstNipr.equals(secondNipr))
                {
                    cisr_producer=addAttributesToElement(cisr_producer,firstElement);
                    cisr_producer=matchLicense(firstElement.getElementsByTagName("License"),secondElement.getElementsByTagName("License"),"Date_Status_Effective","State_Code","License_Number",cisr_producer);
                    csr_body.appendChild(cisr_producer);
                }
            }
        }
        for(int i=0;i<first.getLength();i++)
        {
            Element currEl=(Element)first.item(i);
            FiltervalidinvalidNodes(currEl.getElementsByTagName("License"));
        }
        for(int i=0;i<second.getLength();i++)
        {
            Element currEl=(Element)second.item(i);
            FiltervalidinvalidNodes(currEl.getElementsByTagName("License"));
        }
    }




    private static Element addAttributesToElement(Element newElement,Element oldElement)
    {
        NamedNodeMap attributes=oldElement.getAttributes();
        for(int m=0;m<attributes.getLength();m++)
        {
            newElement.setAttribute(attributes.item(m).getNodeName(),attributes.item(m).getNodeValue());
        }
        return newElement;
    }

    private static Element validLicenseNode(Element source)
    {
        Element License=validDocument.createElement(source.getNodeName());
        License=addAttributesToElement(License,source);

        NodeList Loas=source.getElementsByTagName("LOA");
        for(int i=0;i<Loas.getLength();i++)
        {
            Element currLoa=(Element)Loas.item(i);
            Element newLoa=validDocument.createElement(currLoa.getNodeName());
            newLoa=addAttributesToElement(newLoa,currLoa);
            License.appendChild(newLoa);
        }
        return License;
    }

    private static Element invalidLicenseNode(Element source)
    {
        Element License=invalidDocument.createElement(source.getNodeName());
        License=addAttributesToElement(License,source);

        NodeList Loas=source.getElementsByTagName("LOA");
        for(int i=0;i<Loas.getLength();i++)
        {
            Element currLoa=(Element)Loas.item(i);
            Element newLoa=invalidDocument.createElement(currLoa.getNodeName());
            newLoa=addAttributesToElement(newLoa,currLoa);
            License.appendChild(newLoa);
        }
        return License;
    }


    private static void FiltervalidinvalidNodes(NodeList firstNode)
    {

        for(int i=0;i<firstNode.getLength();i++)
        {

            Element currEl=(Element) firstNode.item(i);
            String[] datedata=currEl.getAttribute("License_Expiration_Date").split("/");
            LocalDate expDate=LocalDate.parse(datedata[2]+'-'+datedata[0]+'-'+datedata[1]);

            long diff=ChronoUnit.DAYS.between(LocalDate.now() , expDate);
            if(diff > 0)
            {
                valid_details.appendChild(validLicenseNode(currEl));
            }
            else
            {
                invalid_details.appendChild(invalidLicenseNode(currEl));
            }
        }

    }


    public static Element matchLicense(NodeList firstNode,NodeList secondNode,String key,String key1,String key2,Element cisr_producer)
    {
        try {
            //System.out.println(firstNode.getLength());
            for(int i=0;i<firstNode.getLength();i++)
            {
                Element firstNodeElement=(Element) firstNode.item(i);
                for(int j=0;j<secondNode.getLength();j++)
                {
                    Element secondNodeElement=(Element) secondNode.item(j);
                    if(firstNodeElement.getAttribute(key).equals(secondNodeElement.getAttribute(key))
                            && firstNodeElement.getAttribute(key1).equals(secondNodeElement.getAttribute(key1))
                            && firstNodeElement.getAttribute(key2).equals(secondNodeElement.getAttribute(key2)))
                    {
                        Element License=document.createElement("License");
                        addAttributesToElement(License,firstNodeElement);


                        NodeList Loa=firstNodeElement.getElementsByTagName("LOA");
                        NodeList Loa2=secondNodeElement.getElementsByTagName("LOA");

                        for(int k=0;k<Loa.getLength();k++)
                        {
                            Element newLoa=document.createElement(Loa.item(k).getNodeName());
                            addAttributesToElement(newLoa,(Element)Loa.item(k));
                            License.appendChild(newLoa);
                        }
                        for(int k=0;k<Loa2.getLength();k++)
                        {
                            Element newLoa=document.createElement(Loa2.item(k).getNodeName());
                            addAttributesToElement(newLoa,(Element)Loa2.item(k));
                            License.appendChild(newLoa);
                        }
                        cisr_producer.appendChild(License);
                    }
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cisr_producer;
    }



    public static void main(String[] args) {
        try
        {
            File inputFile=new File("src/file1.xml");
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
            Document doc= dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();


            File inputFile2=new File("src/file2.xml");
            DocumentBuilderFactory dbFactory2=DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder2=dbFactory2.newDocumentBuilder();
            Document doc2= dBuilder2.parse(inputFile2);
            doc2.getDocumentElement().normalize();
            NodeList nList2=doc.getElementsByTagName("CSR_Producer");
            NodeList nList=doc2.getElementsByTagName("CSR_Producer");



            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();
            Element csr_report=document.createElement("CSR_Report");
            document.appendChild(csr_report);
            Element csr_report_header=document.createElement("CSR_Report_Header");
            csr_report_header=addAttributesToElement(csr_report_header,(Element)doc.getElementsByTagName("CSR_Report_Header").item(0));
            csr_report.appendChild(csr_report_header);
            csr_body = document.createElement("CSR_Report_Body");
            csr_report.appendChild(csr_body);

            validDocument=documentBuilder.newDocument();
            valid_details=validDocument.createElement("Valid_licenses");
            validDocument.appendChild(valid_details);

            invalidDocument=documentBuilder.newDocument();
            invalid_details=invalidDocument.createElement("Invalid_licenses");
            invalidDocument.appendChild(invalid_details);


            mergesimilarnodes(nList,nList2,"NIPR_Number");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("src/output.xml"));
            transformer.transform(domSource, streamResult);


            DOMSource validdomSource = new DOMSource(validDocument);
            StreamResult validstreamResult = new StreamResult(new File("src/validDoc.xml"));
            transformer.transform(validdomSource, validstreamResult);


            DOMSource invaliddomSource = new DOMSource(invalidDocument);
            StreamResult invalidstreamResult = new StreamResult(new File("src/invalidOutputFile.xml"));
            transformer.transform(invaliddomSource, invalidstreamResult);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

