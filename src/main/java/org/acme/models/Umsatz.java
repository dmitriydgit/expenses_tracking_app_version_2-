package org.acme.models;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
@Cacheable
public class Umsatz extends PanacheEntityBase {

//  @Id
//  @GeneratedValue
//  private Long id;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int  id;


  public String anbieter;
  public String abbuchungskonto;
  public String buchungszeit;
  public String beitrag;
  public String typ;
  public String kategorie;
  public String umsatzart;
  public String kommentar;

  public String getAnbieter() {
    return anbieter;
  }

  public void setAnbieter(String anbieter) {
    this.anbieter = anbieter;
  }

  public String getAbbuchungskonto() {
    return abbuchungskonto;
  }

  public void setAbbuchungskonto(String abbuchungskonto) {
    this.abbuchungskonto = abbuchungskonto;
  }

  public String getBuchungszeit() {
    return buchungszeit;
  }

  public void setBuchungszeit(String buchungszeit) {
    this.buchungszeit = buchungszeit;
  }

  public String getBeitrag() {
    return beitrag;
  }

  public void setBeitrag(String beitrag) {
    this.beitrag = beitrag;
  }

  public String getTyp() {
    return typ;
  }

  public void setTyp(String typ) {
    this.typ = typ;
  }

  public String getKategorie() {
    return kategorie;
  }

  public void setKategorie(String kategorie) {
    this.kategorie = kategorie;
  }

  public String getUmsatzart() {
    return umsatzart;
  }

  public void setUmsatzart(String umsatzart) {
    this.umsatzart = umsatzart;
  }

  public String getKommentar() {
    return kommentar;
  }

  public void setKommentar(String kommentar) {
    this.kommentar = kommentar;
  }



//  @Id
//  public Long getId() {
//    return id;
//  }


  public Uni<Umsatz> findByName(String anbieter){
    return find("anbieter", anbieter).firstResult();
  }

}
