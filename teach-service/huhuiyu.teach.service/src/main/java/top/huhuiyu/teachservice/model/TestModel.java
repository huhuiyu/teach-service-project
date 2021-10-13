package top.huhuiyu.teachservice.model;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiParam;
import top.huhuiyu.teachservice.base.MyBaseModel;

/**
 * 测试model数据
 * 
 * @author 胡辉煜
 */
public class TestModel extends MyBaseModel {

  private static final long serialVersionUID = -6785013186661414112L;
  @ApiParam(hidden = true)
  private Date dateOne;
  @ApiParam(hidden = true)
  private Date dateTwo;
  @ApiParam(hidden = true)
  private BigDecimal decValue;
  @ApiParam(hidden = true)
  private Double dblValue;
  @ApiParam(hidden = true)
  private Integer intValue;
  @ApiParam(hidden = true)
  private String strValue;
  @ApiParam(hidden = true)
  private String mail;
  @ApiParam(hidden = true)
  private String mailTitle;
  @ApiParam(hidden = true)
  private String mailContent;

  public TestModel() {
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getMailTitle() {
    return mailTitle;
  }

  public void setMailTitle(String mailTitle) {
    this.mailTitle = mailTitle;
  }

  public String getMailContent() {
    return mailContent;
  }

  public void setMailContent(String mailContent) {
    this.mailContent = mailContent;
  }

  public Date getDateOne() {
    return dateOne;
  }

  public void setDateOne(Date dateOne) {
    this.dateOne = dateOne;
  }

  public Date getDateTwo() {
    return dateTwo;
  }

  public void setDateTwo(Date dateTwo) {
    this.dateTwo = dateTwo;
  }

  public BigDecimal getDecValue() {
    return decValue;
  }

  public void setDecValue(BigDecimal decValue) {
    this.decValue = decValue;
  }

  public Double getDblValue() {
    return dblValue;
  }

  public void setDblValue(Double dblValue) {
    this.dblValue = dblValue;
  }

  public Integer getIntValue() {
    return intValue;
  }

  public void setIntValue(Integer intValue) {
    this.intValue = intValue;
  }

  public String getStrValue() {
    return strValue;
  }

  public void setStrValue(String strValue) {
    this.strValue = strValue;
  }

}