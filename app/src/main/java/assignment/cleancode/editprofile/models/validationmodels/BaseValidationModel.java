package assignment.cleancode.editprofile.models.validationmodels;


import androidx.databinding.BaseObservable;
import androidx.room.Ignore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Munir Ahmad on 07/09/19.
 */


public class BaseValidationModel extends BaseObservable {


    @Ignore
    protected HashMap<String,Boolean> validationMap = new HashMap<>();

    public void validate(){
        validationMap.clear();
    }

    public boolean isValid()
    {
        Iterator<Map.Entry<String,Boolean>> it = validationMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String,Boolean> pair = it.next();
            if(!pair.getValue()){
                return false;
            }
        }
        return true;
    }
}
