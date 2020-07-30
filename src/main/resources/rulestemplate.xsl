<?xml version="1.0"?>

<xsl:stylesheet  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="text" />





    <xsl:template match="notificationData">

        package com.cts.notification.rules;



        import com.cts.model.ClaimsDataModel;



        import com.cts.model.NotificationSettinngsModel;




        <xsl:for-each select="//rules">
            rule "CLM_<xsl:value-of select="name"></xsl:value-of>"

            dialect "mvel"

            when
        <xsl:for-each select="conditions">
            ClaimsDataModel( <xsl:value-of select="field"></xsl:value-of>  <xsl:text>  </xsl:text>  <xsl:value-of select="operation"></xsl:value-of>  <xsl:text>  </xsl:text>  <xsl:value-of select="value"></xsl:value-of>  )



        </xsl:for-each>



        then


            NotificationSettinngsModel model = new NotificationSettinngsModel();

            model.setKey("<xsl:value-of select="notificationKey"></xsl:value-of>");

            insert(model);







        end
        </xsl:for-each>

        rule "NOT_<xsl:value-of select="name"></xsl:value-of>"

        dialect "mvel"

        when
        NotificationSettingsData(name == null)


        then
        NotificationSettingsData model = new NotificationSettingsData();

        model.setAlertType("<xsl:value-of select="alertType"></xsl:value-of>");
        model.setFreqInterval("<xsl:value-of select="freqInterval"></xsl:value-of>");
        model.setTriggerCondition("<xsl:value-of select="trigger/function"></xsl:value-of>(
        <xsl:for-each select="//args">
            <xsl:value-of select="."/>
            <xsl:choose>
                <xsl:when test="position() != last()">,</xsl:when>
            </xsl:choose>
        </xsl:for-each>)  <xsl:value-of select="trigger/operation"></xsl:value-of> <xsl:text>  </xsl:text><xsl:value-of select="trigger/threshold"></xsl:value-of>");
        model.setAlertMessage("<xsl:value-of select="alertMessage"></xsl:value-of>");
        end
    </xsl:template>



</xsl:stylesheet>