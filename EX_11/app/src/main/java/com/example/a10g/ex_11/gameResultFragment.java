package com.example.a10g.ex_11;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
public class gameResultFragment extends Fragment {
    public gameResultFragment(){

    }
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragegameresult,container,false);
    }
}
