package com.example.ilham_projek_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.ilham_projek_akhir_kba.databinding.ActivityLoginBinding;
import com.example.ilham_projek_akhir_kba.models.login.ResponseLogin;
import com.example.ilham_projek_akhir_kba.network.ApiConfiguration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(go);
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.edEmail.getText().toString().trim();
                String password = binding.edPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    binding.edEmail.setError("Masukan email terlebih dahulu");
                }else if(TextUtils.isEmpty(password)){
                    binding.edPassword.setError("Masukan password terlebih dahulu");
                } else {
                    login(email,password);
                }
            }
        });
    }

    public void login(String email, String password) {
        ApiConfiguration.service.requestLogin(email, password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if(response.isSuccessful()){
                    ResponseLogin responseLogin = response.body();
                    if(responseLogin.isSukses()){
                        Toast.makeText(LoginActivity.this, responseLogin.getPesan(), Toast.LENGTH_SHORT).show();

                        Bundle data = new Bundle();
                        data.putString("email", responseLogin.getDataLogin().getEmail());
                        data.putString("username", responseLogin.getDataLogin().getUsername());

                        Intent go = new Intent(LoginActivity.this, MenuActivity.class);
                        go.putExtras(data);
                        startActivity(go);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, responseLogin.getPesan(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Harap periksa internet anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}