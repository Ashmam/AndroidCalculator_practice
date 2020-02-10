package com.example.a18751.my_calculator.bean;

import java.util.Date;
import java.util.Map;

/**
 * @version: 1.8.0_74-b02
 * @program: My_Calculator
 * @Package: com.example.a18751.my_calculator.bean
 * @className: UserBean
 * @description: 用户实体类
 * @author: Ashmam
 * @create: 2020-02-01 00:59
 **/
public class UserBean {
    private String String_nickName;
    private String String_accountNumbers;
    private String String_password;
    private String String_email;
    private char char_sex;
    private Date Date_birthday;
    private int int_useTimes;
    private Map<Date,String> Map_useHistory;

    public UserBean() {
    }

    public Map<Date, String> getUsehistory() {
          return Map_useHistory;
    }

    public void setUsehistory(Map<Date, String> usehistory) {
        this.Map_useHistory = usehistory;
    }

    public String getString_nickName() {
        return String_nickName;
    }

    public void setString_nickName(String string_nickName) {
        String_nickName = string_nickName;
    }

    public String getString_accountNumbers() {
        return String_accountNumbers;
    }

    public void setString_accountNumbers(String string_accountNumbers) {
        String_accountNumbers = string_accountNumbers;
    }

    public String getString_password() {
        return String_password;
    }

    public void setString_password(String string_password) {
        String_password = string_password;
    }

    public String getString_email() {
        return String_email;
    }

    public void setString_email(String string_email) {
        String_email = string_email;
    }

    public char getChar_sex() {
        return char_sex;
    }

    public void setChar_sex(char char_sex) {
        this.char_sex = char_sex;
    }

    public Date getDate_birthday() {
        return Date_birthday;
    }

    public void setDate_birthday(Date date_birthday) {
        Date_birthday = date_birthday;
    }

    public int getInt_useTimes() {
        return int_useTimes;
    }

    public void setInt_useTimes(int int_useTimes) {
        this.int_useTimes = int_useTimes;
    }
}
