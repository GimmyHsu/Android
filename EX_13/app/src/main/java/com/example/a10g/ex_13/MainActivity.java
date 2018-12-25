package com.example.a10g.ex_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
int[] imgId={R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4,R.drawable.car5,R.drawable.car6};
private Button btnPrev,btnNext;
private ImageView imgPhoto;
int p=0;
int count=imgId.length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btnPrev=findViewById(R.id.btnPrev);
    btnNext=findViewById(R.id.btnNext);
    imgPhoto=findViewById(R.id.imgPhoto);
    btnPrev.setOnClickListener(btnPrevListener);
    btnNext.setOnClickListener(btnNextListenter);
    }
    private Button.OnClickListener btnPrevListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            p--;
            if (p<0)
                p=count-1;
            imgPhoto.setImageResource(imgId[p]);
            setTitle("第"+(p+1)+"/"+count);
        }
    };
    private Button.OnClickListener btnNextListenter= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            p++;
            if (p==count)
                p=0;
            imgPhoto.setImageResource(imgId[p]);
            setTitle("第"+(p+1)+"/"+count);
        }
    };

}
