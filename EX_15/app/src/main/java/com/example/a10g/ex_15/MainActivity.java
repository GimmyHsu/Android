package com.example.a10g.ex_15;

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
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,Second.class);
            startActivity(intent);
        }
    };
}
