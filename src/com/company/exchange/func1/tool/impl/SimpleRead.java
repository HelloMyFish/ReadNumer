package com.company.exchange.func1.tool.impl;

import com.company.exchange.func2.AbstractReadNumber;
import com.company.exchange.func1.tool.ReadNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Package
 * @Description:
 * @Author gyf
 * @Date 2020/6/6 16:36
 */
public class SimpleRead implements ReadNumber {
    private static Map<Character, String> numberMap;
    private static Map<Integer, String> unitMap;

    public SimpleRead() {
        if(numberMap==null){
            synchronized (AbstractReadNumber.class){
                if (numberMap==null){
                    initNumberMap();
                }
            }
        }
        if(unitMap==null){
            synchronized (AbstractReadNumber.class){
                if (unitMap==null){
                    initUnitMap();
                }
            }
        }
    }

    private void initUnitMap() {
        unitMap = new HashMap<>(16);
        unitMap.put(0, "");
        unitMap.put(1, "十");
        unitMap.put(2, "百");
        unitMap.put(3, "千");
        unitMap.put(4, "万");
        unitMap.put(8, "亿");
    }


    private void initNumberMap() {
        System.out.println("初始化=====");
        numberMap = new HashMap<>(16);
        numberMap.put('0', "零");
        numberMap.put('1', "一");
        numberMap.put('2', "二");
        numberMap.put('3', "三");
        numberMap.put('4', "四");
        numberMap.put('5', "五");
        numberMap.put('6', "六");
        numberMap.put('7', "七");
        numberMap.put('8', "八");
        numberMap.put('9', "九");
    }


    @Override
    public String readNumber(Character key) {
        return numberMap.get(key);
    }

    @Override
    public String readUnit(Integer index) {
        return unitMap.get(index);
    }
}
