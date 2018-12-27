package com.example.a10g.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText edtW;
private Button btnC;
private TextView txtA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtW=findViewById(R.id.edtW);
        btnC=findViewById(R.id.btnC);
        txtA=findViewById(R.id.txtA);

        btnC.setOnClickListener(btnCListener);
    }
    private Button.OnClickListener btnCListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
           float input1=Integer.parseInt(edtW.getText().toString());
           float s=(input1*9/5)+32;
         String w=getResources().getString(R.string.r);
           txtA.setText(w+"\n"+getResources().getString(R.string.s_c)+input1+getResources().getString(R.string.s_d)+"="+getResources().getString(R.string.s_f)+s+getResources().getString(R.string.s_d));
        }
    };
}
