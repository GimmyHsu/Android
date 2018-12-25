package com.example.a10g.ex_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox chkmusic,chksing,chkdance,chktravel,chkreading,chkwriting,chkclimbing,chkswimming,chkexercise,chkfitness,chkphoto,chkeating,chkdraw;
    private Button btnok;
    private TextView tvresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkmusic=findViewById(R.id.chkbox_music);
        chksing=findViewById(R.id.chkbox_sing);
        chkdance=findViewById(R.id.chkbox_dance);
        chktravel=findViewById(R.id.chkbox_travel);
        chkreading=findViewById(R.id.chkbox_reading);
        chkwriting=findViewById(R.id.chkbox_writing);
        chkclimbing=findViewById(R.id.chkbox_climbing);
        chkexercise=findViewById(R.id.chkbox_exercise);
        chkfitness=findViewById(R.id.chkbox_fitness);
        chkphoto=findViewById(R.id.chkbox_photo);
        chkeating=findViewById(R.id.chkbox_eating);
        chkdraw=findViewById(R.id.chkbox_draw);
        chkswimming=findViewById(R.id.chkbox_swimming);
        btnok=findViewById(R.id.btn_ok);
        tvresult=findViewById(R.id.tv_result);
        btnok.setOnClickListener(btnokListener);

    }
    private Button.OnClickListener btnokListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str=getString(R.string.yourhobby);
            if (chkclimbing.isChecked())
                str+=chkclimbing.getText().toString();
            if (chkmusic.isChecked())
                str+=chkmusic.getText().toString();
            if (chksing.isChecked())
                str+=chksing.getText().toString();
            if (chkdance.isChecked())
                str+=chkdance.getText().toString();
            if (chktravel.isChecked())
                str+=chktravel.getText().toString();
            if (chkreading.isChecked())
                str+=chkreading.getText().toString();
            if (chkwriting.isChecked())
                str+=chkwriting.getText().toString();
            if (chkeating.isChecked())
                str+=chkeating.getText().toString();
            if (chkfitness.isChecked())
                str+=chkfitness.getText().toString();
            if (chkphoto.isChecked())
                str+=chkphoto.getText().toString();
            if (chkexercise.isChecked())
                str+=chkexercise.getText().toString();
            if (chkdraw.isChecked())
                str+=chkdraw.getText().toString();
            if (chkswimming.isChecked())
                str+=chkswimming.getText().toString();
            tvresult.setText(str);
        }
    };
}
