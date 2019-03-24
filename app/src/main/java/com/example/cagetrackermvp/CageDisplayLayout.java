package com.example.cagetrackermvp;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import CageManagementSystem.CageModel;

public class CageDisplayLayout extends LinearLayout {

    public CageModel cageModel;
    public ImageView cagePicture;
    public TextView cageName;

    private CageDisplayLayout(Context context) {
        super(context);
    }

    public CageDisplayLayout(Context context, CageModel cage){
        this(context);
        cageModel = cage;
        cagePicture = new ImageView(context);
        cagePicture.setImageDrawable(getResources().getDrawable(
                getResources().getIdentifier(
                        "default_ferret_cage", "drawable",
                        "com.example.cagetrackermvp.")
                )
        );
        cageName = new TextView(context);
        cageName.setText(java.lang.Integer.toString(cageModel.ID));
        

    }
}
