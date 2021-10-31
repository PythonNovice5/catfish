package com.basware.bttf.util.generator.model;

public class Item
{
    private String id;
    private String deliveryType;
    private String standardType;
    private String itemType;
    private String deliveryId;
    private String uom;
    private String numberInAnOrderUnit;
    private String price;
    private String taxCode;
    private String taxTerritory;
    private String minOrderQty;
    private String qtyInterval;
    private String unspsc;
    private String shortDescription;
    private String longDescription;
    private String keywords;
    private String manPartId;
    private String manName;


    public void setId( String id )
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public String getDeliveryType() { return deliveryType; }

    public String getStandardType() { return standardType; }

    public String getitemType()
    {
        return itemType;
    }

    public String getDeliveryId() { return deliveryId; }

    public void setDeliveryId(String id) { deliveryId = id; }

    public String getUom()
    {
        return uom;
    }

    public String getNumberInAnOrderUnit()
    {
        return numberInAnOrderUnit;
    }

    public String getPrice()
    {
        return price;
    }

    public String getTaxCode()
    {
        return taxCode;
    }

    public String getTaxTerritory()
    {
        return taxTerritory;
    }

    public String getMinOrderQty()
    {
        return minOrderQty;
    }

    public String getQtyInterval()
    {
        return qtyInterval;
    }

    public String getUnspsc()
    {
        return unspsc;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public String getLongDescription()
    {
        return longDescription;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public String getManPartId()
    {
        return manPartId;
    }

    public String getManName()
    {
        return manName;
    }
}