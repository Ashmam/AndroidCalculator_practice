package com.example.a18751.my_calculator.util;

/**
 * @version: 10.0.2
 * @program: XiaoMiCalculator
 * @Package: com.example.a18751.xiaomicalculator.util
 * @className: Judge
 * @description: 判定工具
 * @author: ZJH
 * @create: 2020-01-28 01:28
 **/
public class JudgeUtil {
    public static boolean isOperator(char varchar) {
        switch (varchar) {
            case '＋':
                return true;
            case '－':
                return true;
            case '×':
                return true;
            case '÷':
                return true;
            default:
                return false;
        }
    }

    public static boolean compareToLevel(char operator1, char operator2) {
        if (isLevel(operator1)>isLevel(operator2))
            return true;
        else return false;
    }

    public static int isLevel(char operator) {
        switch (operator) {
            case '＋':
                return 0;
            case '－':
                return 0;
            case '×':
                return 1;
            case '÷':
                return 1;
        }
        return 0;
    }

    public static double count(String num1,String num2,String operator){
        switch (operator){
            case "＋":
                return Double.parseDouble(num1)+Double.parseDouble(num2);
            case "－":
                return Double.parseDouble(num1)-Double.parseDouble(num2);
            case "×":
                return Double.parseDouble(num1)*Double.parseDouble(num2);
            case "÷":
                return Double.parseDouble(num1)/Double.parseDouble(num2);
        }
        return 0;
    }
}
