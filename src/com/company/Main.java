package com.company;

import com.company.exchange.func1.util.ReadUtil;
import com.company.util.SpeakUtils;
import org.apache.commons.lang.StringUtils;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ReadUtil readUtil = new ReadUtil();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字，当输入ENTER时结束！");
        while(scanner.hasNextLine()){
            String scan = scanner.nextLine();
            if(StringUtils.isBlank(scan)){
                SpeakUtils.speak("正在退出，感谢您的使用！");
                break;
            }
            String out="";
            try {
                out = readUtil.read(scan);
            } catch (Exception e){
                out = e.getMessage();
            }
            System.out.println("输出"+out);
            SpeakUtils.speak(out);
        }
    }
}
