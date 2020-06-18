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
 * @Date 2020/6/6 16:37
 */
public class ComplexRead implements ReadNumber {
    private static Map<Character, String> numberMap;
    private static Map<Integer, String> unitMap;

    public ComplexRead() {
        if (numberMap == null) {
            synchronized (AbstractReadNumber.class) {
                if (numberMap == null) {
                    initNumberMap();
                }
            }
        }
        if (unitMap == null) {
            synchronized (AbstractReadNumber.class) {
                if (unitMap == null) {
                    initUnitMap();
                }
            }
        }
    }

    private void initUnitMap() {
        unitMap = new HashMap<>(16);
        unitMap.put(0, "");
        unitMap.put(1, "拾");
        unitMap.put(2, "佰");
        unitMap.put(3, "仟");
        unitMap.put(4, "万");
        unitMap.put(8, "亿");
    }


    private void initNumberMap() {
        numberMap.put('0', "零");
        numberMap.put('1', "壹");
        numberMap.put('2', "贰");
        numberMap.put('3', "叁");
        numberMap.put('4', "肆");
        numberMap.put('5', "伍");
        numberMap.put('6', "陆");
        numberMap.put('7', "柒");
        numberMap.put('8', "捌");
        numberMap.put('9', "玖");
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
