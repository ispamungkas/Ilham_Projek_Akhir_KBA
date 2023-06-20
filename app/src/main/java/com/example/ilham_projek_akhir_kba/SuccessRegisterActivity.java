package com.example.ilham_projek_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ilham_projek_akhir_kba.databinding.ActivitySuccessRegisterBinding;

public class SuccessRegisterActivity extends AppCompatActivity {

    ActivitySuccessRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuccessRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(SuccessRegisterActivity.this, LoginActivity.class);
                startActivity(go);
                finish();
            }
        });
    }
}