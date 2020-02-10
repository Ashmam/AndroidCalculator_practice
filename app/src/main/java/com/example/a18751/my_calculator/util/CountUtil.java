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
public final class CountUtil {
    /**
     * 判断是否是运算符
     * @param varchar
     * @return
     */
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

    /**
     * 比较运算符等级
     * @param operator1
     * @param operator2
     * @return
     */
    public static boolean compareToLevel(char operator1, char operator2) {
        if (isLevel(operator1)>isLevel(operator2))
            return true;
        else return false;
    }

    /**
     * 判断运算符等级
     * @param operator
     * @return
     */
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

    /**
     * 计算num1 Operator num2=？
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
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
