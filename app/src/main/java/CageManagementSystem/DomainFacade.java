package CageManagementSystem;

import java.util.List;

import CageManagementSystem.FerretKeeperContracts.DepositCageInPlayAreaResponse;

public class DomainFacade {

    private CageManager _cageManager = new CageManager();

    public List<CageModel> GetCageList(){
        return _cageManager.GetCages();
    }

    public List<PlayAreaModel> GetPlayAreaList(){
        return _cageManager.GetPlayAreas();
    }

    public DepositCageInPlayAreaResponse DepositCageInPlayArea(CageModel cage, PlayAreaModel playArea){
        return _cageManager.DepositCageInPlayArea(cage, playArea);
    }

    public void PikcupCageFromPlayArea(CageModel cage, PlayAreaModel playArea){
        _cageManager.PickupCageFromPlayArea(cage, playArea);
    }

    public void AddCageToSystem(CageModel cage){
        _cageManager.AddCage(cage);
    }

    public void AddPlayArea(PlayAreaModel playArea){
        _cageManager.AddPlayArea(playArea);
    }

    public void ResetCagesInSystem(){
        _cageManager.ResetCagesInSystem();
    }

    public void RemovePlayArea(PlayAreaModel playArea){

    }
    public void BookPlayAreaForAdoption(PlayAreaModel playArea){

    }
    public void FreeUpPlayAreaFromAdoption(PlayAreaModel playArea){

    }

    public CageModel CreateCage(){
        return _cageManager.CreateCage();
    }
    public PlayAreaModel CreatePlayArea(){ return _cageManager.CreatePlayArea();}

}
