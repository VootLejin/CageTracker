package com.example.cagetrackermvp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import CageManagementSystem.CageModel;
import CageManagementSystem.FerretKeeperContracts.DepositCageInPlayAreaResponse;

public class FerretBookPlayAreaDiaglogFragment extends DialogFragment {

    private DepositCageInPlayAreaResponse _response;
    private CageModel _cageModel;

    public FerretBookPlayAreaDiaglogFragment(){

    }

    /*
    public static FerretBookPlayAreaDiaglogFragment NewInstance(DepositCageInPlayAreaResponse response, CageModel cage){
        FerretBookPlayAreaDiaglogFragment fragment = new FerretBookPlayAreaDiaglogFragment();
        Bundle args = new Bundle();
        args.putInt("cage_ID", cage.ID);
        args.putInt("timeToWait", response.TimeToWaitInSeconds);
        fragment.setArguments(args);

        return fragment;


    }
    */

    public FerretBookPlayAreaDiaglogFragment (DepositCageInPlayAreaResponse response, CageModel cageModel){
        super();
        _cageModel = cageModel;
        _response = response;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //System.out.println(savedInstanceState.toString());
        super.onCreateDialog(savedInstanceState);

        int Id = _cageModel.ID;
        int timeToWaitInSeconds = _response.TimeToWaitInSeconds;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Ferret cage: " + String.valueOf(Id) +
                "\nWill wait: " + String.valueOf(timeToWaitInSeconds) + "seconds.");
        builder.setPositiveButton(R.string.ok_message, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                dialog.dismiss();
            }
        });


        AlertDialog dialog = builder.create();

        return dialog;
    }


}
