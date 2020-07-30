
package com.cts.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cts.model.Rule;
import com.cts.model.Trigger;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "description",
    "rules",
    "freqInterval",
    "triggerCondition",
    "trigger",
    "alertType",
    "alertMessage",
    "noOfRules"
})
public class NotificationDataModel {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("rules")
    private List<Rule> rules = new ArrayList<Rule>();
    @JsonProperty("freqInterval")
    private String freqInterval;
    @JsonProperty("triggerCondition")
    private String triggerCondition;
    @JsonProperty("trigger")
    private Trigger trigger;
    @JsonProperty("alertType")
    private String alertType;
    @JsonProperty("alertMessage")
    private String alertMessage;
    @JsonProperty("noOfRules")
    private Integer noOfRules;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("rules")
    public List<Rule> getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    @JsonProperty("freqInterval")
    public String getFreqInterval() {
        return freqInterval;
    }

    @JsonProperty("freqInterval")
    public void setFreqInterval(String freqInterval) {
        this.freqInterval = freqInterval;
    }

    @JsonProperty("triggerCondition")
    public String getTriggerCondition() {
        return triggerCondition;
    }

    @JsonProperty("triggerCondition")
    public void setTriggerCondition(String triggerCondition) {
        this.triggerCondition = triggerCondition;
    }

    @JsonProperty("trigger")
    public Trigger getTrigger() {
        return trigger;
    }

    @JsonProperty("trigger")
    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    @JsonProperty("alertType")
    public String getAlertType() {
        return alertType;
    }

    @JsonProperty("alertType")
    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    @JsonProperty("alertMessage")
    public String getAlertMessage() {
        return alertMessage;
    }

    @JsonProperty("alertMessage")
    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    @JsonProperty("noOfRules")
    public Integer getNoOfRules() {
        return noOfRules;
    }

    @JsonProperty("noOfRules")
    public void setNoOfRules(Integer noOfRules) {
        this.noOfRules = noOfRules;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
