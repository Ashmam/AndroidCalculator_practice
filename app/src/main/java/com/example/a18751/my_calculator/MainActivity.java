package com.example.a18751.my_calculator;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a18751.my_calculator.bean.EquationBean;
import com.example.a18751.my_calculator.contract.MainContract;
import com.example.a18751.my_calculator.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    private TextView textView_input;
    private TextView textView_output;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        Button B_equl;
        Button B_add;
        Button B_minus;
        Button B_multi;
        Button B_division;
        Button B_percent;
        Button B_point;
        Button B_one;
        Button B_two;
        Button B_three;
        Button B_four;
        Button B_five;
        Button B_six;
        Button B_seven;
        Button B_eight;
        Button B_nine;
        Button B_zero;
        Button B_delete;
        Button B_clean;
        this.textView_input = findViewById(R.id.input);
        this.textView_output = findViewById(R.id.result);
        //＝
        B_equl = findViewById(R.id.equalButton);
        //＋
        B_add = findViewById(R.id.addButton);
        //➖
        B_minus = findViewById(R.id.minusButton);
        //×
        B_multi = findViewById(R.id.multiplyButton);
        //÷
        B_division = findViewById(R.id.divisionButton);
        //％
        B_percent = findViewById(R.id.percentButton);
        //.
        B_point = findViewById(R.id.pointButton);
        //1
        B_one = findViewById(R.id.oneButton);
        //2
        B_two = findViewById(R.id.twoButton);
        //3
        B_three = findViewById(R.id.threeButton);
        //4
        B_four = findViewById(R.id.fourButton);
        //5
        B_five = findViewById(R.id.fiveButton);
        //6
        B_six = findViewById(R.id.sixButton);
        //7
        B_seven = findViewById(R.id.sevenButton);
        //8
        B_eight = findViewById(R.id.eightButton);
        //9
        B_nine = findViewById(R.id.nineButton);
        //0
        B_zero = findViewById(R.id.zeroButton);
        //delete
        B_delete = findViewById(R.id.deleteButton);
        //clean
        B_clean = findViewById(R.id.cleanButton);
        //获取输入框内字符串
        final String equation = this.textView_input.getText().toString();
        //等于操作
        B_equl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String equation = textView_input.getText().toString();
                presenter.setMmodel(new EquationBean(equation));
                presenter.output();
            }
        });
        //百分比操作
        B_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String equation = textView_input.getText().toString();
                presenter.percentOperator(equation);
            }
        });
        //加操作
        B_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('＋');
            }
        });
        //减操作
        B_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('－');
            }
        });
        //乘操作
        B_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('×');
            }
        });
        //除操作
        B_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('÷');
            }
        });
        //小数点操作
        B_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('.');
            }
        });
        //1操作
        B_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('1');
            }
        });
        //2操作
        B_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('2');
            }
        });
        //3操作
        B_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('3');
            }
        });
        //4操作
        B_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('4');
            }
        });
        //5操作
        B_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('5');
            }
        });
        //6操作
        B_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('6');
            }
        });
        //7操作
        B_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('7');
            }
        });
        //8操作
        B_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('8');
            }
        });
        //9操作
        B_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('9');
            }
        });
        //0操作
        B_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEditText('0');
            }
        });
        //删除操作
        B_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String equation = textView_input.getText().toString();
                if (equation.length() == 1){
                    textView_input.setText("0");
                    presenter.start();
                }
                else
                    textView_input.setText(equation.substring(0, equation.length() - 1));
            }
        });
        //清零操作
        B_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.start();
                textView_input.setText("0");
                textView_output.setText(null);
            }
        });

    }

    @Override
    public void showLoading(String result) {
        textView_output.setText(result);
    }

    @Override
    public void showLoading(char varchar, boolean condition) {
        if (!condition)
            textView_input.setText(String.valueOf(varchar));
        else {
            textView_input.setText(String.valueOf(this.textView_input.getText().toString() + varchar));
        }
    }

    public void showLoading(String equation,int i){
        textView_input.setText(equation);
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
