package com.neesia.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText emailedittext;
    private EditText passedittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //metode ini dipanggil ketika activity dimulai
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailedittext = (EditText) findViewById(R.id.txtusername);
        passedittext = (EditText) findViewById(R.id.txtpassword);
    }

    public void checkLogin(View arg0){
        final String email = emailedittext.getText().toString();
        if (!isValidEmail (email)){
            emailedittext.setError("Email Tidak Valid!");
        }
        final String pass = passedittext.getText().toString();
        if (!isValidPassword (pass)){
            passedittext.setError("Password tidak boleh kosong / harus lebih atau sama dengan 4 karakter");
        }
        if (isValidEmail(email) && isValidPassword(pass)){
            Toast.makeText(getApplicationContext(), "Anda berhasil Login!",Toast.LENGTH_LONG).show();
            Intent menu = new Intent(MainActivity.this, menu.class);
            startActivity(menu);
        }
    }

    public boolean isValidPassword (String password){
        if (password != null && password.length()>=4){
            return true;
        }
        return false;
    }

    public boolean isValidEmail (String email){
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
