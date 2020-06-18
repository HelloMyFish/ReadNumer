package com.company.exchange.func1.util;

import com.company.exchange.func1.tool.ReadNumber;
import com.company.exchange.func1.tool.impl.SimpleRead;
import org.apache.commons.lang.math.NumberUtils;

/**
 * @Title:
 * @Package
 * @Description:
 * @Author gyf
 * @Date 2020/6/6 16:39
 */
public class ReadUtil {
    private final ReadNumber read;
    /**
     * @description TEN_READ_MODE 默认是true
     * 为true时  10 读作 十
     * 为false时 10 读作 一十
     *
     */
    private final Boolean TEN_READ_MODE;

    public ReadUtil(ReadNumber readNum, Boolean readModel) {
        this.read = readNum;
        TEN_READ_MODE = readModel;
    }

    public ReadUtil(ReadNumber readNum) {
        this.read = readNum;
        TEN_READ_MODE = Boolean.FALSE;
    }
    public ReadUtil() {
        this.read = new SimpleRead();
        TEN_READ_MODE = Boolean.FALSE;
    }


    public <T> String read(T t){
        if(t==null){
            throw new RuntimeException("参数为空!");
        }
        String input = String.valueOf(t).trim().replaceAll("^0+","");
        if(!NumberUtils.isDigits(input)){
            throw new RuntimeException("非法数字，只支持正整数的转化!:"+input);
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = input.toCharArray();
        if(chars.length>9){
            throw new RuntimeException("最大支持亿级的数字转化");
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c=='0'){
                if(chars[i-1]!='0'){
                    stringBuilder.append(read.readNumber(c));
                }
            }else{
                stringBuilder.append(read.readNumber(c));
                int unitIndex = chars.length-1-i;
                int unit = unitIndex & (4-1);
                stringBuilder.append(read.readUnit(unit));
                if(unitIndex==8){
                    stringBuilder.append(read.readUnit(8));
                }else if(unitIndex==4){
                    stringBuilder.append(read.readUnit(4));
                }
            }
        }
        String s = stringBuilder.toString();
        int start = 0;
        int end = s.length();
        char fistChar = chars[0];
        char lastChar = chars[input.length()-1];
        if(TEN_READ_MODE && fistChar=='1' && chars.length==2){
            start = 1;
        }
        if(lastChar=='0'){
            end = s.length()-1;
        }
        return s.substring(start,end);
    }
}
