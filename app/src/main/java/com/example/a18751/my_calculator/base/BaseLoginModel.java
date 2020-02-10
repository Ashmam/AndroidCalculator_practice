package com.example.a18751.my_calculator.base;

/**
 * @version: 1.8.0_74-b02
 * @program: My_Calculator
 * @Package: com.example.a18751.my_calculator.base
 * @className: BaseLoginModel
 * @description: 登录模块moudel
 * @author: Ashmam
 * @create: 2020-02-03 02:47
 **/
public interface BaseLoginModel {
    void login(String email,String password);
    void logout();
}
