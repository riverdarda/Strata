//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.20 at 01:28:29 PM CDT 
//


package com.opengamma.strata.examples.fpml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * A type that specifies the classification of a party.
 * 
 * <p>Java class for PartyEntityClassification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartyEntityClassification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="partyReference" type="{http://www.fpml.org/FpML-5/pretrade}PartyReference" minOccurs="0"/>
 *         &lt;element name="entityClassification" type="{http://www.fpml.org/FpML-5/pretrade}EntityClassification" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyEntityClassification", propOrder = {
    "partyReference",
    "entityClassification"
})
public class PartyEntityClassification {

    protected PartyReference partyReference;
    protected EntityClassification entityClassification;

    /**
     * Gets the value of the partyReference property.
     * 
     * @return
     *     possible object is
     *     {@link PartyReference }
     *     
     */
    public PartyReference getPartyReference() {
        return partyReference;
    }

    /**
     * Sets the value of the partyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyReference }
     *     
     */
    public void setPartyReference(PartyReference value) {
        this.partyReference = value;
    }

    /**
     * Gets the value of the entityClassification property.
     * 
     * @return
     *     possible object is
     *     {@link EntityClassification }
     *     
     */
    public EntityClassification getEntityClassification() {
        return entityClassification;
    }

    /**
     * Sets the value of the entityClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityClassification }
     *     
     */
    public void setEntityClassification(EntityClassification value) {
        this.entityClassification = value;
    }

}