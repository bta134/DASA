
package net.tuto2.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSConcat", targetNamespace = "http://david.bromberg.fr/service/concat")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WSConcat {


    /**
     * 
     * @param str1
     * @param str2
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://david.bromberg.fr/service/concat/WSConcat/concatRequest", output = "http://david.bromberg.fr/service/concat/WSConcat/concatResponse")
    public String concat(
        @WebParam(name = "str1", partName = "str1")
        String str1,
        @WebParam(name = "str2", partName = "str2")
        String str2);

}
