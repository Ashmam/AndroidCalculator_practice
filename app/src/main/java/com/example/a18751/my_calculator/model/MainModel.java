package com.example.a18751.my_calculator.model;

import com.example.a18751.my_calculator.bean.EquationBean;
import com.example.a18751.my_calculator.contract.MainContract;
import com.example.a18751.my_calculator.bean.ResultBean;
import com.example.a18751.my_calculator.util.JudgeUtil;

import java.util.Stack;


/**
 * @version: 10.0.2
 * @program: XiaoMiCalculator
 * @Package: com.example.a18751.xiaomicalculator.model
 * @className: MainModel
 * @description: main model
 * @author: ZJH
 * @create: 2020-01-25 19:51
 **/
public class MainModel implements MainContract.Model {

    private EquationBean equationBean;
    public String[] rpn;
    private Stack operator;
    private ResultBean resultBean;

    public MainModel(EquationBean equationBean) {
        this.equationBean = equationBean;
        resultBean = new ResultBean();
        operator = new Stack();
        rpn = new String[9];
        count();
    }

    public ResultBean getResultBean() {
        return this.resultBean;
    }

    @Override
    public void RPN() {
        int j = 0;//rpn中下一个元素的下标
        int k = -1;//遍历时上一个运算符的下标
        for (int i = 0; i < equationBean.getEquation().length(); i++) {//遍历算式
            char ch = equationBean.getEquation().charAt(i);
            if (JudgeUtil.isOperator(ch)) {//判定是否为运算符
                this.rpn[j] = equationBean.getEquation().substring(k + 1, i);
                k = i;
                j++;
                if (operator.isEmpty())//判定运算符栈是否为空
                    //压入运算符栈
                    operator.push(ch);
                else {
                    //如果扫描到的运算符优先级低于栈顶运算符，则栈顶运算符弹出
                    // 直至栈顶运算符优先级小于或等于当前运算符
                    while(JudgeUtil.compareToLevel((char) operator.peek(), ch)) {
                        rpn[j] = String.valueOf(operator.pop());
                        j++;
                        if (operator.isEmpty())break;
                    }
                    operator.push(ch);
                }
            }
        }
        //将最后一个数输出
        this.rpn[j] = equationBean.getEquation().substring(k + 1);
        j++;
        //遍历算式后，若运算符栈不为空则运算符依次弹出
        while (!operator.isEmpty()) {
            rpn[j] = String.valueOf(operator.pop());
            j++;
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
            if (str.peek().length() == 1&&JudgeUtil.isOperator(str.peek().charAt(0))) {
                String op = str.pop();
                String n1 = str.pop();
                String n2 = str.pop();
                str.push(String.valueOf(JudgeUtil.count(n2, n1, op)));
            }
        }
        this.resultBean.setResult(str.pop());
    }


}
