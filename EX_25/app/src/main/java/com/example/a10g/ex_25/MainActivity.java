package com.example.a10g.ex_25;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private MyDB db=null;
Button btnAppend,btnEdit,btnDelete,btnClear;
EditText edtName,edtPrice;
ListView listview01;
Cursor cursor;
long myid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edtName);
        edtPrice=findViewById(R.id.edtPrice);
        listview01=findViewById(R.id.ListView01);
        btnAppend=findViewById(R.id.btnAppend);
        btnClear=findViewById(R.id.btnClear);
        btnDelete=findViewById(R.id.btnDelete);
        btnEdit=findViewById(R.id.btnEdit);
        btnAppend.setOnClickListener(myListener);
        btnEdit.setOnClickListener(myListener);
        btnDelete.setOnClickListener(myListener);
        btnClear.setOnClickListener(myListener);
        listview01.setOnItemClickListener(listview01Listener);
        db=new MyDB(this);
        db.open();
        cursor=db.getAll();
        UpdateAdapter(cursor);
    }
    private ListView.OnItemClickListener listview01Listener= new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ShowData(id);
            cursor.moveToPosition(position);
        }
    };
    private void ShowData(long id){
        Cursor c=db.get(id);
        myid=id;
        edtName.setText(c.getString(1));
        edtPrice.setText(""+c.getInt(2));
    }
    @Override
   protected void onDestroy(){
        super.onDestroy();
        db.close();
    }
    private Button.OnClickListener myListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                switch (v.getId()){
                    case R.id.btnAppend:{
                        int price=Integer.parseInt(edtPrice.getText().toString());
                        String name=edtName.getText().toString();
                        if (db.append(name,price)>0){
                            cursor=db.getAll();
                            UpdateAdapter(cursor);
                            ClearEdit();
                        }
                        break;
                    }case R.id.btnEdit:{
                        int price=Integer.parseInt(edtPrice.getText().toString());
                        String name=edtName.getText().toString();
                        if (db.update(myid,name,price)){
                            cursor=db.getAll();
                            UpdateAdapter(cursor);
                        }
                        break;
                    }case R.id.btnDelete:{
                        if (cursor!=null&&cursor.getCount()>=0){
                            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("確定刪除");
                            builder.setMessage("確定要刪除"+edtName.getText()+"這筆資料?");
                            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {

                                }
                            });
                            builder.setNegativeButton("確定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    if (db.delete(myid)){
                                        cursor=db.getAll();
                                        UpdateAdapter(cursor);
                                        ClearEdit();
                                    }

                                }
                            });
                            builder.show();
                        }
                        break;
                    }case R.id.btnClear:{
                        ClearEdit();
                        break;
                    }
                }
            }catch (Exception err){
                Toast.makeText(getApplicationContext(),"資料不正確!",Toast.LENGTH_SHORT).show();
            }
        }
    };

    public void ClearEdit() {
        edtName.setText("");
        edtPrice.setText("");
    }
    public void UpdateAdapter(Cursor cursor){
        if (cursor!=null&&cursor.getCount()>=0){
            SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[]{"name","price"},
                    new int[]{android.R.id.text1,android.R.id.text2},0);
            listview01.setAdapter(adapter);
        }
    }
    }