package com.example.a10g.ex_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        TextView txtShow=findViewById(R.id.txtShow);
        Button btnHome=findViewById(R.id.btnHome);

        btnHome.setOnClickListener(btnHomeListener);

        Intent it=this.getIntent();
        Bundle b1=it.getExtras();
        String name=b1.getString("名子");
        int age=b1.getInt("年齡");
        Double tall=b1.getDouble("身高");
        String s="Name:"+name+"\n"+
                "Age:"+age+"\n"+
                "Tall:"+tall;
        txtShow.setText(s);

    }
    private Button.OnClickListener btnHomeListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
