package com.alaaetmam.eve.View.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaaetmam.eve.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MakupFragment extends Fragment {


    public MakupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_makup, container, false);
    }

}
