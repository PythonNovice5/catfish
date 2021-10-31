package com.basware.bttf.util.generator.model;

//It represents items being in bundled
public class RelatedItem {
    private Item relatedMaster;
    private Item relatedItem;

    public Item getRelatedMaster()
    {
        return relatedMaster;
    }
    public void setRelatedMaster(Item relatedMaster)
    {
        this.relatedMaster = relatedMaster;
    }

    public Item getRelatedItem()
    {
        return relatedItem;
    }
    public void setRelatedItem(Item relatedItem)
    {
        this.relatedItem = relatedItem;
    }

}
