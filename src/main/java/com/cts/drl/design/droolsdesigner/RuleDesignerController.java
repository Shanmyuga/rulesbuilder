package com.cts.drl.design.droolsdesigner;

import com.cts.model.NotificationDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@RestController
public class RuleDesignerController {

    @Autowired
    private RulesTransformer transformer;

    @RequestMapping(method = RequestMethod.POST, path = "/saveData")
    public void saveRulesData(@RequestBody NotificationDataModel dataModel) {
        try {
            transformer.createRuleFiles(dataModel);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
