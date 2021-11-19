package com.smkrevit.futnest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smkrevit.futnest.Model.DataLapangan;
import com.smkrevit.futnest.Home;
import com.smkrevit.futnest.R;
import com.smkrevit.futnest.hal_detail;

import java.util.List;

public class LapanganAdapter extends RecyclerView.Adapter<LapanganAdapter.ViewHolder>{

  private List<DataLapangan> mKontakList;
  Context context;

    public LapanganAdapter(List<DataLapangan> KategoriList ) {
        this.mKontakList = KategoriList;
    }


    @Override
    public LapanganAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
      //  final DataLapangan dataLapanganList = dataLapangans[position];
        holder.textTitle.setText(mKontakList.get(position).getNamaLapangan());
        holder.textDesc.setText(mKontakList.get(position).getAlamat());
        Glide.with(holder.itemView.getContext())
                .load("" + mKontakList.get(position).getGambar())
                .into(holder.lapImage);
     //   holder.lapImage.setImageResource(mKontakList.get(position).getImagelap());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), hal_detail.class);
                intent.putExtra("Nama",mKontakList.get(position).getNamaLapangan());
                intent.putExtra("Alamat",mKontakList.get(position).getAlamat());
                intent.putExtra("Jumlah",mKontakList.get(position).getMenu());
                intent.putExtra("Jam",mKontakList.get(position).getJam());
                intent.putExtra("Harga",mKontakList.get(position).getHarga());
                intent.putExtra("TipeLapangan",mKontakList.get(position).getCreatedAt());
                intent.putExtra("LuasLapangan",mKontakList.get(position).getUpdatedAt());
                intent.putExtra("Detail",mKontakList.get(position).getCreatedAt());
                intent.putExtra("gambar",mKontakList.get(position).getGambar());

                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mKontakList.size();
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

