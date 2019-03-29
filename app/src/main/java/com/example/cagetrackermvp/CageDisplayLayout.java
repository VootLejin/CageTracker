package com.example.cagetrackermvp;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import CageManagementSystem.CageModel;

public class CageDisplayLayout extends LinearLayout {

    public CageModel cageModel;
    public ImageView cagePicture;
    public TextView cageName;
    public TextView lastOutView;
    private LinearLayout _textHolder;

    private int _testWidth = 350;

    private CageDisplayLayout(Context context) {
        super(context);
        //setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }


    public CageDisplayLayout(Context context, CageModel cage){
        this(context);
        setPadding(10, 0, 10, 0);

        _textHolder = new LinearLayout(context);
        _textHolder.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        _textHolder.setPadding(20,0,20,0);

        cageModel = cage;
        cagePicture = new ImageView(context);
        cagePicture.setImageResource(R.drawable.ferretcage);
        cagePicture.setLayoutParams(new LayoutParams(_testWidth, _testWidth));

        cageName = new TextView(context);
        String idText = "ID: " + java.lang.Integer.toString(cageModel.ID);
        cageName.setText(idText);

        lastOutView = new TextView(context);
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.ENGLISH);
        String lastOutText = sdf.format(cageModel.lastGoneOut);
        lastOutView.setText(lastOutText);

        lastOutView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        lastOutView.setGravity(Gravity.RIGHT);


        this.setOrientation(LinearLayout.VERTICAL);

        this.addView(cagePicture);
        _textHolder.addView(cageName);
        _textHolder.addView(lastOutView);

        this.addView(_textHolder);

    }
}
