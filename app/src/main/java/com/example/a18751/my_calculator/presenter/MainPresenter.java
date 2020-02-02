package com.example.a18751.my_calculator.presenter;

import com.example.a18751.my_calculator.bean.EquationBean;
import com.example.a18751.my_calculator.contract.MainContract;
import com.example.a18751.my_calculator.model.MainModel;
import com.example.a18751.my_calculator.util.JudgeUtil;

import java.text.DecimalFormat;


/**
 * @version: 1.8.0_74-b02
 * @program: My_Calculator
 * @Package: com.example.a18751.my_calculator.presenter
 * @className: MainPresenter
 * @description: MainPresenter
 * @author: Ashmam
 * @create: 2020-01-25 21:50
 **/
public class MainPresenter<T extends MainContract.View> implements MainContract.Presenter {

    private MainModel mmodel;
    private MainContract.View mView;
    private boolean condition;
    private char lastChar;

    public MainPresenter() {
        this.condition = false;
    }

    public void setMmodel(EquationBean equation) {
        this.mmodel = new MainModel(equation);
    }

    public void setLastChar(char lastChar) {
        this.lastChar = lastChar;
    }

    @Override
    public void output(){
        mView.showResult(String.valueOf(new DecimalFormat("#.####")
                .format(Double.parseDouble(this.mmodel.getResultBean().getResult()))));
    }

    @Override
    public void updateEditText(char varchar) {

        if (!this.condition) {
            if (JudgeUtil.isOperator(varchar)||varchar=='.')
                this.condition = true;
        }

        if (!JudgeUtil.isOperator(varchar)&&varchar!='.'){
            mView.showInput(varchar, this.condition);
        }
        else if (!JudgeUtil.isOperator(this.lastChar)&&this.lastChar!='.'){
            mView.showInput(varchar, this.condition);
        }

        this.condition = true;
        this.lastChar=varchar;
    }

    @Override
    public void percentOperator(String equation){
        int counter=0;
        boolean op=false;//运算符存在标记
        String str;
        if (!JudgeUtil.isOperator(this.lastChar)&&this.lastChar!='.'){
            for (int i=equation.length()-1;i>=0;i--) {
                if (JudgeUtil.isOperator(equation.charAt(i))){
                    op=true;
                    counter=i+1;
                    break;
                }
            }
            if (op)
                str=equation.substring(counter);
            else
                str=equation;
            double num=Double.parseDouble(str)/100;
            mView.showPercent(String.valueOf(new StringBuffer(equation).replace(counter,equation.length(), new DecimalFormat("#.####").format(num))));
        }
    }

    @Override
    public void attachView(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public boolean isViewAttach() {
        return this.mView != null;
    }

    @Override
    public void start() {
        this.mmodel = null;
        this.condition = false;
    }

}
