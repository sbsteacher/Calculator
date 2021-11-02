package com.koreait.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvDisplay;
    private EditText etVal1;
    private EditText etVal2;
    private EditText etResult;

    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.tvDisplay);
        etVal1 = findViewById(R.id.etVal1);
        etVal2 = findViewById(R.id.etVal2);
        etResult = findViewById(R.id.etResult);
    }
    // Clear 버튼 이벤트
    public void clkClear(View v) {
        operator = "";
        tvDisplay.setText("");
        etVal1.getText().clear();
        etVal2.getText().clear();
        etResult.getText().clear();
    }

    // 숫자 버튼 이벤트
    public void clkNumber(View v) {
        TextView tv = (TextView)v;
        String num = tv.getText().toString();
        addTvDisplay(num);
        switch (operator) {
            case "":
                etVal1.append(num);
                break;
            default:
                String oldVal2 = etVal2.getText().toString();
                etVal2.setText(oldVal2 + num);
                break;
        }
    }

    // 사칙연산 버튼 이벤트
    public void clkOperator(View v) {
        TextView tv = (TextView)v;
        String oper = tv.getText().toString();
        operator = oper;

        addTvDisplay(oper);
    }

    // equal 버튼 이벤트
    public void clkEqual(View v) {
        addTvDisplay("=");
        String strVal1 = etVal1.getText().toString();
        String strVal2 = etVal2.getText().toString();
        int intVal1 = Integer.parseInt(strVal1);
        int intVal2 = Integer.parseInt(strVal2);

        String strResult = "";

        switch(operator) {
            case "+":
                strResult = String.valueOf(intVal1 + intVal2);
                break;
            case "-":
                strResult = String.valueOf(intVal1 - intVal2);
                break;
            case "/":
                strResult = String.valueOf((float)intVal1 / intVal2);
                break;
            case "*":
                strResult = String.valueOf(intVal1 * intVal2);
                break;
        }
        addTvDisplay(strResult);
        etResult.setText(strResult);
    }

    private void addTvDisplay(String val) {
        //String oldVal = tvDisplay.getText().toString();
        //tvDisplay.setText(oldVal + val);
        tvDisplay.append(val);
    }
}