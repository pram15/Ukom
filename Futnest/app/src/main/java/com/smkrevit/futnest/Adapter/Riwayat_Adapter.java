package com.smkrevit.futnest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smkrevit.futnest.BuktiPemesanan;
import com.smkrevit.futnest.R;
import com.smkrevit.futnest.Riwayat;
import com.smkrevit.futnest.hal_detail;

import java.util.List;

public class Riwayat_Adapter extends RecyclerView.Adapter<Riwayat_Adapter.ViewHolder>{

    private Context context;
    private List<Riwayat> RiwayatList;

    public Riwayat_Adapter(Context context, List<Riwayat> riwayatList) {
        this.context = context;
        this.RiwayatList = riwayatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list__riwayat, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Riwayat riwayat = RiwayatList.get(i);

        viewHolder.tvNama.setText(riwayat.getNama());
        viewHolder.tvAlamat.setText(riwayat.getAlamat());
        viewHolder.tvTanggal.setText(riwayat.getTanggal());
        viewHolder.tvJam.setText(riwayat.getJam());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, riwayat.getNama(), Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, BuktiPemesanan.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return RiwayatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNama, tvAlamat, tvTanggal, tvJam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
            tvJam = itemView.findViewById(R.id.tvJam);
        }
    }

}
