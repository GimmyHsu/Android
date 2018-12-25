package com.example.a10g.ex_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView result;
private EditText age;
private Spinner sex;
private String sexstr;
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age=findViewById(R.id.ed_age);
        result=findViewById(R.id.tv3);
        btn=findViewById(R.id.bnt1);
        sex=findViewById(R.id.spinner1);
        btn.setOnClickListener(btnListener);
        sex.setOnItemSelectedListener(sexListener);
    }
    private Button.OnClickListener btnListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
           int inputage=Integer.parseInt(age.getText().toString());
           String sugstr=getString(R.string.suggest);

           if (sexstr.equals(getString(R.string.male)))
               if (inputage<30)
                   sugstr+=getString(R.string.sug_not_hurry);
               else if (inputage>35)
                   sugstr+=getString(R.string.sug_get_marry);
               else
                   sugstr+=getString(R.string.sug_find);
           else
               if (inputage<27)
                   sugstr+=getString(R.string.sug_not_hurry);
               else if (inputage>32)
                   sugstr+=getString(R.string.sug_get_marry);
               else
                   sugstr+=getString(R.string.sug_find);
               result.setText(sugstr);

        }
    };

    private Spinner.OnItemSelectedListener sexListener= new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sexstr=sex.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
