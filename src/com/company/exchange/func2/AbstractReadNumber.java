package com.company.exchange.func2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Package
 * @Description: 读出数字
 * @Author gyf
 * @Date 2020/6/6 10:50
 */
public abstract class AbstractReadNumber {
    private static Map<Character, String> numberMap;
    private static Map<Integer, String> unitMap;
    private static final Integer simple = 1;
    private static final Integer complex = 2;
    public static String readNum(Character key){
        return numberMap.get(key);
    }

    public static String readUnit(Integer index){
        return unitMap.get(index);
    }

    public AbstractReadNumber(Integer type) {
        if(numberMap==null){
            synchronized (AbstractReadNumber.class){
                if (numberMap==null){
                    initNumberMap(type);
                }
            }
        }
        if(unitMap==null){
            synchronized (AbstractReadNumber.class){
                if (unitMap==null){
                    initUnitMap(type);
                }
            }
        }
    }

    private void initUnitMap(Integer type){
        unitMap = new HashMap<>(16);
        if(type.intValue()==simple.intValue()){
            unitMap.put(0,"");
            unitMap.put(1,"十");
            unitMap.put(2,"百");
            unitMap.put(3,"千");
            unitMap.put(4,"万");
            unitMap.put(8,"亿");
        }else if (type.intValue()==complex.intValue()){
            unitMap.put(0,"");
            unitMap.put(1,"拾");
            unitMap.put(2,"佰");
            unitMap.put(3,"仟");
            unitMap.put(4,"万");
            unitMap.put(8,"亿");
        }
    }


    private static void initNumberMap(Integer type) {
        numberMap = new HashMap<>(16);
        if(type.intValue()==simple.intValue()){
            numberMap.put('0',"零");
            numberMap.put('1',"一");
            numberMap.put('2',"二");
            numberMap.put('3',"三");
            numberMap.put('4',"四");
            numberMap.put('5',"五");
            numberMap.put('6',"六");
            numberMap.put('7',"七");
            numberMap.put('8',"八");
            numberMap.put('9',"九");
        }else if (type.intValue()==complex.intValue()){
            numberMap.put('0',"零");
            numberMap.put('1',"壹");
            numberMap.put('2',"贰");
            numberMap.put('3',"叁");
            numberMap.put('4',"肆");
            numberMap.put('5',"伍");
            numberMap.put('6',"陆");
            numberMap.put('7',"柒");
            numberMap.put('8',"捌");
            numberMap.put('9',"玖");
        }
    }
    public abstract <T> String read(T t);
}
