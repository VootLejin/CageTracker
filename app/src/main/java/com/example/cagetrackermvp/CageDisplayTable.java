package com.example.cagetrackermvp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Vector;

public class CageDisplayTable extends TableLayout {

    public Vector<CageDisplayLayout> cageDisplays = new Vector<>();

    private Vector<TableRow> rows = new Vector<>();
    final private int  RowWidthMax = 3;
    private int currentRowIndex = 0;

    public CageDisplayTable(Context context) {
        super(context);
    }

    public CageDisplayTable (Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public void addCageDisplay(CageDisplayLayout cageDisplay){
        addDisplayToRows(cageDisplay);
        cageDisplays.add(cageDisplay);
    }

    private void addDisplayToRows(CageDisplayLayout cageDisplay) {
        if (rows.isEmpty() || currentRowIndex == 0){
            TableRow newRow = new TableRow(getContext());
            rows.add(newRow);
            this.addView(newRow);
        }

        TableRow newRow = rows.lastElement();
        newRow.addView(cageDisplay);
        currentRowIndex++;
        if(currentRowIndex >= RowWidthMax){
            currentRowIndex = 0;
        }


    }

}
