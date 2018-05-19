package com.alaaetmam.eve.View.Fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alaaetmam.eve.Adapters.PersonAdapter1;
import com.alaaetmam.eve.Model.Person;
import com.alaaetmam.eve.R;
import com.alaaetmam.eve.View.Activities.PersonSection;
import com.alaaetmam.eve.WebService.getPersonList.PeopleRequest;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {


    boolean exc = false;

    private RecyclerView recyclerView;
    private PersonAdapter1 personAdapter1;
    private int districtId;
    private Person[] personArray;





    public AllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

          Intent mIntent= getActivity().getIntent();
          districtId=mIntent.getIntExtra("districtId",districtId);


        new  GetPeople().execute();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all, container, false);



//        Bundle bundle = getIntent().getExtras();
//        districtId=bundle.getInt("districtId",districtId);


    }

    public Person[] callPeople(){
        PeopleRequest peopleRequest=new PeopleRequest();
        Person[]people=peopleRequest.GetPeopleEn(districtId);
        return people;
    }



    class GetPeople extends AsyncTask<Void, Void, Void> {

        private final ProgressDialog dialog = new ProgressDialog(getActivity());


        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Loading data");
            this.dialog.show();
        }

        @Override
        protected Void doInBackground(Void... unused) {


            try {


                personArray = callPeople();

            } catch (Exception e) {
                exc = true;
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void result) {

            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (exc) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            } else {
                personRecyclerView();
                exc = false;
            }
        }
        public void personRecyclerView(){


            recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_view_person);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setHasFixedSize(true);


            personAdapter1 = new PersonAdapter1(getActivity(), personArray);
            recyclerView.setAdapter(personAdapter1);



        }
    }


}
