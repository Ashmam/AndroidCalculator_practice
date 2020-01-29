package com.example.a18751.my_calculator.bean;

/**
 * @version: 1.8.0_74-b02
 * @program: My_Calculator
 * @Package: com.example.a18751.my_calculator.bean
 * @className: EquationBean
 * @description: 算式实体类
 * @author: Ashmam
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
