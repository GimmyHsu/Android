package com.example.a10g.ex_16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1;
        btn1=findViewById(R.id.btn_1);
        btn1.setOnClickListener(btn1Listener);
    }
    private Button.OnClickListener btn1Listener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it=new Intent();
            it.setClass(MainActivity.this,GameActivity.class);
            startActivity(it);
        }
    };
}
