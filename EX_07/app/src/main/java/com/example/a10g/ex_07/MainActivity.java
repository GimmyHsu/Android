package com.example.a10g.ex_07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView txtresult;
private ImageView ivcom;
private ImageButton ibtncloth,ibtnstone,ibtnsci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtresult=findViewById(R.id.txt_result);
        ivcom=findViewById(R.id.iv_com);
        ibtncloth=findViewById(R.id.ibtn_cloth);
        ibtnsci=findViewById(R.id.ibtn_sci);
        ibtnstone=findViewById(R.id.ibtn_stone);

        ibtncloth.setOnClickListener(ibtnclothListener);
        ibtnstone.setOnClickListener(ibtnstoneListener);
        ibtnsci.setOnClickListener(ibtnsciListener);
    }
    private ImageButton.OnClickListener ibtnsciListener= new ImageButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com=(int)(Math.random()*3+1);

            if (com==1)
            {
                ivcom.setImageResource(R.drawable.scissors);
                txtresult.setText(getString(R.string.result)+getString(R.string.loss));
            }
            else if (com==2)
            {
                ivcom.setImageResource(R.drawable.rock);
                txtresult.setText(getString(R.string.result)+getString(R.string.win));

            }
            else
            {
                ivcom.setImageResource(R.drawable.paper);
                txtresult.setText(getString(R.string.result)+getString(R.string.even));

            }
        }
    };
    private ImageButton.OnClickListener ibtnstoneListener= new ImageButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com=(int)(Math.random()*3+1);

            if (com==1)
            {
                ivcom.setImageResource(R.drawable.scissors);
                txtresult.setText(getString(R.string.result)+getString(R.string.win));
            }
            else if (com==2)
            {
                ivcom.setImageResource(R.drawable.rock);
                txtresult.setText(getString(R.string.result)+getString(R.string.even));

            }
            else
            {
                ivcom.setImageResource(R.drawable.paper);
                txtresult.setText(getString(R.string.result)+getString(R.string.loss));

            }
        }
    };
    private ImageButton.OnClickListener ibtnclothListener= new ImageButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com=(int)(Math.random()*3+1);

            if (com==1)
            {
                ivcom.setImageResource(R.drawable.scissors);
                txtresult.setText(getString(R.string.result)+getString(R.string.even));
            }
            else if (com==2)
            {
                ivcom.setImageResource(R.drawable.rock);
                txtresult.setText(getString(R.string.result)+getString(R.string.loss));

            }
            else
            {
                ivcom.setImageResource(R.drawable.paper);
                txtresult.setText(getString(R.string.result)+getString(R.string.win));

            }
        }
    };
}
