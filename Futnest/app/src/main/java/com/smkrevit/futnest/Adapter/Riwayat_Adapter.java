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
import com.smkrevit.futnest.Model.DataLapangan;
import com.smkrevit.futnest.R;
import com.smkrevit.futnest.Model.Riwayat;
import com.smkrevit.futnest.hal_detail;

import java.util.List;

public class Riwayat_Adapter extends RecyclerView.Adapter<Riwayat_Adapter.ViewHolder>{

    private List<Riwayat> mOrderList;
    Context context;

    public Riwayat_Adapter(List<Riwayat> OrderList) {
        this.mOrderList = OrderList;
    }

    @NonNull
    @Override
    public Riwayat_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list__riwayat, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvNama.setText(mOrderList.get(i).getNama());
        viewHolder.tvAlamat.setText(mOrderList.get(i).getAlamat());
        viewHolder.tvTanggal.setText(mOrderList.get(i).getTglorder());
        viewHolder.tvJam.setText(mOrderList.get(i).getAlamat());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BuktiPemesanan.class);
                intent.putExtra("Nama",mOrderList.get(i).getNama());
                intent.putExtra("NamaLapBukti",mOrderList.get(i).getTglorder());
                intent.putExtra("NoTelpBukti",mOrderList.get(i).getNama());
                intent.putExtra("tgldanjam",mOrderList.get(i).getAlamat());
                intent.putExtra("TipeLapangan",mOrderList.get(i).getAlamat());
                intent.putExtra("Alamat",mOrderList.get(i).getNama());
                intent.putExtra("NoTelpPemilik",mOrderList.get(i).getTglorder());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNama, tvAlamat, tvTanggal, tvJam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamatLapangan);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
            tvJam = itemView.findViewById(R.id.tvJam);
        }
    }

}
