package com.example.a10g.ex_10;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {
private ListView lvEdu;
private List<Map<String,Object>> mapAry;
String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    int[] icImg={R.drawable.edu1,R.drawable.edu2,R.drawable.edu3,R.drawable.edu4,R.drawable.edu5,R.drawable.edu6};
    String[] stEduList=getResources().getStringArray(R.array.lvEduList);
    mapAry=new ArrayList<Map<String, Object>>();
    for (int i=0;i<stEduList.length;i++){
     Map<String,Object> item=new HashMap<String, Object>();
     item.put("imgView",icImg[i]);
     item.put("txtView",stEduList[i]);
     mapAry.add(item);
    }
        SimpleAdapter adEduList=new SimpleAdapter(this,mapAry,R.layout.list_item,new String[]{"imgView","txtView"},new int[]{R.id.imgldEdu,R.id.tvldEdu});
setListAdapter(adEduList);
lvEdu=getListView();
lvEdu.setTextFilterEnabled(true);
lvEdu.setOnItemClickListener(lvListener);

    }
    private OnItemClickListener lvListener=new OnItemClickListener(){
        public void onItemClick(AdapterView<?> parent, View view,int postion,long id){
            msg="你的教育程度:\n";
            msg+=((TextView)view.findViewById(R.id.tvldEdu)).getText().toString();
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    };
}
