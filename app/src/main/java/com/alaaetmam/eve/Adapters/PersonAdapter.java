package com.alaaetmam.eve.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alaaetmam.eve.Model.Names;
import com.alaaetmam.eve.Model.Person;
import com.alaaetmam.eve.R;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder>{

    private Context mContext;
    private Person[] personList ;
    private Names[] serviceList;
    private ServiceAdapter serviceAdapter;
    private String[] images;
    private ImagesAdapter imagesAdapter;
    private Person person;




    private static int currentPage = 0;
    private  String[] XMEN;


    public PersonAdapter(Context mContext,Person[] personList){
        this.mContext=mContext;
        this.personList=personList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        serviceList=personList[position].getServices();
        holder.personService.setLayoutManager(new LinearLayoutManager(mContext));
        holder.personService.setHasFixedSize(true);
        serviceAdapter= new ServiceAdapter(mContext, serviceList);
        holder.personService.setAdapter(serviceAdapter);





        holder.personName.setText(personList[position].getFullName());
      //  holder.personService.setText(String.valueOf(personList[position].getServices()[serviceList.length].getName()));

       // holder.personService.(String.valueOf(personList[position].getServices()));
        holder.rate.setRating((float) personList[position].getStars());
        String imageUrl = personList[position].getPersonProfile();

        Picasso.with(mContext).load(imageUrl).resize(50, 50).into(holder.logo);



        images=personList[position].getImages();

//
//            for(int i=0;i<images.length;i++)
//                XMEN[i]=images[i];
        imagesAdapter=new ImagesAdapter(mContext,images);
        holder.mPager.setAdapter(imagesAdapter);
        holder.indicator.setViewPager(holder.mPager);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                holder.mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);




    }




    @Override
    public int getItemCount() {
        return personList.length;

    }








    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView personName;
        private RecyclerView personService;
        private RatingBar rate;
        private ImageView logo;
        private ViewPager mPager;
        private CircleIndicator indicator;

        public MyViewHolder(View view) {
            super(view);
            personName = (TextView) view.findViewById(R.id.text_name);
            personService = (RecyclerView) view.findViewById(R.id.text_service);
            logo = (ImageView) view.findViewById(R.id.person_logo);
            rate = (RatingBar) view.findViewById(R.id.rating_bar);
            mPager = (ViewPager) view.findViewById(R.id.pager);
            indicator= (CircleIndicator) view.findViewById(R.id.indicator);


            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            person=personList[position];





//
//            Intent intent = new Intent(mContext, PersonSectionDetails.class);
//            intent.putExtra("Person", person);
//            mContext.startActivity(intent);

            //  Toast.makeText(mContext," company id "+containerSizesList.get(position).getId(),Toast.LENGTH_SHORT).show();
//            Intent intent=new Intent(mContext, Company_Detail.class);
//            intent.putExtra("PersonID",personList.get(position).getId());
//            mContext.startActivity(intent);

        }
    }

}
