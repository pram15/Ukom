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

import com.smkrevit.futnest.Model.Lapangan_Admin;
import com.smkrevit.futnest.LihatLapanganAdmin;
import com.smkrevit.futnest.R;

import java.util.List;

public class Lapangan_Admin_Adapter extends RecyclerView.Adapter<Lapangan_Admin_Adapter.ViewHolder> {

    private Context context;
    private List<Lapangan_Admin> lapanganAdminList;

    public Lapangan_Admin_Adapter(Context context, List<Lapangan_Admin> lapanganAdminList) {
        this.context = context;
        this.lapanganAdminList = lapanganAdminList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lapangan_admin, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lapangan_Admin lapangan_admin = lapanganAdminList.get(position);
        holder.tvNomerLapangan.setText(lapangan_admin.getNomerLapangan());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, lapangan_admin.getNomerLapangan(), Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, LihatLapanganAdmin.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return lapanganAdminList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNomerLapangan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNomerLapangan = itemView.findViewById(R.id.tvNomerLapangan);
        }
    }
}
