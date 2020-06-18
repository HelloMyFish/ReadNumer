package com.company.exchange;

import com.company.exchange.func1.util.ReadUtil;
import org.apache.commons.lang.math.NumberUtils;
import org.junit.jupiter.api.Test;

/**
 * @Title:
 * @Package
 * @Description:
 * @Author gyf
 * @Date 2020/6/6 14:06
 */
public class NumberTest {
    @Test
    public void test(){
       /* Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.forEach((k,v)->{
            System.out.println("k="+k+",v="+v);
        });*/
//        AbstractReadNumber abstractReadNumber = new ReadNumberByChinese();
        ReadUtil abstractReadNumber = new ReadUtil();
        System.out.println("11==>"+abstractReadNumber.read("11"));
        System.out.println("10==>"+abstractReadNumber.read("10"));
        System.out.println("20==>"+abstractReadNumber.read("20"));
        System.out.println("100==>"+abstractReadNumber.read("100"));
        System.out.println("21==>"+abstractReadNumber.read("21"));
        System.out.println("101==>"+abstractReadNumber.read("101"));
        System.out.println("1001==>"+abstractReadNumber.read("1001"));
        System.out.println("10011==>"+abstractReadNumber.read("10011"));
        System.out.println("10000==>"+abstractReadNumber.read("10000"));


        System.out.println("12====>"+abstractReadNumber.read("12"));
        System.out.println("10002====>"+abstractReadNumber.read("10002"));
        System.out.println("102====>"+abstractReadNumber.read("102"));
        System.out.println("120====>"+abstractReadNumber.read("120"));
        System.out.println("120====>"+abstractReadNumber.read("120"));
        System.out.println("0120====>"+abstractReadNumber.read("0120"));
        System.out.println("00000120====>"+abstractReadNumber.read("00000120"));
        System.out.println("50000====>"+abstractReadNumber.read("50000"));
        System.out.println("5====>"+abstractReadNumber.read("5"));
        System.out.println("912345678====>"+abstractReadNumber.read("912345678"));
//        System.out.println("1912345678====>"+abstractReadNumber.read("1912345678"));
        System.out.println(Long.MAX_VALUE+"====>"+abstractReadNumber.read(Long.MAX_VALUE));
    }
    @Test
    public void tes(){
        String s = "-1";
        System.out.println(NumberUtils.isDigits(s));
        System.out.println(NumberUtils.isNumber(s));
        String s1 = "11.1";
        System.out.println(NumberUtils.isDigits(s));
        System.out.println(NumberUtils.isNumber(s));
    }
}
