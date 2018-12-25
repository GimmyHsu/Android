package com.example.a10g.ex_9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private ListView lvEdu;
static String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
buildViews();
    }
    private void buildViews()
    {
        lvEdu=findViewById(R.id.lvldEdu);
        ArrayAdapter<CharSequence> adEduList=ArrayAdapter.createFromResource(this,R.array.lvEduList,android.R.layout.simple_list_item_1);
        lvEdu.setAdapter(adEduList);
        lvEdu.setOnItemClickListener(lvListener);
    }
    private OnItemClickListener lvListener=new OnItemClickListener() {

        public void onItemClick(AdapterView<?>parent,View view,int position,long id){
msg="你的教育程度:\n";
msg+=((TextView) view).getText().toString();
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
        }
    };
}
