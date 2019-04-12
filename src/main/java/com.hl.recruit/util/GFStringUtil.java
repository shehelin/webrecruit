/**
 * Copyright @ 2010-2015 Hex company All rights reserved
 * 系统名称：DCP
 * 模块名称：
 * @version版本信息：V1.0
 * @author:jiewang
 * 
 */
package com.hl.recruit.util;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GFStringUtil {
	/**
	 * 获取trim的字符，当空的时候
	 * 
	 * @param dataVal
	 * @return String
	 * */
	public static String getTrimStringValue(String dataVal) {
		return getTrimStringValue(dataVal, "");
	}

	/**
	 * 获取trim的字符，当null时候，返回默认值
	 * 
	 * @param dataVal
	 * @param defaultVal
	 * @return String
	 * */
	public static String getTrimStringValue(String dataVal, String defaultVal) {
		// 是否为空
		if (dataVal == null) {
			dataVal = defaultVal;
		} else {
			dataVal = dataVal.trim();
		}
		return dataVal;
	}

	/**
	 * 创建同一个之的数组集合
	 * 
	 * @param val
	 * @param length
	 * @return String[]
	 * */
	public static String[] getArray(String val, int length) {
		String[] retArray = new String[length];
		// 循环
		for (int i = 0; i < length; i++) {
			retArray[i] = val;
		}
		return retArray;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return boolean
	 * */
	public static boolean isEmpty(String str) {
		// 是否为空
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符是否在数组内
	 * 
	 * @param datas
	 * @param str
	 * @param ignor
	 *            是否忽略大小写
	 * @return boolean
	 * */
	public static boolean isExist(String[] datas, String str, boolean ignor) {
		// 是否为空
		if (str == null || datas == null) {
			return false;
		}

		for (String val : datas) {
			// 是否忽略大小写
			if (ignor) {
				// 是否相等
				if (val.equalsIgnoreCase(str)) {
					return true;
				}
			} else {
				// 是否相等
				if (val.equals(str)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 字符编码转换
	 * 
	 * @param str
	 * @param srcCharSet
	 * @param toCharSet
	 * @return
	 */
	public static String charsetConvert(String str, String srcCharSet,
			String toCharSet) {
		// 判断是否为空
		if (GFStringUtil.isEmpty(str)) {
			return str;
		}
		try {
			return new String(str.getBytes(srcCharSet), toCharSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 获取文件所在的行号
	 * 
	 * @param contents
	 * @return
	 */
	public static int getLines(String contents) {
		// System.out.println("content=" +contents+ "====end");
		// System.out.println(RegexUtil.countMatchers(contents, "\r\n|\n"));
		return RegexUtil.countMatchers(contents, "\r\n|\n");
		// String[] arrs = contents.split("\r\n|\n");
		//
		// if(arrs.length==1){
		// return 0;
		// }
		// return arrs.length ;
		// if(arrs[arrs.length-1].equals("")){
		// return arrs.length-1;
		// }else{
		// return arrs.length ;
		// }
	}

	/**
	 * 获得变量的重复值，并用间隔符连接
	 * 
	 * @param str
	 * @param size
	 * @param sep
	 * @return
	 */
	public static String getMultiValue(String str, int size, String sep) {
		return ArrayUtil.concat(getArray(str, size), sep);
	}

	/**
	 * 获取空行记录
	 * 
	 * @param needLineFeed
	 * @return
	 */
	public static String getMultiLines(int line) {
		return GFStringUtil.getMultiValue(Util.getLineSeparator(), line, "");
	}

	/**
	 * 是否大写
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUpper(String str) {
		if (!GFStringUtil.isEmpty(str)) {
			return str.equals(str.toUpperCase());
		}
		return false;
	}

	/**
	 * 是否小写
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isLower(String str) {
		if (!GFStringUtil.isEmpty(str)) {
			return str.equals(str.toLowerCase());
		}
		return false;
	}

	/**
	 * 判断字符串是否为数字
	 * 
	 * @param str
	 * @returnv true:成功 false:失败
	 */
	public static boolean isNumeric(String str) {
		if (GFStringUtil.isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		// 是否为空
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param content
	 * @return
	 */
	public static String[] splitToLines(String content) {
		if (isEmpty(content)) {
			return null;
		}
		return content.split("\r\n|\n", -1);
	}
    public static String toUpper(String str){
        if(GFStringUtil.isEmpty(str)){
            return str;
        }
        return str.toUpperCase() ;
    }
	/**
	 * 判断某一行的值是某个值
	 * 
	 * @param lineNum
	 * @param val
	 * @param acceptSpaceLine
	 * @param ignoreCase
	 * @return
	 */
	public static boolean checkLineValue(String content, int lineNum,
			String val, boolean acceptSpaceLine, boolean ignoreCase) {
		int currentLine = lineNum;
		String[] lines = GFStringUtil.splitToLines(content);

		if (ArrayUtil.isEmpty(lines)) {
			return false;
		}
		while (true) {
			if (currentLine < lines.length) {
				if (GFStringUtil.isEmpty(lines[currentLine])) {
					if (acceptSpaceLine) {
						currentLine++;
						continue;
					} else {
						return false;
					}
				}
				// 判断大小写
				if (ignoreCase) {
					return lines[lineNum].trim().equalsIgnoreCase(val);
				} else {
					return lines[lineNum].trim().equals(val);
				}

			}
			return false;

		}
	}

	/**
	 * 判断某一行的值
	 * 
	 * @param lineNum
	 * @param val
	 * @param acceptSpaceLine
	 * @param ignoreCase
	 * @return
	 */
	public static String getLineValue(String content, int lineNum,
			boolean acceptSpaceLine) {
		int currentLine = lineNum;
		String[] lines = GFStringUtil.splitToLines(content);

		if (ArrayUtil.isEmpty(lines)) {
			return null;
		}
		while (true) {
			if (currentLine < lines.length) {
				if (GFStringUtil.isEmpty(lines[currentLine])) {
					if (acceptSpaceLine) {
						currentLine++;
						continue;
					} else {
						return lines[currentLine];
					}
				}

				return lines[currentLine];

			}
			return null;

		}
	}

	/**
	 * 计算字符串出现的次数
	 * 
	 * @param str
	 * @param subStr
	 * @return
	 */
	public static int countMatches(String str, String subStr) {
		return StringUtils.countMatches(str, subStr);
	}

	public static void main(String[] args) {
		// String[] arrs =
		// getMatchers("select * from a limit 10"," (?i)LIMIT\\s+\\d+\\s*$");
		// ArrayUtil.print(arrs) ;
		// 是否select
		// String[] arrs =
		// getMatchers("select * from a limit 10","^\\s*(?i)SELECT\\s+(.)+FROM ");
		// ArrayUtil.print(arrs) ;

		// boolean isContain =
		// containRegex("create table ","^\\s*(?i)CREATE\\s+TABLE\\s+");
		// System.out.println(isContain);

	}
}
