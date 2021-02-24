package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends AndroidViewModel {
    public MutableLiveData<String> liveData = new MutableLiveData<>();

    public MainViewModel(Application application,String text) {
        super(application);
        new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long p0 = millisUntilFinished/1000;
                liveData.setValue(p0+"");
            }

            @SuppressLint("ShowToast")
            @Override
            public void onFinish() {
                Toast.makeText(application.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

}
