package net.serialisation.data;

import javax.xml.bind.*;

import java.io.File;
import java.util.GregorianCalendar;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       
        CatalogData c = new CatalogData();
       
         
        try {
  
          File file = new File("C:\\Users\\Admin\\Desktop\\Code\\DASA\\jaxb2\\src\\main\\resources\\schema\\books.xml");
          JAXBContext jaxbContext = JAXBContext.newInstance(CatalogData.class);
          Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
          c = (CatalogData) unmarshaller.unmarshal(file);
	      System.out.println(c);
          
            } catch (JAXBException e) {
          e.printStackTrace();
            }
    }
}
