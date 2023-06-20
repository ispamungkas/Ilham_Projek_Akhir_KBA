package com.example.ilham_projek_akhir_kba.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.ilham_projek_akhir_kba.R;
import com.example.ilham_projek_akhir_kba.databinding.ItemEventHimtiBinding;
import com.example.ilham_projek_akhir_kba.models.event.DataEventHimtiItem;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    List<DataEventHimtiItem> data;

    private OnCLickListener onClickListener;

    boolean toogle;

    public void setToogle(boolean toogle) {
        this.toogle = toogle;
    }

    public EventAdapter(List<DataEventHimtiItem> datalist) {this.data = datalist;};

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemEventHimtiBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        DataEventHimtiItem responseEvent = data.get(position);

        String sample = responseEvent.getTanggal();
        String tanggal = sample.substring(sample.length()-4);

        holder.binding.tvNama.setText(responseEvent.getNamaEvent());
        holder.binding.tvTahunevent.setText(tanggal);
        holder.binding.tvDeskripsi.setText(R.string.description);

        if(toogle) holder.binding.tvDeskripsi.setMaxLines(1); else holder.binding.tvDeskripsi.setMaxLines(10);

        Glide.with(holder.binding.imgEvent)
                .load(responseEvent.getImage())
                .placeholder(R.drawable.loading)
                .into(holder.binding.imgEvent);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener != null){
                    onClickListener.OnClick(toogle);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnClickListener(OnCLickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public interface OnCLickListener {
        void OnClick(boolean now);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemEventHimtiBinding binding;

        public ViewHolder(@NonNull ItemEventHimtiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
