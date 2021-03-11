package com.example.examlist;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

//ItemData.java에 선언한 변수들을 item_data.xml과 매칭시켜주는 작업을 하는 Adapter
public class ItemDataAdapter extends ArrayAdapter<ItemData> {   //에러 표시가 나면 Constructor를 생성해야 함.
    // Member Variable --------------------------------------------------
    private Context             context;
    private int                 layoutResId;
    private ArrayList<ItemData> dataList;

    // Constructor Method --------------------------------------------------------------
    public ItemDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ItemData> objects) {  // Adaptere의 역할은 ArrayList<ItemData> objects의 값을 int resource에 맞게끔 그려주는 역할
        super(context, resource, objects);
        this.context = context;
        this.layoutResId = resource;
        this.dataList = objects;

    }

    // Override Method -----------------------------------------------------------------
    //필수로 구현해줘야하는 함수
    //Code- override -getCount(), getView() 두 개 깅거하기
    @Override  //상속 받았는 메서드구나 확인할 수 있도록
    public int getCount() { //전체 항목의 갯수 판단위해 호출
        //기존 코드return super.getCount();
        return dataList.size(); //dataList의 size를 가져오기 위해서
    }


    //화면에 그려주는 함수 getView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) { //getView는 데이터 갯수만큼 돌 것, position은 몇 번째 데이터인지. 첫번째 애와 얘 매칭해서 이거 만들어주세요., 그려주는 View가 convertView. item_data.xml을 java 코드에서 인식할 수 있도록 만든 것이 convertView
        // @Nullable 널일수도 있다, NonNull 절대 Null값이면 안된다. @: 알려주는 것.

        // Data를 XML Layout에 넣어서 보이고 사용할 수 있도록 객체 생성 반환
        //(1)item Layout xml ==> java 객체로 변환
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layoutResId, null);

        // (2) item layout's view 객체 가져오기
        TextView    nameTXT = convertView.findViewById(R.id.nameTXT);
        TextView    phoneTXT = convertView.findViewById(R.id.phoneTXT);
        TextView    addrTXT = convertView.findViewById(R.id.addressTXT);
        ImageView   iconIMG  = convertView.findViewById(R.id.iconIMG);

        // (3) 데이터 준비 - Layout에 들어갈 데이터 가져오기
        final ItemData    item = dataList.get(position);

        // (4) Layout과 Data 연결
        nameTXT.setText(item.getName());
        phoneTXT.setText(item.getPhone());
        addrTXT.setText(item.getAddress());
        iconIMG.setImageResource(item.getImgResId());

        /*
        return super.getView(position, convertView, parent); //만약에 한 줄을 주고 그리라고 했는데 내가 못 그리겠으면 super에서 그려주는 것.
        // java 코드 객체를 xml에서 만들어주는 뷰 convertView가 반환될 것임
        // 내가 처리해줄거면
        */
        return convertView;
    }
}
