package com.example.ilham_projek_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ilham_projek_akhir_kba.adpater.EventAdapter;
import com.example.ilham_projek_akhir_kba.databinding.ActivityDetailEventBinding;
import com.example.ilham_projek_akhir_kba.models.event.DataEventHimtiItem;
import com.example.ilham_projek_akhir_kba.models.event.ResponseEvent;
import com.example.ilham_projek_akhir_kba.network.ApiConfiguration;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailEventActivity extends AppCompatActivity {

    EventAdapter adapter;
    ActivityDetailEventBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rcView.setHasFixedSize(true);
        binding.rcView.setLayoutManager(new LinearLayoutManager(this));

        ApiConfiguration.service.getEvent().enqueue(new Callback<ResponseEvent>() {
            @Override
            public void onResponse(Call<ResponseEvent> call, Response<ResponseEvent> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        ResponseEvent responseEvent = response.body();
                        List<DataEventHimtiItem> data = responseEvent.getDataEventHimti();
                        adapter = new EventAdapter(data);
                        binding.rcView.setAdapter(adapter);

                        adapter.setOnClickListener(new EventAdapter.OnCLickListener() {
                            @Override
                            public void OnClick(boolean now) {
                                if(now){
                                    adapter.setToogle(!now);
                                }
                            }
                        });
                    } else {
                        Toast.makeText(DetailEventActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(DetailEventActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseEvent> call, Throwable t) {
                Toast.makeText(DetailEventActivity.this, "Harap Cek Internet Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}