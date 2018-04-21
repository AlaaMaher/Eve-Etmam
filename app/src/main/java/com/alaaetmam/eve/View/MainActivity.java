package com.alaaetmam.eve.View;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alaaetmam.eve.R;
import com.alaaetmam.eve.ViewModel.MainActivityVM;
import com.alaaetmam.eve.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainActivityVM mainActivityVM=new MainActivityVM(this);
        binding.setMainActivityVM(mainActivityVM);


    }
}
