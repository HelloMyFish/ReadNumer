package com.company.exchange.func2;


import org.apache.commons.lang.math.NumberUtils;


/**
 * @Title:
 * @Package
 * @Description:
 * @Author gyf
 * @Date 2020/6/6 10:50
 */
public class ReadNumberByChinese extends AbstractReadNumber {
    /**
     * @description TEN_READ_MODE 默认是true
     * 为true时  10 读作 十
     * 为false时 10 读作 一十
     *
     */
    private static Boolean TEN_READ_MODE;

    public ReadNumberByChinese(Integer type,Boolean openReadModel) {
        super(type);
        TEN_READ_MODE = openReadModel;
    }

    public ReadNumberByChinese(){
        super(1);
        TEN_READ_MODE = Boolean.TRUE;
    }

    @Override
    public <T> String read(T t) {
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
                    stringBuilder.append(readNum(c));
                }
            }else{
                stringBuilder.append(readNum(c));
                int unitIndex = chars.length-1-i;
                int unit = unitIndex & (4-1);
                stringBuilder.append(readUnit(unit));
                if(unitIndex==8){
                    stringBuilder.append(readUnit(8));
                }else if(unitIndex==4){
                    stringBuilder.append(readUnit(4));
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
