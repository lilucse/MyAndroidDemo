package com.example.userlogin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import presenter.UserPresenter;
import view.IUserView;

import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements IUserView,View.OnClickListener{
    private UserPresenter userPresenter;
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignUp;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnSignUp = findViewById(R.id.btn_signUp);
        tvResult = findViewById(R.id.tv_result);

        btnSignUp.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        userPresenter = new UserPresenter(this);

    }
    @Override
    public void onLoginSuccess() {
        Toast.makeText(LoginActivity.this,"login success",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLoginFailed(String error) {
        Toast.makeText(LoginActivity.this,"login fail:"+error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess(){
        Toast.makeText(LoginActivity.this,"sign up success",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onSignUpFailed(String error){
        Toast.makeText(LoginActivity.this,"sign up fail:"+error,Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onClick(View v){
        String username = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        switch (v.getId()){
            case R.id.btn_login:
                userPresenter.login(getApplicationContext(),username,password);
                break;
            case R.id.btn_signUp:
                userPresenter.signUp(getApplicationContext(),username,password);
                break;
            default:
            }
     }

     public void setResult(String result){
        tvResult.setText(result);
     }

}





