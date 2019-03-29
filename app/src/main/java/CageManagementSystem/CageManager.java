package CageManagementSystem;

import java.util.List;
import java.util.Vector;

import CageManagementSystem.FerretKeeperContracts.DepositCageInPlayAreaResponse;

public class CageManager {
    private List<CageModel> _cages;
    private List<PlayAreaModel> _playAreas;
    private int timeToWaitInMinutes = 5;
    private int timeToWaitInSeconds = timeToWaitInMinutes * 60;
    private int timeToWaitInMilliSeconds = timeToWaitInSeconds * 1000;


    CageManager(){
        _cages = new Vector<>();
        _playAreas = new Vector<>();
    }

    public CageManager(List<CageModel> _cages, List<PlayAreaModel> _playAreas) {
        this._cages = _cages;
        this._playAreas = _playAreas;
    }



    public DepositCageInPlayAreaResponse DepositCageInPlayArea(CageModel cage, PlayAreaModel playArea){
        DepositCageInPlayAreaResponse response = new DepositCageInPlayAreaResponse();
        try{
            playArea.OccupyWith(cage);
            response.DepositedSuccessfully = true;
            response.TimeToWaitInSeconds = timeToWaitInSeconds;

        } catch (Exception e){ //TODO Make better exceptions
            response.DepositedSuccessfully = false;
            response.TimeToWaitInSeconds = 0;
        }
        return response;
    }


    public List<PlayAreaModel> GetPlayAreas() {
        return _playAreas;
    }

    public List<CageModel> GetCages(){
        return _cages;
    }

    public void AddCage(CageModel cage) {
        _cages.add(cage);
    }

    public void AddPlayArea(PlayAreaModel playArea) {
        _playAreas.add(playArea);
    }

    public void PickupCageFromPlayArea(CageModel cage, PlayAreaModel playArea) {
        playArea.PickUp(cage);
        
    }

    public void ResetCagesInSystem() {
        for (CageModel cage:_cages) {
            cage.hasGoneOutToday = false;
        }
    }

    public CageModel CreateCage() {
        CageModel newCage = new CageModel(_cages.size());
        AddCage(newCage);
        return newCage;
    }
}
