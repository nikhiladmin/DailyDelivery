package com.daytoday.business.dailydelivery.MainHomeScreen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class EmployeeViewModel extends ViewModel {
    private EmployeeRepo employeeRepo;
    private MutableLiveData<List<EmployeeInfo>> liveData = new MutableLiveData<>();

    public EmployeeViewModel(){
        employeeRepo = new EmployeeRepo();
    }

    /*-------------------------------          Observe on this Function    --------------------------------------------------*/
    public LiveData<List<EmployeeInfo>> getEmployee(){
        liveData = employeeRepo.requestEmployee();
        return liveData;
    }
}
