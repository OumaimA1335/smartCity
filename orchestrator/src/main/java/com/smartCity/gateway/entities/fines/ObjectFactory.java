
package com.smartCity.gateway.entities.fines;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.smartCity.gateway.entities.fines package. 
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

    private static final QName _AddFine_QNAME = new QName("http://services.finesService.smartCity.com/", "addFine");
    private static final QName _AddFineResponse_QNAME = new QName("http://services.finesService.smartCity.com/", "addFineResponse");
    private static final QName _Fine_QNAME = new QName("http://services.finesService.smartCity.com/", "fine");
    private static final QName _GetFine_QNAME = new QName("http://services.finesService.smartCity.com/", "getFine");
    private static final QName _GetFineByIdFineAndIdCitizen_QNAME = new QName("http://services.finesService.smartCity.com/", "getFineByIdFineAndIdCitizen");
    private static final QName _GetFineByIdFineAndIdCitizenResponse_QNAME = new QName("http://services.finesService.smartCity.com/", "getFineByIdFineAndIdCitizenResponse");
    private static final QName _GetFineResponse_QNAME = new QName("http://services.finesService.smartCity.com/", "getFineResponse");
    private static final QName _GetFines_QNAME = new QName("http://services.finesService.smartCity.com/", "getFines");
    private static final QName _GetFinesResponse_QNAME = new QName("http://services.finesService.smartCity.com/", "getFinesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.smartCity.gateway.entities.fines
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddFine }
     * 
     * @return
     *     the new instance of {@link AddFine }
     */
    public AddFine createAddFine() {
        return new AddFine();
    }

    /**
     * Create an instance of {@link AddFineResponse }
     * 
     * @return
     *     the new instance of {@link AddFineResponse }
     */
    public AddFineResponse createAddFineResponse() {
        return new AddFineResponse();
    }

    /**
     * Create an instance of {@link Fine }
     * 
     * @return
     *     the new instance of {@link Fine }
     */
    public Fine createFine() {
        return new Fine();
    }

    /**
     * Create an instance of {@link GetFine }
     * 
     * @return
     *     the new instance of {@link GetFine }
     */
    public GetFine createGetFine() {
        return new GetFine();
    }

    /**
     * Create an instance of {@link GetFineByIdFineAndIdCitizen }
     * 
     * @return
     *     the new instance of {@link GetFineByIdFineAndIdCitizen }
     */
    public GetFineByIdFineAndIdCitizen createGetFineByIdFineAndIdCitizen() {
        return new GetFineByIdFineAndIdCitizen();
    }

    /**
     * Create an instance of {@link GetFineByIdFineAndIdCitizenResponse }
     * 
     * @return
     *     the new instance of {@link GetFineByIdFineAndIdCitizenResponse }
     */
    public GetFineByIdFineAndIdCitizenResponse createGetFineByIdFineAndIdCitizenResponse() {
        return new GetFineByIdFineAndIdCitizenResponse();
    }

    /**
     * Create an instance of {@link GetFineResponse }
     * 
     * @return
     *     the new instance of {@link GetFineResponse }
     */
    public GetFineResponse createGetFineResponse() {
        return new GetFineResponse();
    }

    /**
     * Create an instance of {@link GetFines }
     * 
     * @return
     *     the new instance of {@link GetFines }
     */
    public GetFines createGetFines() {
        return new GetFines();
    }

    /**
     * Create an instance of {@link GetFinesResponse }
     * 
     * @return
     *     the new instance of {@link GetFinesResponse }
     */
    public GetFinesResponse createGetFinesResponse() {
        return new GetFinesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFine }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFine }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "addFine")
    public JAXBElement<AddFine> createAddFine(AddFine value) {
        return new JAXBElement<>(_AddFine_QNAME, AddFine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFineResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFineResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "addFineResponse")
    public JAXBElement<AddFineResponse> createAddFineResponse(AddFineResponse value) {
        return new JAXBElement<>(_AddFineResponse_QNAME, AddFineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fine }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Fine }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "fine")
    public JAXBElement<Fine> createFine(Fine value) {
        return new JAXBElement<>(_Fine_QNAME, Fine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFine }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFine }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getFine")
    public JAXBElement<GetFine> createGetFine(GetFine value) {
        return new JAXBElement<>(_GetFine_QNAME, GetFine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFineByIdFineAndIdCitizen }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFineByIdFineAndIdCitizen }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getFineByIdFineAndIdCitizen")
    public JAXBElement<GetFineByIdFineAndIdCitizen> createGetFineByIdFineAndIdCitizen(GetFineByIdFineAndIdCitizen value) {
        return new JAXBElement<>(_GetFineByIdFineAndIdCitizen_QNAME, GetFineByIdFineAndIdCitizen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFineByIdFineAndIdCitizenResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFineByIdFineAndIdCitizenResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getFineByIdFineAndIdCitizenResponse")
    public JAXBElement<GetFineByIdFineAndIdCitizenResponse> createGetFineByIdFineAndIdCitizenResponse(GetFineByIdFineAndIdCitizenResponse value) {
        return new JAXBElement<>(_GetFineByIdFineAndIdCitizenResponse_QNAME, GetFineByIdFineAndIdCitizenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFineResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFineResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getFineResponse")
    public JAXBElement<GetFineResponse> createGetFineResponse(GetFineResponse value) {
        return new JAXBElement<>(_GetFineResponse_QNAME, GetFineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFines }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFines }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getFines")
    public JAXBElement<GetFines> createGetFines(GetFines value) {
        return new JAXBElement<>(_GetFines_QNAME, GetFines.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFinesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFinesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.finesService.smartCity.com/", name = "getFinesResponse")
    public JAXBElement<GetFinesResponse> createGetFinesResponse(GetFinesResponse value) {
        return new JAXBElement<>(_GetFinesResponse_QNAME, GetFinesResponse.class, null, value);
    }

}
