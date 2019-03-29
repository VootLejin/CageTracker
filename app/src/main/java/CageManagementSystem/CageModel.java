package CageManagementSystem;

import java.util.Date;

public class CageModel {
    public int ID;
    public boolean hasGoneOutToday;
    public Date lastGoneOut = new Date(0);

    public CageModel(int id){
        ID = id;
        hasGoneOutToday = false;

    }

    public CageModel(int id, Date lastOut){
        ID = id;
        hasGoneOutToday = false;
        lastGoneOut = lastOut;
    }

}
