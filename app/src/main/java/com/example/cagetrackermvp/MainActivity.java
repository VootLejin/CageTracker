package com.example.cagetrackermvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableRow;

import CageManagementSystem.CageModel;
import CageManagementSystem.DomainFacade;
import CageManagementSystem.FerretKeeperContracts.DepositCageInPlayAreaResponse;
import CageManagementSystem.PlayAreaModel;

public class MainActivity extends AppCompatActivity {


    CageDisplayLayout cageDisplayLayout;
    CageDisplayTable displayTable;


    private DomainFacade _domainFacade = new DomainFacade();
    private int _testNumberOfCages = 16;
    private int _testNumberOfPlayAreas = 1;
    public PlayAreaModel myPlayArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        displayTable = findViewById(R.id.tableDisplay);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        InitializeCageTable();
        InitializePlayAreas();
    }

    private void InitializePlayAreas() {
        for(int i = 0; i < _testNumberOfPlayAreas; i++){
            myPlayArea = _domainFacade.CreatePlayArea();
        }
    }

    private void InitializeCageTable() {

        for(int i = 0; i < _testNumberOfCages; i++){
            CageModel cage = _domainFacade.CreateCage();
            cageDisplayLayout = new CageDisplayLayout(this, cage);
            SetupOnClickForCageLayout(cageDisplayLayout);
            displayTable.addCageDisplay(cageDisplayLayout);
        }
    }

    private void SetupOnClickForCageLayout(CageDisplayLayout cageDisplayLayout) {
        cageDisplayLayout.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CageDisplayLayout cageDisplay = (CageDisplayLayout) v;

            if(cageDisplay.cageModel.hasGoneOutToday){

                 _domainFacade.PikcupCageFromPlayArea(cageDisplay.cageModel, myPlayArea);
            }
            DepositCageInPlayAreaResponse response = _domainFacade.DepositCageInPlayArea(cageDisplay.cageModel, myPlayArea);

            DialogFragment ferretFragment = new FerretBookPlayAreaDiaglogFragment(response, cageDisplay.cageModel);
            ferretFragment.show(getSupportFragmentManager(), "ferretAlert");
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
