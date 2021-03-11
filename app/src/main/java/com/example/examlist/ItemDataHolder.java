package com.example.examlist;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//ListView item 표시해주는 XML Layout을 Java Object(객체)로 만들어서 저장해놓는 것. 매번 파싱하긴 어려우니.
public class ItemDataHolder {
    public ImageView iconIMG;
    public TextView nameTXT;
    public TextView phoneTXT;
    public TextView addressTXT;

    public ItemDataHolder(View root) {
        this.iconIMG = root.findViewById(R.id.iconIMG);
        this.nameTXT = root.findViewById(R.id.nameTXT);
        this.phoneTXT = root.findViewById(R.id.phoneTXT);
        this.addressTXT = root.findViewById(R.id.addressTXT);
    }
}
