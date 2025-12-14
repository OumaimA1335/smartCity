
package com.smartCity.gateway.entities.fines;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour fine complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>{@code
 * <complexType name="fine">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="amount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="paid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="citizen_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fine", propOrder = {
    "id",
    "amount",
    "reason",
    "paid",
    "citizenId"
})
public class Fine {

    protected Long id;
    protected double amount;
    protected String reason;
    protected boolean paid;
    @XmlElement(name = "citizen_id")
    protected Long citizenId;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété amount.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Définit la valeur de la propriété amount.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Obtient la valeur de la propriété reason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Définit la valeur de la propriété reason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Obtient la valeur de la propriété paid.
     * 
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * Définit la valeur de la propriété paid.
     * 
     */
    public void setPaid(boolean value) {
        this.paid = value;
    }

    /**
     * Obtient la valeur de la propriété citizenId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCitizenId() {
        return citizenId;
    }

    /**
     * Définit la valeur de la propriété citizenId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCitizenId(Long value) {
        this.citizenId = value;
    }

}
