package com.cts.drl.design.droolsdesigner;

import com.cts.model.Condition;
import com.cts.model.NotificationDataModel;
import com.cts.model.Rule;
import com.cts.model.Trigger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;
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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

@SpringBootTest
class DroolsdesignerApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void testRuleDataTransformation() throws JAXBException {

        NotificationDataModel ruleDataModel = new NotificationDataModel();
        ruleDataModel.setName("Cigna Commerical Claims Reject Claim Alert");
        ruleDataModel.setDescription("Alert Cigna Commercial Claims based on Reject claims during the prescribed interval");
        Rule rule = new Rule();
        rule.setName("CIGNA_COMMERICAL_CLAIM_COUNT");
        rule.setNotificationKey("TOTAL_COUNT");
        Condition condition = new Condition();
        condition.setField("clientOrgID");
        condition.setOperation("==");
        condition.setValue("2107");
        rule.getConditions().add(condition);
         condition = new Condition();
        condition.setField("channelCode");
        condition.setOperation("==");
        condition.setValue("R");
        rule.getConditions().add(condition);
        ruleDataModel.getRules().add(rule);
         rule = new Rule();
        rule.setName("CIGNA_COMMERICAL_CLAIM_REJECT_COUNT");
        rule.setNotificationKey("TOTAL_REJECT_COUNT");
         condition = new Condition();
        condition.setField("clientOrgID");
        condition.setOperation("==");
        condition.setValue("\"2107\"");
        rule.getConditions().add(condition);
        condition = new Condition();
        condition.setField("channelCode");
        condition.setOperation("==");
        condition.setValue("R");
        rule.getConditions().add(condition);
        condition = new Condition();
        condition.setField("clmAcceptCode");
        condition.setOperation("==");
        condition.setValue("N");
        rule.getConditions().add(condition);
        ruleDataModel.getRules().add(rule);
        ruleDataModel.setAlertType("EMAIL");
        ruleDataModel.setFreqInterval("EVERY_15_MIN");
        ruleDataModel.setTriggerCondition("percent(REJECT_COUNT/TOTAL_COUNT) > 20 ");
        ruleDataModel.setAlertMessage("TEST message");
        Trigger trigger = new Trigger();
        trigger.setFunction("percent");
        trigger.getArgs().add("REJECT_COUNT");
        trigger.getArgs().add("TOTAL_COUNT");
        trigger.setOperation("&gt;");
        trigger.setThreshold(20);
        ruleDataModel.setTrigger(trigger);
        JAXBContext contextObj = JAXBContext.newInstance(NotificationDataModel.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<NotificationDataModel> jaxbElement =
                new JAXBElement<NotificationDataModel>( new QName("", "notificationData"),
                        NotificationDataModel.class,
                        ruleDataModel);

        marshallerObj.marshal(jaxbElement,System.out);
    }

    @Test
    public void testXSLTransformation() throws ParserConfigurationException, TransformerException, IOException, SAXException {

            Document document;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(this.getClass().getClassLoader().getResourceAsStream("rulesdata.xml"));
            // ...
            TransformerFactory tFactory = TransformerFactory.newInstance();

            StreamSource stylesource = new StreamSource(this.getClass().getClassLoader().getResourceAsStream("rulestemplate.xsl"));
            Transformer transformer = tFactory.newTransformer(stylesource);

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
        }
}
