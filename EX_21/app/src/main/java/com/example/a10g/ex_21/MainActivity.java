package com.example.a10g.ex_21;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private ImageView imgFront,imgStop,imgPlay,imgPause,imgNext,imgEnd;
private ListView lstMusic;
private TextView txtMusic;
public MediaPlayer mediaPlayer;
String[] songname=new String[]{"greensleeves","mario","songbird","summersong","tradewinds"};
int[] songfile=new int[]{R.raw.greensleeves,R.raw.mario,R.raw.songbird,R.raw.summersong,R.raw.tradewinds};
private int cListItem=0;
private Boolean falgPause=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgFront=findViewById(R.id.imgFront);
        imgStop=findViewById(R.id.imgStop);
        imgPlay=findViewById(R.id.imgPlay);
        imgPause=findViewById(R.id.imgPause);
        imgNext=findViewById(R.id.imgNext);
        imgEnd=findViewById(R.id.imgEnd);
        lstMusic=findViewById(R.id.lstMusic);
        txtMusic=findViewById(R.id.txtMusic);
        imgFront.setOnClickListener(listener);
        imgStop.setOnClickListener(listener);
        imgPause.setOnClickListener(listener);
        imgPlay.setOnClickListener(listener);
        imgNext.setOnClickListener(listener);
        imgEnd.setOnClickListener(listener);
        lstMusic.setOnItemClickListener(lstListener);
        mediaPlayer=new MediaPlayer();
        ArrayAdapter<String> adaSong=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songname);
        lstMusic.setAdapter(adaSong);
    }
    private ImageView.OnClickListener listener= new ImageView.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.imgFront:
                    frontSong();
                    break;
                case R.id.imgStop:
                    if (mediaPlayer.isPlaying()){
                        mediaPlayer.reset();
                    }
                    break;
                case R.id.imgPlay:
                    if (falgPause){
                        mediaPlayer.start();
                        falgPause=false;

                    }else
                        playSong(songfile[cListItem]);
                    break;
                case R.id.imgPause:
                    mediaPlayer.pause();
                    falgPause=true;
                    break;
                case R.id.imgNext:
                    nextSong();
                    break;
                case R.id.imgEnd:
                    mediaPlayer.release();
                    finish();
                    break;
            }
        }
    };
    private ListView.OnItemClickListener lstListener= new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            cListItem=position;
            playSong(songfile[cListItem]);
        }
    };
    private void playSong(int song){
        mediaPlayer.reset();
        mediaPlayer=MediaPlayer.create(MainActivity.this, song);
        mediaPlayer.start();
        txtMusic.setText("歌名:"+songname[cListItem]);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer arg0) {
                nextSong();
            }
        });
        falgPause=false;
    }
    private void nextSong(){
        cListItem++;
        if (cListItem>=lstMusic.getCount())
            cListItem=0;
        playSong(songfile[cListItem]);
    }
    private void frontSong(){
        cListItem--;
        if (cListItem<0)
            cListItem=lstMusic.getCount()-1;
        playSong(songfile[cListItem]);
    }
}
