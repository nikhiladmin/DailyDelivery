package com.daytoday.business.dailydelivery.MainHomeScreen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class BussinessViewModel extends ViewModel {
    private BussinessRepository bussinessRepository;
    private MutableLiveData<List<Bussiness>> liveData = new MutableLiveData<>();

    public BussinessViewModel()
    {
        bussinessRepository = new BussinessRepository();

    }

    public LiveData<List<Bussiness>> getBussiness()
    {
        liveData = bussinessRepository.requestBussiness();
        return liveData;
    }
}