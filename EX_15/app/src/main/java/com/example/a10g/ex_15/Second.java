package com.example.a10g.ex_15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Second extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        Button btnHome=findViewById(R.id.btnHome);
        btnHome.setOnClickListener(btnHomeListener);

    }
    private Button.OnClickListener btnHomeListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
