package com.example.a10g.ex_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText edtATM;
private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnBack,btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtATM=findViewById(R.id.edt_ATM);
        btn1=findViewById(R.id.btnN1);
        btn2=findViewById(R.id.btnN2);
        btn3=findViewById(R.id.btnN3);
        btn4=findViewById(R.id.btnN4);
        btn5=findViewById(R.id.btnN5);
        btn6=findViewById(R.id.btnN6);
        btn7=findViewById(R.id.btnN7);
        btn8=findViewById(R.id.btnN8);
        btn9=findViewById(R.id.btnN9);
        btn0=findViewById(R.id.btnN0);
        btnBack=findViewById(R.id.btnBack);
        btnOK=findViewById(R.id.btnOK);

        btnOK.setOnClickListener(listener);
        btnBack.setOnClickListener(listener);
        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        btn8.setOnClickListener(listener);

    }
    private Button.OnClickListener listener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnN1:
                    displayATM("1");
                    break;
                case R.id.btnN2:
                    displayATM("2");
                    break;
                case R.id.btnN3:
                    displayATM("3");
                    break;
                case R.id.btnN4:
                    displayATM("4");
                    break;
                case R.id.btnN5:
                    displayATM("5");
                    break;
                case R.id.btnN6:
                    displayATM("6");
                    break;
                case R.id.btnN7:
                    displayATM("7");
                    break;
                case R.id.btnN8:
                    displayATM("8");
                    break;
                case R.id.btnN9:
                    displayATM("9");
                    break;
                case R.id.btnN0:
                    displayATM("0");
                    break;
                case R.id.btnBack:
                    String str=edtATM.getText().toString();
                    if (str.length()>0){
                        str=str.substring(0,str.length()-1);
                        edtATM.setText(str);
                    }
                    break;
                case R.id.btnOK:
                    str=edtATM.getText().toString();
                    if (str.equals("123456")){
                        Toast toast=Toast.makeText(MainActivity.this,"密碼正確",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }else {
                        Toast toast=Toast.makeText(MainActivity.this,"密碼錯誤",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                        edtATM.setText("");
                    }
                    break;
            }
        }
    };
    private void displayATM(String s){
        String str=edtATM.getText().toString();
        edtATM.setText(str+s);
    }
}
