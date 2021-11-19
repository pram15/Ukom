package com.smkrevit.futnest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.smkrevit.futnest.BuktiPemesanan;
import com.smkrevit.futnest.Model.M_Periksa;
import com.smkrevit.futnest.R;

import java.util.List;

public class Periksa_Adapter extends RecyclerView.Adapter<Periksa_Adapter.ViewHolder> {

    private Context context;
    private List<M_Periksa> m_periksaList;

    public Periksa_Adapter(Context context, List<M_Periksa> m_periksaList) {
        this.context = context;
        this.m_periksaList = m_periksaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_periksa, parent, false);

        Periksa_Adapter.ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.btnPeriksa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.getContext().startActivity(new Intent(parent.getContext(), BuktiPemesanan.class));
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        M_Periksa m_periksa = m_periksaList.get(position);

        holder.tvNoLap.setText(m_periksa.getNoLap());
        holder.tvTglPeriksa.setText(m_periksa.getTglPeriksa());
        holder.tvJamPeriksa.setText(m_periksa.getJamPeriksa());

    }

    @Override
    public int getItemCount() {
        return m_periksaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNoLap, tvTglPeriksa, tvJamPeriksa;
        CardView cvPeriksa;
        Button btnPeriksa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNoLap = itemView.findViewById(R.id.tvNoLap);
            tvTglPeriksa = itemView.findViewById(R.id.tvTglPeriksa);
            tvJamPeriksa = itemView.findViewById(R.id.tvJamPeriksa);
            btnPeriksa = itemView.findViewById(R.id.btnPeriksa);
            cvPeriksa = itemView.findViewById(R.id.cvPeriksa);
        }
    }
}
