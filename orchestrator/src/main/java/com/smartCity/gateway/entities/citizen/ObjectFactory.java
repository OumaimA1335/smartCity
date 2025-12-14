
package com.smartCity.gateway.entities.citizen;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.smartCity.gateway.entities.citizen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _AddCitizen_QNAME = new QName("http://services.finesService.smartCity.com/", "addCitizen");
    private static final QName _AddCitizenResponse_QNAME = new QName("http://services.finesService.smartCity.com/", "addCitizenResponse");
    private static final QName _Citizen_QNAME = new QName("http://services.finesService.smartCity.com/", "citizen");
    private static final QName _GetCitizenById_QNAME = new QName("http://services.finesService.smartCity.com/", "getCitizenById");
    private static final QName _GetCitizenByIdResponse_QNAME = new QName("http://services.finesService.smartCity.com/", "getCitizenByIdResponse");
    private static final QName _GetCitizenFines_QNAME = new QName("http://services.finesService.smartCity.com/", "getCitizenFines");
    private static final QName _GetCitizenFinesResponse_QNAME = new QName("http://services.finesService.smartCity.com/", "getCitizenFinesResponse");
    private static final QName _GetCitizens_QNAME = new QName("http://services.finesService.smartCity.com/", "getCitizens");
    private static final QName _GetCitizensResponse_QNAME = new QName("http://services.finesService.smartCity.com/", "getCitizensResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.smartCity.gateway.entities.citizen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCitizen }
     * 
     * @return
     *     the new instance of {@link AddCitizen }
     */
    public AddCitizen createAddCitizen() {
        return new AddCitizen();
    }

    /**
     * Create an instance of {@link AddCitizenResponse }
     * 
     * @return
     *     the new instance of {@link AddCitizenResponse }
     */
    public AddCitizenResponse createAddCitizenResponse() {
        return new AddCitizenResponse();
    }

    /**
     * Create an instance of {@link Citizen }
     * 
     * @return
     *     the new instance of {@link Citizen }
     */
    public Citizen createCitizen() {
        return new Citizen();
    }

    /**
     * Create an instance of {@link GetCitizenById }
     * 
     * @return
     *     the new instance of {@link GetCitizenById }
     */
    public GetCitizenById createGetCitizenById() {
        return new GetCitizenById();
    }

    /**
     * Create an instance of {@link GetCitizenByIdResponse }
     * 
     * @return
     *     the new instance of {@link GetCitizenByIdResponse }
     */
    public GetCitizenByIdResponse createGetCitizenByIdResponse() {
        return new GetCitizenByIdResponse();
    }

    /**
     * Create an instance of {@link GetCitizenFines }
     * 
     * @return
     *     the new instance of {@link GetCitizenFines }
     */
    public GetCitizenFines createGetCitizenFines() {
        return new GetCitizenFines();
    }

    /**
     * Create an instance of {@link GetCitizenFinesResponse }
     * 
     * @return
     *     the new instance of {@link GetCitizenFinesResponse }
     */
    public GetCitizenFinesResponse createGetCitizenFinesResponse() {
        return new GetCitizenFinesResponse();
    }

    /**
     * Create an instance of {@link GetCitizens }
     * 
     * @return
     *     the new instance of {@link GetCitizens }
     */
    public GetCitizens createGetCitizens() {
        return new GetCitizens();
    }

    /**
     * Create an instance of {@link GetCitizensResponse }
     * 
     * @return
     *     the new instance of {@link GetCitizensResponse }
     */
    public GetCitizensResponse createGetCitizensResponse() {
        return new GetCitizensResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCitizen }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCitizen }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "addCitizen")
    public JAXBElement<AddCitizen> createAddCitizen(AddCitizen value) {
        return new JAXBElement<>(_AddCitizen_QNAME, AddCitizen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCitizenResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCitizenResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "addCitizenResponse")
    public JAXBElement<AddCitizenResponse> createAddCitizenResponse(AddCitizenResponse value) {
        return new JAXBElement<>(_AddCitizenResponse_QNAME, AddCitizenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Citizen }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Citizen }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "citizen")
    public JAXBElement<Citizen> createCitizen(Citizen value) {
        return new JAXBElement<>(_Citizen_QNAME, Citizen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizenById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCitizenById }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getCitizenById")
    public JAXBElement<GetCitizenById> createGetCitizenById(GetCitizenById value) {
        return new JAXBElement<>(_GetCitizenById_QNAME, GetCitizenById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizenByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCitizenByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getCitizenByIdResponse")
    public JAXBElement<GetCitizenByIdResponse> createGetCitizenByIdResponse(GetCitizenByIdResponse value) {
        return new JAXBElement<>(_GetCitizenByIdResponse_QNAME, GetCitizenByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizenFines }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCitizenFines }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getCitizenFines")
    public JAXBElement<GetCitizenFines> createGetCitizenFines(GetCitizenFines value) {
        return new JAXBElement<>(_GetCitizenFines_QNAME, GetCitizenFines.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizenFinesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCitizenFinesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getCitizenFinesResponse")
    public JAXBElement<GetCitizenFinesResponse> createGetCitizenFinesResponse(GetCitizenFinesResponse value) {
        return new JAXBElement<>(_GetCitizenFinesResponse_QNAME, GetCitizenFinesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizens }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCitizens }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getCitizens")
    public JAXBElement<GetCitizens> createGetCitizens(GetCitizens value) {
        return new JAXBElement<>(_GetCitizens_QNAME, GetCitizens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizensResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCitizensResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getCitizensResponse")
    public JAXBElement<GetCitizensResponse> createGetCitizensResponse(GetCitizensResponse value) {
        return new JAXBElement<>(_GetCitizensResponse_QNAME, GetCitizensResponse.class, null, value);
    }

}
