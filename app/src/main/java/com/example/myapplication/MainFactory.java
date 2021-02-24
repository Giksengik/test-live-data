package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import org.jetbrains.annotations.NotNull;

public class MainFactory extends ViewModelProvider.AndroidViewModelFactory {
    private String text;
    Application application;
    public MainFactory(@NonNull Application application,String text) {
        super(application);
        this.text = text;
        this.application = application;
    }
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
       return (T) new MainViewModel(application,text);
    }
}
