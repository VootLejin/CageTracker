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
    }


    public CageDisplayLayout(Context context, CageModel cage){
        this(context);
        _textHolder = new LinearLayout(context);
        _textHolder.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        cageModel = cage;
        cagePicture = new ImageView(context);
        cagePicture.setImageResource(R.drawable.ferretcage);
        cagePicture.setLayoutParams(new LayoutParams(_testWidth, _testWidth));

        cageName = new TextView(context);
        cageName.setText(java.lang.Integer.toString(cageModel.ID));

        lastOutView = new TextView(context);
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.ENGLISH);
        lastOutView.setText(sdf.format(cageModel.lastGoneOut));
        lastOutView.setGravity(Gravity.RIGHT);


        this.setOrientation(LinearLayout.VERTICAL);

        this.addView(cagePicture);
        _textHolder.addView(cageName);
        _textHolder.addView(lastOutView);

        this.addView(_textHolder);

    }
}
