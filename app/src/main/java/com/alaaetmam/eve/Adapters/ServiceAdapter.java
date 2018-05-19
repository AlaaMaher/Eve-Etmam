package com.alaaetmam.eve.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alaaetmam.eve.Model.Names;
import com.alaaetmam.eve.Model.Person;
import com.alaaetmam.eve.R;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MyViewHolder>{


    private Context mContext;
    private Names[] services ;

    public ServiceAdapter(Context mContext, Names[] services){
        this.mContext=mContext;
        this.services=services;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_item, parent, false);
        return new MyViewHolder(itemView);
    }




    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.personServices.setText(services[position].getName());

    }





        @Override
    public int getItemCount() {
        return services.length;

    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView personServices;


        public MyViewHolder(View view) {
            super(view);

            personServices = (TextView) view.findViewById(R.id.service_name);

            view.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();




        }


        }


    }
