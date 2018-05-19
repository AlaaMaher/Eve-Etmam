package com.alaaetmam.eve.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.alaaetmam.eve.View.Activities.UserCountry;
import com.alaaetmam.eve.View.Activities.ShowMap;

public class MainActivityVM extends BaseObservable {
    private Context context;

    public MainActivityVM(Context context){
        this.context=context;
    }


    public void showMapClick(View v){
        onShowMapClick();
    }
    public void homeVisitClick(View v){
        onHomeVisitClick();
    }

    public void onShowMapClick(){
        Intent intent = new Intent(context.getApplicationContext(), ShowMap.class);
        context.startActivity(intent);

    }
    public void onHomeVisitClick(){
        Intent intent = new Intent(context.getApplicationContext(), UserCountry.class);
        context.startActivity(intent);

    }
}