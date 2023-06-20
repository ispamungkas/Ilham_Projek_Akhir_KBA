package com.example.ilham_projek_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.ilham_projek_akhir_kba.databinding.ActivityRegisterBinding;
import com.example.ilham_projek_akhir_kba.models.register.ResponseRegister;
import com.example.ilham_projek_akhir_kba.network.ApiConfiguration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(go);
            }
        });

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.edUsername.getText().toString().trim();
                String email = binding.edEmail.getText().toString().trim();
                String password = binding.edPassword.getText().toString().trim();

                if(TextUtils.isEmpty(username)){
                    binding.edUsername.setError("Masukan username terlebih dahulu");
                } else if (TextUtils.isEmpty(email)){
                    binding.edEmail.setError("Masukan email terlebih dahulu");
                } else if(TextUtils.isEmpty(password)){
                    binding.edPassword.setError("Masukan password terlebih dahulu");
                } else {
                    register(username,email,password);
                }
            }
        });
    }

    private void register(String username, String email, String password) {
        ApiConfiguration.service.requestRegister(username, email, password).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if(response.isSuccessful()){
                    ResponseRegister responseRegister = response.body();
                    if(responseRegister.isSukses()){
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();
                        Intent go = new Intent(RegisterActivity.this, SuccessRegisterActivity.class);
                        startActivity(go);
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Periksa kembali jaringan anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}