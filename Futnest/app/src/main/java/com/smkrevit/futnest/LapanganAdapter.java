package com.smkrevit.futnest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LapanganAdapter extends RecyclerView.Adapter<LapanganAdapter.ViewHolder>{

    DataLapangan[] dataLapangans;
    Context context;

    public LapanganAdapter(DataLapangan[] dataLapangans,Home activity) {
        this.dataLapangans = dataLapangans;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataLapangan dataLapanganList = dataLapangans[position];
        holder.textTitle.setText(dataLapanganList.getNamaLapangan());
        holder.textDesc.setText(dataLapanganList.getDeskripsi());
        holder.lapImage.setImageResource(dataLapanganList.getImagelap());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, dataLapanganList.getNamaLapangan(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataLapangans.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView lapImage;
        TextView textTitle;
        TextView textDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lapImage = itemView.findViewById(R.id.lapImage);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDesc = itemView.findViewById(R.id.textDesc);

        }
    }

}
