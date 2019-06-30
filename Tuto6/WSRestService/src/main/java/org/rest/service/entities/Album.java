package org.rest.service.entities;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "album")
public class Album {
  private String albumId;
  private String title;
  private Date rdate;
  private String genre;
  
  @XmlElement
  public String getAlbumId() {return albumId;}
  public void setAlbumId(String albumId) {this.albumId = albumId;}
  
  @XmlElement
  public String getGenre() {return genre;}
  public void setGenre(String genre) {this.genre = genre;}
  
  @XmlElement
  public String getTitle() {return title;}
  public void setTitle(String title) {this.title = title;}
  
  @XmlElement(name = "date",type=Date.class)
  public Date getDate() {return rdate;}
  public void setDate(Date rdate) {this.rdate = rdate;}
  }
