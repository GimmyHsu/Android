package com.example.a10g.ex_8;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
private TextView txtedu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    txtedu=findViewById(R.id.txt_Result);
        ArrayAdapter<CharSequence>adapteredu=
                ArrayAdapter.createFromResource( this,R.array.edu,android.R.layout.simple_list_item_1);
        setListAdapter(adapteredu);
        ListView lst=getListView();
        lst.setOnItemClickListener(lstvieweduListener);

    }
    private ListView.OnItemClickListener lstvieweduListener= new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            txtedu.setText("你的教育程度是:"+((TextView) view).getText());
        }
    };

}
