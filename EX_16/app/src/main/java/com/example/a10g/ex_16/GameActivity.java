package com.example.a10g.ex_16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private TextView txtcom,txtresult;
    private Button btnsci,btncloth,btnstone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        txtcom=findViewById(R.id.txt_com);
        txtresult=findViewById(R.id.txt_result);
        btncloth=findViewById(R.id.btn_cloth);
        btnsci=findViewById(R.id.btn_sci);
        btnstone=findViewById(R.id.btn_stone);

        btncloth.setOnClickListener(btnclothListener);
        btnsci.setOnClickListener(btnsciListener);
        btnstone.setOnClickListener(btnstoneListener);
    }
    private Button.OnClickListener btnclothListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com=(int)(Math.random()*3+1);

            if (com==1)
            {
                txtcom.setText(R.string.scissors);
                txtresult.setText(getString(R.string.result)+getString(R.string.loss));
            }
            else if (com==2)
            {
                txtcom.setText(R.string.stone);
                txtresult.setText(getString(R.string.result)+getString(R.string.win));

            }
            else
            {
                txtcom.setText(R.string.cloth);
                txtresult.setText(getString(R.string.result)+getString(R.string.even));

            }
        }
    };
    private Button.OnClickListener btnstoneListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com=(int)(Math.random()*3+1);

            if (com==1)
            {
                txtcom.setText(R.string.scissors);
                txtresult.setText(getString(R.string.result)+getString(R.string.win));
            }
            else if (com==2)
            {
                txtcom.setText(R.string.stone);
                txtresult.setText(getString(R.string.result)+getString(R.string.even));

            }
            else
            {
                txtcom.setText(R.string.cloth);
                txtresult.setText(getString(R.string.result)+getString(R.string.loss));

            }
        }
    };
    private Button.OnClickListener btnsciListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com=(int)(Math.random()*3+1);

            if (com==1)
            {
                txtcom.setText(R.string.scissors);
                txtresult.setText(getString(R.string.result)+getString(R.string.even));
            }
            else if (com==2)
            {
                txtcom.setText(R.string.stone);
                txtresult.setText(getString(R.string.result)+getString(R.string.loss));

            }
            else
            {
                txtcom.setText(R.string.cloth);
                txtresult.setText(getString(R.string.result)+getString(R.string.win));

            }
        }
    };
}
