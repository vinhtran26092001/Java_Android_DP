package com.example.tranquangvinh_android43_buoi5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tranquangvinh_android43_buoi5.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity implements ILogin{
    ActivityLoginBinding binding;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        loginPresenter = new LoginPresenter(this);

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUsername.getText().toString();
                String pass = binding.etPassword.getText().toString();

                loginPresenter.onLogin(username,pass);
            }
        });
    }


    @Override
    public void changeActivity(Class Order) {
        Intent intent =new Intent(getBaseContext(),Order);
        startActivity(intent);
    }

    @Override
    public void OnLoginSuccessfull(String mess) {
        Toast.makeText(getBaseContext(),mess,Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnLoginError(String mess) {
        Toast.makeText(getBaseContext(),mess,Toast.LENGTH_LONG).show();
    }
}