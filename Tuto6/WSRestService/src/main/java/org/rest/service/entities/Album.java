package org.rest.service.entities;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Temporal;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;


@XmlRootElement(name = "album")
@Entity
@Table(name="album")
public class Album {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int albumId;
  @Column(name="TITLE")
  private String title;
  @Temporal(TemporalType.DATE)
  private Date rdate;
  @Column(name="GENRE")
  private String genre;
  
  @XmlElement
  public int getAlbumId() {return albumId;}
  public void setAlbumId(int albumId) {this.albumId = albumId;}
  
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
