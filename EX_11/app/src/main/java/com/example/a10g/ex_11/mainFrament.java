package com.example.a10g.ex_11;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
public class mainFrament extends Fragment {
    private TextView txtresult,ettotalset,etyouwin,etcomwin,etdraw;
    private ImageView ivcom;
    private ImageButton ibtncloth,ibtnstone,ibtnsci;
    private int totalset=0,youwin=0,comwin=0,draw=0;
    public mainFrament() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmain, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        txtresult=getView().findViewById(R.id.txt_result);
        ivcom=getView().findViewById(R.id.iv_com);
        ibtncloth=getView().findViewById(R.id.ibtn_cloth);
        ibtnsci=getView().findViewById(R.id.ibtn_sci);
        ibtnstone=getView().findViewById(R.id.ibtn_stone);
        ettotalset=getActivity().findViewById(R.id.et_totalset);
        etyouwin=getActivity().findViewById(R.id.et_youwin);
        etcomwin=getActivity().findViewById(R.id.et_comwin);
        etdraw=getActivity().findViewById(R.id.et_draw);
        ibtncloth.setOnClickListener(ibtnclothListener);
        ibtnstone.setOnClickListener(ibtnstoneListener);
        ibtnsci.setOnClickListener(ibtnsciListener);
    }
    private ImageButton.OnClickListener ibtnsciListener= new ImageButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com=(int)(Math.random()*3+1);
                totalset++;
                ettotalset.setText(String.valueOf(totalset));
            if (com==1)
            {
                ivcom.setImageResource(R.drawable.scissors);
                txtresult.setText(getString(R.string.result)+getString(R.string.loss));
                comwin++;
                etcomwin.setText(String.valueOf(comwin));
            }
            else if (com==2)
            {
                ivcom.setImageResource(R.drawable.rock);
                txtresult.setText(getString(R.string.result)+getString(R.string.win));
                youwin++;
                etyouwin.setText(String.valueOf(youwin));
            }
            else
            {
                ivcom.setImageResource(R.drawable.paper);
                txtresult.setText(getString(R.string.result)+getString(R.string.even));
                draw++;
                etdraw.setText(String.valueOf(draw));
            }
        }
    };
    private ImageButton.OnClickListener ibtnstoneListener= new ImageButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com=(int)(Math.random()*3+1);
            totalset++;
            ettotalset.setText(String.valueOf(totalset));
            if (com==1) {
                ivcom.setImageResource(R.drawable.scissors);
                txtresult.setText(getString(R.string.result) + getString(R.string.win));
                youwin++;
                etyouwin.setText(String.valueOf(youwin));
            }
            else if (com==2)
            {
                ivcom.setImageResource(R.drawable.rock);
                txtresult.setText(getString(R.string.result)+getString(R.string.even));
                draw++;
                etdraw.setText(String.valueOf(draw));
            }
            else
            {
                ivcom.setImageResource(R.drawable.paper);
                txtresult.setText(getString(R.string.result)+getString(R.string.loss));
                comwin++;
                etcomwin.setText(String.valueOf(comwin));

            }
        }
    };
    private ImageButton.OnClickListener ibtnclothListener= new ImageButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com=(int)(Math.random()*3+1);
            totalset++;
            ettotalset.setText(String.valueOf(totalset));
            if (com==1)
            {
                ivcom.setImageResource(R.drawable.scissors);
                txtresult.setText(getString(R.string.result)+getString(R.string.even));
                draw++;
                etdraw.setText(String.valueOf(draw));
            }
            else if (com==2)
            {
                ivcom.setImageResource(R.drawable.rock);
                txtresult.setText(getString(R.string.result)+getString(R.string.loss));
                comwin++;
                etcomwin.setText(String.valueOf(comwin));

            }
            else
            {
                ivcom.setImageResource(R.drawable.paper);
                txtresult.setText(getString(R.string.result)+getString(R.string.win));
                youwin++;
                etyouwin.setText(String.valueOf(youwin));
            }
        }
    };
}
