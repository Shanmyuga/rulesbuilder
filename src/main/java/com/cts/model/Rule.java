
package com.cts.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cts.model.Condition;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ruleId",
    "name",
    "notificationKey",
    "noOfConditions",
    "conditions"
})
public class Rule {

    @JsonProperty("ruleId")
    private String ruleId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("notificationKey")
    private String notificationKey;
    @JsonProperty("noOfConditions")
    private Integer noOfConditions;
    @JsonProperty("conditions")
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ruleId")
    public String getRuleId() {
        return ruleId;
    }

    @JsonProperty("ruleId")
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("notificationKey")
    public String getNotificationKey() {
        return notificationKey;
    }

    @JsonProperty("notificationKey")
    public void setNotificationKey(String notificationKey) {
        this.notificationKey = notificationKey;
    }

    @JsonProperty("noOfConditions")
    public Integer getNoOfConditions() {
        return noOfConditions;
    }

    @JsonProperty("noOfConditions")
    public void setNoOfConditions(Integer noOfConditions) {
        this.noOfConditions = noOfConditions;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
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
