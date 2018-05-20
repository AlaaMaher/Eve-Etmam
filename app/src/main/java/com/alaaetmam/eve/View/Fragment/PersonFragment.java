package com.alaaetmam.eve.View.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alaaetmam.eve.Adapters.ImagesAdapter;
import com.alaaetmam.eve.Adapters.PersonAdapter1;
import com.alaaetmam.eve.Adapters.ServiceAdapter;
import com.alaaetmam.eve.Model.Names;
import com.alaaetmam.eve.Model.Person;
import com.alaaetmam.eve.R;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    private TextView personName;
    private RecyclerView personService;
    private RatingBar rate;
    private ImageView logo;
    private ViewPager mPager;
    private CircleIndicator indicator;
    private Names[] serviceArray;
    private ServiceAdapter serviceAdapter;
    private String[] images;
    private ImagesAdapter imagesAdapter;
    private static int currentPage = 0;

    private Person person;



    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       inflater= getActivity().getLayoutInflater();
        View view =  inflater.inflate(R.layout.fragment_person, container, false);
        // Inflate the layout for this fragment



        Intent mIntent= getActivity().getIntent();
        person= (Person) mIntent.getSerializableExtra("Person");


        personName = (TextView) view.findViewById(R.id.text_name_);
        personService = (RecyclerView) view.findViewById(R.id.text_service_details);
        rate = (RatingBar) view.findViewById(R.id.rating_bar_details);
        logo = (ImageView) view.findViewById(R.id.person_logo_details);
        mPager = (ViewPager) view.findViewById(R.id.pager_f);
        indicator= (CircleIndicator) view.findViewById(R.id.indicator_details);

        personName.setText(person.getFullName());
        rate.setRating(person.getStars());
        String imageUrl = person.getPersonProfile();

        Picasso.with(getActivity()).load(imageUrl).resize(50, 50).into(logo);

        serviceArray=person.getServices();
        personService.setLayoutManager(new LinearLayoutManager(getActivity()));
        personService.setHasFixedSize(true);

        serviceAdapter= new ServiceAdapter(getActivity(), serviceArray);
        personService.setAdapter(serviceAdapter);



        images=person.getImages();

        imagesAdapter=new ImagesAdapter(getActivity(),images);
        mPager.setAdapter(imagesAdapter);
        indicator.setViewPager(mPager);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);



        return view;
    }

}
