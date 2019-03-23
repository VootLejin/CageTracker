package CageManagementSystem;

public class PlayAreaModel {
    public boolean busy = false;

    public void OccupyWith(CageModel cage){
        busy = true;
        cage.hasGoneOutToday = true;

    }

    public void PickUp(CageModel cage) {
        busy = false;
        cage.hasGoneOutToday = true;
    }
}
