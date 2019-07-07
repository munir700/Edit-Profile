package assignment.cleancode.editprofile.interfaces;


import assignment.cleancode.editprofile.enums.ViewModelEventsEnum;

public interface ViewModelCallBackObserver<T> {

    void onObserve(ViewModelEventsEnum event, T eventMessage);

}
