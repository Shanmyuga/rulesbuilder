package com.cts.model;

public class ClaimsDataModel {

    private String clientOrgId;

    private String  channelTypeCode;

    private String  claimAcceptCode;

    private String  carrierId;

    private String pharmacyCode;

    private String ndcCode;

    public String getClientOrgId() {
        return clientOrgId;
    }

    public void setClientOrgId(String clientOrgId) {
        this.clientOrgId = clientOrgId;
    }

    public String getChannelTypeCode() {
        return channelTypeCode;
    }

    public void setChannelTypeCode(String channelTypeCode) {
        this.channelTypeCode = channelTypeCode;
    }

    public String getClaimAcceptCode() {
        return claimAcceptCode;
    }

    public void setClaimAcceptCode(String claimAcceptCode) {
        this.claimAcceptCode = claimAcceptCode;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getPharmacyCode() {
        return pharmacyCode;
    }

    public void setPharmacyCode(String pharmacyCode) {
        this.pharmacyCode = pharmacyCode;
    }

    public String getNdcCode() {
        return ndcCode;
    }

    public void setNdcCode(String ndcCode) {
        this.ndcCode = ndcCode;
    }
}
