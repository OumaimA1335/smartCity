
package com.smartCity.gateway.entities.citizen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addCitizen complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>{@code
 * <complexType name="addCitizen">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="citizen" type="{http://services.finesService.smartCity.com/}citizen" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addCitizen", propOrder = {
    "citizen"
})
public class AddCitizen {

    protected Citizen citizen;

    /**
     * Obtient la valeur de la propriété citizen.
     * 
     * @return
     *     possible object is
     *     {@link Citizen }
     *     
     */
    public Citizen getCitizen() {
        return citizen;
    }

    /**
     * Définit la valeur de la propriété citizen.
     * 
     * @param value
     *     allowed object is
     *     {@link Citizen }
     *     
     */
    public void setCitizen(Citizen value) {
        this.citizen = value;
    }

}
