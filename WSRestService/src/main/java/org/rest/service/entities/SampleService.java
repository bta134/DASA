package org.rest.service.entities;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    
@Path("/sampleservice")
public class SampleService {
    private static Map<String, Album> albums = new HashMap<String, Album>();
    private static final Logger LOG = LoggerFactory.getLogger(SampleService.class);
    static {
        Album album1 = new Album();
        album1.setAlbumId("1");
        album1.setTitle("Elephunk");
        album1.setGenre("HipHop");
        Calendar cal = Calendar.getInstance();
        cal.set(2003, 06, 24);
        album1.setDate(cal.getTime());
        albums.put(album1.getAlbumId(), album1);
        
        Album album2 = new Album();
        album2.setAlbumId("2");
        album2.setTitle("Demon Days");
        album2.setGenre("HipHop");
        cal.set(2005, 12, 6);
        album2.setDate(cal.getTime());
        albums.put(album2.getAlbumId(), album2);
      }
     
     @GET
     @Path("/albums")
     @Produces("application/xml")
     public List<Album> listAlbums(){
        LOG.info("getAlbums");
        return new ArrayList<Album>(albums.values()); 
     }
     
     public Album getAlbum(String albumId){}
     public List<Album> listAlbumsJSON(){}
     public Album getAlbumJSON(String albumId){}

 }
     
