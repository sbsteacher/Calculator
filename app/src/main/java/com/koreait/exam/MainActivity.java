package com.koreait.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText = findViewById(R.id.etText);
    }
    // Clear 버튼 이벤트
    public void clkClear(View v) {
        //etText.setText("");
        etText.getText().clear();
    }

    // Clear 버튼 제외한 나머지 버튼들의 이벤트
    public void clkBtn(View v) {
        String str = etText.getText().toString();

        TextView tv = (TextView)v;
        String val = tv.getText().toString();

        str += val;

        etText.setText(str);
    }
}