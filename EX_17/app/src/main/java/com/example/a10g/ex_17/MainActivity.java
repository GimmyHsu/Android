package com.example.a10g.ex_17;

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
        Button btnPage2=findViewById(R.id.btnPage2);
        btnPage2.setOnClickListener(btnPage2Listener);
    }
    private Button.OnClickListener btnPage2Listener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it=new Intent();
            it.setClass(MainActivity.this,Second.class);

            String name="Gimmy";
            int age=32;
            Double tall=175.5;

            Bundle b1=new Bundle();
            b1.putString("名子",name);
            b1.putInt("年齡",age);
            b1.putDouble("身高",tall);
            it.putExtras(b1);

            startActivity(it);
        }
    };
}
