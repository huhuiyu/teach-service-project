package top.huhuiyu.teachservice.entity;

import top.huhuiyu.api.spring.base.BaseEntity;

/**
 * 聊天信息
 * 
 * @author 胡辉煜
 *
 */
public class ChatInfo extends BaseEntity {
  private static final long serialVersionUID = -9021743231503483831L;

  private String name;
  private String info;

  public ChatInfo() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

}
