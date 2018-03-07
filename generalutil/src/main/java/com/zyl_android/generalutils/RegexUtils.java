package com.zyl_android.generalutils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bibinet on 2018-1-15.
 */

public class RegexUtils {
    public static List<String> regexsList=new ArrayList<>();
    //在字符串中分别获取数字
    public static void getNumber(String msg){
        String regex = "\\d*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(msg);
        while (m.find()) {
            if (!"".equals(m.group())){
                regexsList.add(m.group());
            }
        }
    }
    //将所有数字取出来放到一起
    public static int getNumberTogether(String string){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(string);
        String togetherNumber = m.replaceAll("").trim();
        if (!TextUtils.isEmpty(togetherNumber)) {
            return Integer.parseInt(togetherNumber);
        }
        return 0;
    }

    //截取字符串中的数字，包含小数
    public static double getNumberHasPoint(String string){
        // 需要取整数和小数的字符串
        // 控制正则表达式的匹配行为的参数(小数)
        Pattern p = Pattern.compile("(\\d+\\.\\d+)");
        //Matcher类的构造方法也是私有的,不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.
        Matcher m = p.matcher(string);
        //m.find用来判断该字符串中是否含有与"(\\d+\\.\\d+)"相匹配的子串
        if (m.find()) {
            //如果有相匹配的,则判断是否为null操作
            //group()中的参数：0表示匹配整个正则，1表示匹配第一个括号的正则,2表示匹配第二个正则,在这只有一个括号,即1和0是一样的
            string = m.group(1) == null ? "" : m.group(1);
        } else {
            //如果匹配不到小数，就进行整数匹配
            p = Pattern.compile("(\\d+)");
            m = p.matcher(string);
            if (m.find()) {
                //如果有整数相匹配
                string = m.group(1) == null ? "" : m.group(1);
            } else {
                //如果没有小数和整数相匹配,即字符串中没有整数和小数，就设为空
                string = "";
            }
        }
        return Double.parseDouble(string);
    }
}
