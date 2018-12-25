package com.example.a10g.ex_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private RadioGroup RadGrpSex,RadGrpAge;
private RadioButton rbage1,rbage2,rbage3;
private Button btn;
private TextView sug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadGrpAge=findViewById(R.id.radgrp_age);
        RadGrpSex=findViewById(R.id.radgrp_sex);
        rbage1=findViewById(R.id.radbtn1);
        rbage2=findViewById(R.id.radbtn2);
        rbage3=findViewById(R.id.radbtn3);
        RadGrpSex.setOnCheckedChangeListener(RadGrpSexListener);
        sug=findViewById(R.id.tv3);
        btn=findViewById(R.id.btn1);
        btn.setOnClickListener(btnListener);
    }
    private Button.OnClickListener btnListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
         String StrSug=getString(R.string.str3);
         switch (RadGrpAge.getCheckedRadioButtonId()){
             case R.id.radbtn1:
                 StrSug+=getString(R.string.sug_not_hurry);
                 break;
             case R.id.radbtn2:
                 StrSug+=getString(R.string.sug_find);
             case R.id.radbtn3:
                 StrSug+=getString(R.string.sug_get_marry);

         }
         sug.setText(StrSug);
        }
    };
    private RadioGroup.OnCheckedChangeListener RadGrpSexListener=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int i) {
          if (i==R.id.rabbtn_male) {
              rbage1.setText(getString(R.string.male_agemin));
              rbage2.setText(getString(R.string.male_agemid));
              rbage3.setText(getString(R.string.male_agemax));
          }else {
              rbage1.setText(getString(R.string.female_agemin));
              rbage2.setText(getString(R.string.female_agemid));
              rbage3.setText(getString(R.string.female_agemax));

          }
        }
    };
}
