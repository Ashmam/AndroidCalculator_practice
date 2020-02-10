package com.example.a18751.my_calculator.model;

import com.example.a18751.my_calculator.bean.EquationBean;
import com.example.a18751.my_calculator.contract.MainContract;
import com.example.a18751.my_calculator.bean.ResultBean;
import com.example.a18751.my_calculator.util.CountUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @version: 1.8.0_74-b02
 * @program: My_Calculator
 * @Package: com.example.a18751.my_calculator.model
 * @className: MainModel
 * @description: main model
 * @author: Ashmam
 * @create: 2020-01-25 19:51
 **/
@SuppressWarnings("unchecked")
public class MainModel implements MainContract.Model {

    private EquationBean equationBean;
    private List<String> rpn;
    private Stack operator;
    private ResultBean resultBean;

    public MainModel(EquationBean equationBean) {
        this.equationBean = equationBean;
        resultBean = new ResultBean();
        operator = new Stack();
        rpn = new ArrayList<String>();
        count();
    }

    public ResultBean getResultBean() {
        return this.resultBean;
    }

    @Override
    public void RPN() {
        int k = -1;//遍历时上一个运算符的下标
        for (int i = 0; i < equationBean.getEquation().length(); i++) {//遍历算式
            char ch = equationBean.getEquation().charAt(i);
            if (CountUtil.isOperator(ch)) {//判定是否为运算符
                this.rpn.add(equationBean.getEquation().substring(k + 1, i));
                k = i;
                //如果该运算符在算式末尾则结束遍历
                if (i==equationBean.getEquation().length()-1)break;
                if (operator.isEmpty())//判定运算符栈是否为空
                    //压入运算符栈
                    //noinspection unchecked
                    operator.push(ch);
                else {
                    //如果扫描到的运算符优先级低于栈顶运算符，则栈顶运算符弹出
                    // 直至栈顶运算符优先级小于或等于当前运算符
                    while(CountUtil.compareToLevel((char) operator.peek(), ch)) {
                        rpn.add(String.valueOf(operator.pop()));
                        if (operator.isEmpty())break;
                    }
                    //noinspection unchecked
                    operator.push(ch);
                }
            }
        }
        //将最后一个运算符后的数输出
        if (k!=equationBean.getEquation().length()-1)
            this.rpn.add(equationBean.getEquation().substring(k + 1));
        //遍历算式后，若运算符栈不为空则运算符依次弹出
        while (!operator.isEmpty()) {
            rpn.add(String.valueOf(operator.pop()));
        }
    }

    @Override
    public void count() {
        RPN();
        Stack<String> str = new Stack<>();
        for (String i :
                rpn) {
            if (i == null) break;
            str.push(i);
            if (CountUtil.isOperator(str.peek().charAt(0))) {
                String op = str.pop();
                String n1 = str.pop();
                String n2 = str.pop();
                str.push(String.valueOf(CountUtil.count(n2, n1, op)));
            }
        }
        this.resultBean.setResult(str.pop());
    }


}
