package assignment.cleancode.editprofile.base;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import assignment.cleancode.editprofile.enums.ViewModelEventsEnum;
import assignment.cleancode.editprofile.interfaces.ViewModelCallBackObserver;
import assignment.cleancode.editprofile.managers.AppManager;
import retrofit2.Call;

/**
 * Created by Munir Ahmad.
 */

public class BaseViewModel extends ObservableViewModel {

    protected List<Call> calls = new ArrayList<>();

    @Inject
    protected AppManager appManager;

    private ArrayList<ViewModelCallBackObserver> callBacksObservers = new ArrayList<>();

    public void addObserver(ViewModelCallBackObserver callBackObserver) {
        this.callBacksObservers.add(callBackObserver);
    }

    public void notifyObserver(ViewModelEventsEnum eventType, Object message) {
        for (ViewModelCallBackObserver callBackObserver : callBacksObservers) {
            callBackObserver.onObserve(eventType, message);
        }
    }

    public void removeCallBacks() {
        callBacksObservers.clear();
    }

    public AppManager getAppManager() {
        return appManager;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        removeCallBacks();
    }

}
