package com.example.examlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final Boolean           D = true;
    private final String            TAG = "MainActivity"; //프로젝트명이나 액티비티명

    private ListView                dataLST;

    // List 관련
    private String[]                arrDatas={"AA","BB","CC","DD"};
    private ArrayAdapter<String>    adapter;

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
        arrDatas = this.getResources().getStringArray(R.array.fruits);  //array는 getStringArray..

        //List 생성
        adapter = new ArrayAdapter<String>(this, 
                                            android.R.layout.simple_list_item_1, 
                                            arrDatas); //ArrayAdapter 더블 클릭 후 우클릭  Go To - implement해서 클릭하면 어떤 식으로 작성할 수 있는지 볼 수 있음.
                                                       // simple_list_items1은 우리가 id 만든게 아님
        // ListView에 List 설정
        dataLST.setAdapter(adapter);
        // ListView Item 클릭 이벤트 설정
        dataLST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView dataTXT = ((TextView)view.findViewById(android.R.id.text1)); //simple_list_itme_1의 textView id임
                dataTXT.setText("클릭! 변경되었음");
                //여기서는 Toast에 그냥 this하면 에러, MainActivity.this라고 써줘야함
                Toast.makeText(MainActivity.this, "Text: "+(((TextView)view).getText())+", position: "+position + ", id: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}