
package com.smartCity.gateway.entities.fines;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getFineByIdFineAndIdCitizen complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>{@code
 * <complexType name="getFineByIdFineAndIdCitizen">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="idFine" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="idCitizen" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFineByIdFineAndIdCitizen", propOrder = {
    "idFine",
    "idCitizen"
})
public class GetFineByIdFineAndIdCitizen {

    protected Long idFine;
    protected Long idCitizen;

    /**
     * Obtient la valeur de la propriété idFine.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdFine() {
        return idFine;
    }

    /**
     * Définit la valeur de la propriété idFine.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdFine(Long value) {
        this.idFine = value;
    }

    /**
     * Obtient la valeur de la propriété idCitizen.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdCitizen() {
        return idCitizen;
    }

    /**
     * Définit la valeur de la propriété idCitizen.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdCitizen(Long value) {
        this.idCitizen = value;
    }

}
