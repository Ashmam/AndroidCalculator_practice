package com.example.a18751.my_calculator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import com.example.a18751.my_calculator.bean.EquationBean;
import com.example.a18751.my_calculator.contract.MainContract;
import com.example.a18751.my_calculator.presenter.MainPresenter;
import com.example.a18751.my_calculator.view.LoginActivity;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    private TextView textView_input;
    private TextView textView_output;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.attachView(this);
        this.textView_input = findViewById(R.id.input);
        this.textView_output = findViewById(R.id.result);
        //取出savedInstanceState保存的数据
        if (savedInstanceState != null){
            Log.d("MainActivity", "take out data: on execute");
            textView_input.setText(savedInstanceState.getString("equation"));
            textView_output.setText(savedInstanceState.getString("result"));
        }
        else
            Log.d("MainActivity", "savedInstanceState: null");
        //userLogo
        final ImageView imageView_userLogo = findViewById(R.id.userLogo);
        //toolbar
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        //＝
        Button B_equl = findViewById(R.id.equalButton);
        //＋
        Button B_add = findViewById(R.id.addButton);
        //➖
        Button B_minus = findViewById(R.id.minusButton);
        //×
        Button B_multi = findViewById(R.id.multiplyButton);
        //÷
        Button B_division = findViewById(R.id.divisionButton);
        //％
        Button B_percent = findViewById(R.id.percentButton);
        //.
        Button B_point = findViewById(R.id.pointButton);
        //1
        Button B_one = findViewById(R.id.oneButton);
        //2
        Button B_two = findViewById(R.id.twoButton);
        //3
        Button B_three = findViewById(R.id.threeButton);
        //4
        Button B_four = findViewById(R.id.fourButton);
        //5
        Button B_five = findViewById(R.id.fiveButton);
        //6
        Button B_six = findViewById(R.id.sixButton);
        //7
        Button B_seven = findViewById(R.id.sevenButton);
        //8
        Button B_eight = findViewById(R.id.eightButton);
        //9
        Button B_nine = findViewById(R.id.nineButton);
        //0
        Button B_zero = findViewById(R.id.zeroButton);
        //delete
        Button B_delete = findViewById(R.id.deleteButton);
        //clean
        Button B_clean = findViewById(R.id.cleanButton);

        //userLogo操作
        imageView_userLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(MainActivity.this, imageView_userLogo);
                popupMenu.getMenuInflater().inflate(R.menu.user0_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        onOptionsItemSelected(item);
                        Log.d("MainActivity", "onMenuItemClick execute");
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
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
                if (equation.length() == 1) {
                    textView_input.setText("0");
                    presenter.start();
                } else
                    textView_input.setText(equation.substring(0, equation.length() - 1));
                String equationc = textView_input.getText().toString();
                presenter.setLastChar(equationc.charAt(equationc.length() - 1));
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu0_main, menu);
        return true;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    @SuppressLint("PrivateApi")
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_in:
                LoginActivity.actionStart(MainActivity.this);
                break;
            case R.id.sign_up:
                break;
            case R.id.sign_out:
                break;
            case R.id.user_info:
                break;
            case R.id.switch_user:
                break;
            case R.id.quit:
                this.finish();
                break;
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String equation = this.textView_input.getText().toString();
        String result = this.textView_output.getText().toString();
        outState.putString("equation",equation);
        outState.putString("result",result);
        Log.d("MainActivity", "onSavedInstanceState"+outState.getString("result")+":"+result);
    }

    @Override
    public void showResult(String result) {
        textView_output.setText(result);
    }

    @Override
    public void showInput(char varchar, boolean condition) {
        if (!condition)
            textView_input.setText(String.valueOf(varchar));
        else {
            textView_input.setText(String.valueOf(this.textView_input.getText().toString() + varchar));
        }
    }

    @Override
    public void showPercent(String equation) {
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
