package com.cts.drl.design.droolsdesigner;

import com.cts.model.NotificationDataModel;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class RulesTransformer {

    public  void createRuleFiles(NotificationDataModel ruleDatamodel) throws JAXBException, ParserConfigurationException, TransformerException, IOException, SAXException {
        JAXBContext contextObj = JAXBContext.newInstance(NotificationDataModel.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<NotificationDataModel> jaxbElement =
                new JAXBElement<NotificationDataModel>( new QName("", "notificationData"),
                        NotificationDataModel.class,
                        ruleDatamodel);
        StringWriter sw = new StringWriter();
        marshallerObj.marshal(jaxbElement,sw);

        Document document;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inputSource = new InputSource( new StringReader( sw.toString() ) );
        document = builder.parse(inputSource);
        // ...
        TransformerFactory tFactory = TransformerFactory.newInstance();

        StreamSource stylesource = new StreamSource(this.getClass().getClassLoader().getResourceAsStream("rulestemplate.xsl"));
        Transformer transformer = tFactory.newTransformer(stylesource);

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }

}
