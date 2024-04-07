package com.kitady.gke.quarkus.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 * ITEM Entity
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "ITEM")
public class Item implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  /** PK */
  /** UUID */
  @Id
  @Column(name = "UUID")
  private String uuid;

  /** NAME */
  @Column(name = "NAME")
  private String name;

  /** NAMEJP */
  @Column(name = "NAMEJP")
  private String namejp;

  /** BREWERY */
  @Column(name = "BREWERY")
  private String brewery;

  /** TYPE */
  @Column(name = "TYPE")
  private String type;

  /** DIV */
  @Column(name = "DIV")
  private String div;

  /** ITEMNO */
  @Column(name = "ITEMNO")
  private Long itemno;

  /** PRICE */
  @Column(name = "PRICE")
  private BigDecimal price;

  /** EXPLANATION */
  @Column(name = "EXPLANATION")
  private String explanation;

  /** REGDATE */
  @Column(name = "REGDATE")
  private Date regdate;

  /** TIMEZONE */
  @Column(name = "TIMEZONE")
  private String timezone;

  /** TIMESTMP */
  @Column(name = "TIMESTMP")
  private Timestamp timestmp;

  /** VERSION */
  @Version
  @Column(name = "VERSION")
  private Timestamp version;

  /**
   * Contractor
   */
  public Item() {
    super();
  }

  /**
   * UUID getter
   * 
   * @return UUID
   */
  public String getUuid() {
    return this.uuid;
  }

  /**
   * UUID setter
   * 
   * @param uuid UUID
   * 
   */
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /**
   * NAME getter
   * 
   * @return NAME
   */
  public String getName() {
    return this.name;
  }

  /**
   * NAME setter
   * 
   * @param name NAME
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * NAMEJP getter
   * 
   * @return NAMEJP
   */
  public String getNamejp() {
    return this.namejp;
  }

  /**
   * NAMEJP setter
   * 
   * @param namejp NAMEJP
   */
  public void setNamejp(String namejp) {
    this.namejp = namejp;
  }

  /**
   * BREWERY getter
   * 
   * @return BREWERY
   */
  public String getBrewery() {
    return this.brewery;
  }

  /**
   * BREWERY setter
   * 
   * @param namejp BREWERY
   */
  public void setBrewery(String brewery) {
    this.brewery = brewery;
  }

  /**
   * TYPE getter
   * 
   * @return TYPE
   */
  public String getType() {
    return this.type;
  }

  /**
   * TYPE setter
   * 
   * @param type TYPE
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * DIV getter
   * 
   * @return DIV
   */
  public String getDiv() {
    return this.div;
  }

  /**
   * DIV setter
   * 
   * @param div DIV
   */
  public void setDiv(String div) {
    this.div = div;
  }

  /**
   * ITEMNO getter
   * 
   * @return ITEMNO
   */
  public Long getItemno() {
    return this.itemno;
  }

  /**
   * ITEMNO setter
   * 
   * @param itemno ITEMNO
   */
  public void setItemno(Long itemno) {
    this.itemno = itemno;
  }

  /**
   * PRICE getter
   * 
   * @return PRICE
   */
  public BigDecimal getPrice() {
    return this.price;
  }

  /**
   * PRICE setter
   * 
   * @param price PRICE
   */
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  /**
   * EXPLANATION getter
   * 
   * @return EXPLANATION
   */
  public String getExplanation() {
    return this.explanation;
  }

  /**
   * EXPLANATION setter
   * 
   * @param explanation EXPLANATION
   */
  public void setExplanation(String explanation) {
    this.explanation = explanation;
  }

  /**
   * REGDATE getter
   * 
   * @return REGDATE
   */
  public Date getRegdate() {
    return this.regdate;
  }

  /**
   * ATE setter
   * 
   * @param regdate REGDATE
   */
  public void setRegdate(Date regdate) {
    this.regdate = regdate;
  }

  /**
   * TIMEZONE getter
   * 
   * @return TIMEZONE
   */
  public String getTimezone() {
    return this.timezone;
  }

  /**
   * TIMEZONE setter
   * 
   * @param timezone TIMEZONE
   */
  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  /**
   * TIMESTMP getter
   * 
   * @return TIMESTMP
   */
  public Timestamp getTimestmp() {
    return this.timestmp;
  }

  /**
   * TIMESTMP setter
   * 
   * @param timestmp TIMESTMP
   */
  public void setTimestmp(Timestamp timestmp) {
    this.timestmp = timestmp;
  }

  /**
   * VERSION getter
   * 
   * @return VERSION
   */
  public Timestamp getVersion() {
    return this.version;
  }

  /**
   * VERSION setter
   * 
   * @param version VERSION
   */
  public void setVersion(Timestamp version) {
    this.version = version;
  }

}
