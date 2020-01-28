package com.example.a18751.my_calculator.bean;

/**
 * @version: 10.0.2
 * @program: XiaoMiCalculator
 * @Package: com.example.a18751.xiaomicalculator.bean
 * @className: EquationBean
 * @description: 算式实体类
 * @author: ZJH
 * @create: 2020-01-25 15:38
 **/
public class EquationBean {
    private String equation;

    public EquationBean(String equation) {
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
}
