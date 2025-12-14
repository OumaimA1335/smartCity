
package com.smartCity.gateway.entities.fines;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addFine complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>{@code
 * <complexType name="addFine">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="fine" type="{http://services.finesService.smartCity.com/}fine" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addFine", propOrder = {
    "fine"
})
public class AddFine {

    protected Fine fine;

    /**
     * Obtient la valeur de la propriété fine.
     * 
     * @return
     *     possible object is
     *     {@link Fine }
     *     
     */
    public Fine getFine() {
        return fine;
    }

    /**
     * Définit la valeur de la propriété fine.
     * 
     * @param value
     *     allowed object is
     *     {@link Fine }
     *     
     */
    public void setFine(Fine value) {
        this.fine = value;
    }

}
