package com.example.a10g.ex_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private NumberPicker Numpicage;
private Button btn;
private TextView tvage,tvsug;
private Spinner spnsex;
private String strsex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn1);
        tvsug=findViewById(R.id.tv_sug);
        tvage=findViewById(R.id.tv_age);
        spnsex=findViewById(R.id.spn_sex);
        Numpicage=findViewById(R.id.numpic1);

        tvage.setText("20");
        Numpicage.setMinValue(1);
        Numpicage.setMaxValue(150);
        Numpicage.setValue(25);

        btn.setOnClickListener(btnListener);
        spnsex.setOnItemSelectedListener(spnsexListener);
        Numpicage.setOnValueChangedListener(NumpicageListener);
    }
    private Button.OnClickListener btnListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
           int age=Numpicage.getValue();
           String strsug=getString(R.string.suggest);
        if (strsex.equals(getString(R.string.male)))
           if (age<30)
               strsug+=getString(R.string.sug_not_hurry);
           else if (age>35)
               strsug+=getString(R.string.sug_get_marry);
           else
               strsug+=getString(R.string.sug_find);
        else
        if (age<27)
            strsug+=getString(R.string.sug_not_hurry);
        else if (age>32)
            strsug+=getString(R.string.sug_get_marry);
        else
            strsug+=getString(R.string.sug_find);
tvsug.setText(strsug);
        }
    };
private Spinner.OnItemSelectedListener spnsexListener= new Spinner.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        strsex=parent.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
};
private NumberPicker.OnValueChangeListener NumpicageListener=new NumberPicker.OnValueChangeListener() {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
       tvage.setText(String.valueOf(newVal));
    }
};
}
