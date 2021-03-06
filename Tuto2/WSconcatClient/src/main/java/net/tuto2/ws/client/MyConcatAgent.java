
package net.tuto2.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MyConcatAgent", targetNamespace = "http://concat.service.ws.tuto2.net/", wsdlLocation = "http://localhost:8080/WSConcatService/services/concat?wsdl")
public class MyConcatAgent
    extends Service
{

    private final static URL MYCONCATAGENT_WSDL_LOCATION;
    private final static WebServiceException MYCONCATAGENT_EXCEPTION;
    private final static QName MYCONCATAGENT_QNAME = new QName("http://concat.service.ws.tuto2.net/", "MyConcatAgent");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WSConcatService/services/concat?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MYCONCATAGENT_WSDL_LOCATION = url;
        MYCONCATAGENT_EXCEPTION = e;
    }

    public MyConcatAgent() {
        super(__getWsdlLocation(), MYCONCATAGENT_QNAME);
    }

    public MyConcatAgent(WebServiceFeature... features) {
        super(__getWsdlLocation(), MYCONCATAGENT_QNAME, features);
    }

    public MyConcatAgent(URL wsdlLocation) {
        super(wsdlLocation, MYCONCATAGENT_QNAME);
    }

    public MyConcatAgent(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MYCONCATAGENT_QNAME, features);
    }

    public MyConcatAgent(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MyConcatAgent(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSConcat
     */
    @WebEndpoint(name = "WSConcatImplPort")
    public WSConcat getWSConcatImplPort() {
        return super.getPort(new QName("http://concat.service.ws.tuto2.net/", "WSConcatImplPort"), WSConcat.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSConcat
     */
    @WebEndpoint(name = "WSConcatImplPort")
    public WSConcat getWSConcatImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://concat.service.ws.tuto2.net/", "WSConcatImplPort"), WSConcat.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MYCONCATAGENT_EXCEPTION!= null) {
            throw MYCONCATAGENT_EXCEPTION;
        }
        return MYCONCATAGENT_WSDL_LOCATION;
    }

}
