package com.smkrevit.futnest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smkrevit.futnest.R;
import com.smkrevit.futnest.Penyewa;

import java.util.List;

public class Penyewa_Adapter extends RecyclerView.Adapter<Penyewa_Adapter.ViewHolder> {

    private Context context;
    private List<Penyewa> penyewaList;

    public Penyewa_Adapter(Context context, List<Penyewa> penyewaList) {
        this.context = context;
        this.penyewaList = penyewaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_penyewa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Penyewa penyewa =  penyewaList.get(position);
        holder.tvNoLapangan.setText(penyewa.getNoLapangan());
        holder.tvNamaPenyewa.setText(penyewa.getNamaPenyewa());
        holder.tvTglSewa.setText(penyewa.getTglSewa());
        holder.tvJamSewa.setText(penyewa.getJamSewa());
        holder.btnHapus.setText(penyewa.getBtnHapus());
    }

    @Override
    public int getItemCount() {
        return penyewaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNoLapangan, tvNamaPenyewa, tvTglSewa, tvJamSewa, btnHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNoLapangan = itemView.findViewById(R.id.tvNoLapangan);
            tvNamaPenyewa = itemView.findViewById(R.id.tvNamaPenyewa);
            tvTglSewa = itemView.findViewById(R.id.tvTglSewa);
            tvJamSewa = itemView.findViewById(R.id.tvJamSewa);
            btnHapus = itemView.findViewById(R.id.btnHapus);
        }
    }
}
