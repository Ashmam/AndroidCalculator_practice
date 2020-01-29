package com.example.a18751.my_calculator;

import com.example.a18751.my_calculator.bean.EquationBean;
import com.example.a18751.my_calculator.contract.MainContract;
import com.example.a18751.my_calculator.model.MainModel;
import com.example.a18751.my_calculator.presenter.MainPresenter;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void test(){
        assertEquals(4, 2 + 2);
        EquationBean e=new EquationBean("1＋1÷1");
        MainModel m=new MainModel(e);
        m.getResultBean().getResult();
    }
}