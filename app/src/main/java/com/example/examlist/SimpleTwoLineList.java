package com.example.examlist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleTwoLineList extends AppCompatActivity {
    private final Boolean           D = true;
    private final String            TAG = "SimpleTwoLineList"; //프로젝트명이나 액티비티명

    //View object 관련
    private ListView                dataLST;

    // List 관련
    private ArrayList<HashMap<String, String>>       arrDatas;  //Map 중에서 암호화할 수 있는 HashMap. type은 String 두 개
    private SimpleAdapter           adapter;

    //private InputMethodManager imm;

    //Member Method - Activity's Override -----------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();

        if(D) Log.i(TAG, "onCreate() OK");
    }

    //Member Method - Custom ---------------------------------
    // App 초기화 메서드
    private void init(){
        dataLST = findViewById(R.id.dataLST);
        //ListView에 List 설정. 설정을 한다고하면 무조건 .set으로 시작!

        //List 데이터 준비
        arrDatas = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Hong");
        map.put("area", "Daegu");
        arrDatas.add(map);

        map = new HashMap<>();
        map.put("name", "LeeD");
        map.put("area", "Busan");
        arrDatas.add(map);


        //List 생성 및 관리 Adapter
        adapter = new SimpleAdapter(SimpleTwoLineList.this, arrDatas, R.layout.simple, new String[]{"name", "area"}, new int[]{R.id.text1, R.id.text2});
        //SimpleAdpater(이 액티비티에, 데이터를, 어떤 형식의 레이아웃에, 어떤 데이터를, 어디에다 넣을 것인지)

        // ListView에 List 설정
        dataLST.setAdapter(adapter);

        // ListView Item 클릭 이벤트 설정
        dataLST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TextView가 두 개라 이렇게 적으면 안된다. 찾아야함
                //Toast.makeText(twoLineList.this, "Text: "+(((TextView)view).getText())+", position: "+position + ", id: " + id, Toast.LENGTH_SHORT).show();
                //Toast.makeText(SimpleTwoLineList.this, "Text: "+ ((TextView)findViewById(R.id.text2)).getText()+", position: "+position + ", id: " + id, Toast.LENGTH_SHORT).show();
                Toast.makeText(SimpleTwoLineList.this, "Name: "+ ((TextView)findViewById(R.id.text1)).getText() + ", area: "+ ((TextView)findViewById(R.id.text2)).getText()+", position: "+position + ", id: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }

}