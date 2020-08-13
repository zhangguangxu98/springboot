package com.springboot.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static boolean isEmpty(String str){
		if("".equals(str)||str==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isAllEmpty(String[] str){
		for(int i=0;i<str.length;i++){
			if (isNotEmpty(str[i])) {
                return false;
            }
		}
		return true;
	}
	
	//ȥ�����пո�
     public static String replaceAllBlank(String str) {
         String s = "";
         if (str!=null) {
             //Pattern p = Pattern.compile("\\s*|\t|\r|\n");
             Pattern p = Pattern.compile("\r");
             /*\n �س�(\u000a)
             \t ˮƽ�Ʊ��(\u0009)
             \s �ո�(\u0008)
             \r ����(\u000d)*/
             Matcher m = p.matcher(str);
             s = m.replaceAll("");
         }
         return s;
     }
}
