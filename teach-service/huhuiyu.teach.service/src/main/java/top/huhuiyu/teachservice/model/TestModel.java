package top.huhuiyu.teachservice.model;

import java.math.BigDecimal;
import java.util.Date;

import top.huhuiyu.teachservice.base.MyBaseModel;

/**
 * 测试model数据
 * 
 * @author 胡辉煜
 */
public class TestModel extends MyBaseModel {

  private static final long serialVersionUID = -6785013186661414112L;

  private Date dateOne;
  private Date dateTwo;
  private BigDecimal decValue;
  private Double dblValue;
  private Integer intValue;
  private String strValue;

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