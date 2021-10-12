package top.huhuiyu.teachservice.test;

import java.util.Scanner;

import top.huhuiyu.api.fileutil.Md5;
import top.huhuiyu.teachservice.utils.SystemConstants;

/**
 * 临时测试类
 * 
 * @author 胡辉煜
 */
public class Temp {
  public static void one() throws Exception {
    Scanner scanner = new Scanner(Temp.class.getResourceAsStream("/temp.txt"));
    while (scanner.hasNextLine()) {
      System.out.println(scanner.nextLine());
    }
    scanner.close();
  }

  public static void two() throws Exception {
    String salt = "JX1XRO";
    String pwd = "admin-pwd";
    System.out.println(String.format("%s,%s,%s,%s", salt, pwd, Md5.md5(pwd), Md5.saltMd5(Md5.md5(pwd), salt)));
  }

  public static void three() throws Exception {
    String salt = "C3CJXR";
    String pwd = "user-pwd";
    System.out.println(String.format("%s,%s,%s,%s", salt, pwd, Md5.md5(pwd), Md5.saltMd5(Md5.md5(pwd), salt)));
  }

  public static void four() throws Exception {
    System.out.println(SystemConstants.isMd5("d48dc3be25a60dafc4db503fbc36d397"));
    System.out.println(SystemConstants.isMd5("d-8dc3be25a60dafc4db503fbc36d397"));
    System.out.println(SystemConstants.isMd5("48dc3be25a60dafc4db503fbc36d397"));
    System.out.println(SystemConstants.isPhone("15080604020"));
    System.out.println(SystemConstants.isPhone("11080602040"));
    System.out.println(SystemConstants.isPhone("13312345678"));
  }

  public static void main(String[] args) throws Exception {
    // System.out.println(Md5.makeSalt());
    // Temp.one();
    // Temp.two();
    // Temp.three();
    Temp.four();
  }
}
