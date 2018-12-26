package com.example.a10g.ex_23;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
private SQLiteDatabase db=null;
private final static String CREAT_TABLE="CREATE TABLE table01(_id INTEGER PRIMARY KEY,num INTERGER,data TEXT)";
ListView listview01;
Button btnDo;
EditText edtSQL;
String str,itemdata;
int n=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview01=findViewById(R.id.ListView01);
        btnDo=findViewById(R.id.btnDo);
        edtSQL=findViewById(R.id.edtSOL);
        btnDo.setOnClickListener(btnDoClick);
        itemdata="資料項目"+n;
        str="INSERT INTO table01 (num,data) values ("+n+",'"+itemdata+"')";
        edtSQL.setText(str);
        db=openOrCreateDatabase("db1.db",MODE_PRIVATE,null);
        try {
            db.execSQL(CREAT_TABLE);

        }catch (Exception e){
            UpdateAdapter();
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        db.execSQL("DROP TABLE table01");
        db.close();
    }
    private Button.OnClickListener btnDoClick= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                db.execSQL(edtSQL.getText().toString());
                UpdateAdapter();
                n++;
                itemdata="資料項目"+n;
                str="INSERT INTO table01 (num,data) values ("+n+",'"+itemdata+"')";
                edtSQL.setText(str);
                setTitle("資料新增完畢!");
            }catch (Exception err){
                setTitle("SQL 與法錯誤!");
            }
        }
    };

    public void UpdateAdapter() {
        Cursor cursor=db.rawQuery("SELECT * FROM table01",null);//*是所有的欄位
        if (cursor != null && cursor.getCount()>=0){
            SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,new String[]{"num","data"},new int[]{android.R.id.text1,android.R.id.text2},0);
listview01.setAdapter(adapter);

       }
            }
}
