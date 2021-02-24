package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private TextView timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Application application = getApplication();
        viewModel = new ViewModelProvider(this, new MainFactory(application,"Factory")).get(MainViewModel.class);
        timer = findViewById(R.id.timer);

    }
    @Override
    protected void onStart(){
        super.onStart();
        viewModel.liveData.observe(this, s -> timer.setText(s));
    }
}