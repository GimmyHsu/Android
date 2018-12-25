package com.example.a10g.ex_12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private GridView gridView;
private int[] image={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12};
private String[] imgText={"鼠","牛","虎","兔","龍","蛇","馬","羊","猴","雞","狗","豬"};
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    List<Map<String,Object>> items=new ArrayList<>();
    for (int i = 0;i<image.length;i++){
        Map<String,Object> item=new HashMap<>();
        item.put("image",image[i]);
        item.put("text",imgText[i]);
        items.add(item);
    }

    SimpleAdapter adapter=new SimpleAdapter(this,items,R.layout.grid_item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
    gridView=findViewById(R.id.main_gridview);
    gridView.setNumColumns(3);
    gridView.setAdapter(adapter);
    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?>parent, View view,int position,long id){
            Toast.makeText(MainActivity.this,"你選擇了:\n"+imgText[position],Toast.LENGTH_SHORT).show();
        }
    });
    }
}
