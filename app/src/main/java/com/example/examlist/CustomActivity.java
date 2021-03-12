package com.example.examlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//
public class CustomActivity extends AppCompatActivity {
    // Member Variable -----------------------------------------------------
    private final boolean       D = true;
    private final String        TAG = "CustomActivity";
    private ListView            dataLST;

    private ArrayList<ItemData>     dataArrays; //data를 저장하기위한 ArrayList
    private ItemDataAdapter         adapter;

    //Member Method - Override ---------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    //Member Method - Custom ------------------------------------------------
    //초기화 함수
    private void init(){
        dataLST = findViewById(R.id.dataLST);

        dataArrays = new ArrayList<ItemData>();
        //임의의 Data 입력
        dataArrays.add( new ItemData("TEST", "010", "Daegu", R.drawable.clock));
        dataArrays.add( new ItemData("KIM", "011", "Jeju", R.drawable.person));

        adapter = new ItemDataAdapter(this, R.layout.item_data, dataArrays); //view랑 data 줌

        dataLST.setAdapter(adapter);

    }

    //클릭하면 로그 출력
    public void itemClick(View v){
         if(D) Log.i(TAG, "itemClick");
        switch (v.getId()){
            case R.id.nameTXT:
            case R.id.phoneTXT:
            case R.id.addressTXT:
                Log.i(TAG, "TEXT => "+((TextView)v).getText());
                break;
            case R.id.iconIMG:
                Log.i(TAG, "image => " + ((ImageView)v).getContentDescription());
                break;
        }
    }


}