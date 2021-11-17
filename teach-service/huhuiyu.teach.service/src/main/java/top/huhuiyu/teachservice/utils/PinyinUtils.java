package top.huhuiyu.teachservice.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

/**
 * 汉字转换拼音工具
 * 
 * @author 胡辉煜
 *
 */
public class PinyinUtils {

  private static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

  static {
    format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
    format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    format.setVCharType(HanyuPinyinVCharType.WITH_V);
  }

  /**
   * 获取单个字符的汉字拼音
   * 
   * @param c 要获取拼音的字符
   * 
   * @return 汉字拼音(无法转换就是null)
   */
  public static String getPinYin(char c) {
    try {
      String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
      // 如果c不是汉字，toHanyuPinyinStringArray会返回null
      if (pinyin == null) {
        return null;
      }
      // 只取一个发音，如果是多音字，仅取第一个发音
      return pinyin[0];
    } catch (Exception ex) {
      return null;
    }
  }

  /**
   * 获取单个字符的汉字拼音（多音字版本）
   * 
   * @param c 要获取拼音的字符
   * 
   * @return 汉字拼音(无法转换就是null)
   */
  public static String getPinYins(char c) {
    try {
      String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
      // 如果c不是汉字，toHanyuPinyinStringArray会返回null
      if (pinyin == null) {
        return null;
      }
      StringBuilder sb = new StringBuilder();
      for (String py : pinyin) {
        sb.append(py).append(",");
      }
      sb.deleteCharAt(sb.length() - 1);
      return sb.toString();
    } catch (Exception ex) {
      return null;
    }
  }

  /**
   * 获取字符串对应的汉字拼音（不获取多音字信息）
   * 
   * @param str 获取汉字拼音的字符串
   * @param all 是否获取多音字信息
   * 
   * @return 字符串对应的汉字拼音
   */
  public static String getPinYin(String str) {
    return getPinYin(str, false);
  }

  /**
   * 获取字符串对应的汉字拼音
   * 
   * @param str 获取汉字拼音的字符串
   * @param all 是否获取多音字信息
   * 
   * @return 字符串对应的汉字拼音
   */
  public static String getPinYin(String str, boolean all) {
    if (str == null || str.trim().equals("")) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    String tempPinyin = null;
    for (int i = 0; i < str.length(); ++i) {
      char c = str.charAt(i);
      tempPinyin = all ? getPinYins(c) : getPinYin(c);
      if (tempPinyin == null) {
        // 如果str.charAt(i)非汉字，则保持原样
        sb.append(c);
      } else {
        sb.append(tempPinyin);
      }
    }
    return sb.toString();
  }

}
