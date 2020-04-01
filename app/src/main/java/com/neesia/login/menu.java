package com.neesia.login;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    private Button profil;
    private Button kegiatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        profil = findViewById(R.id.btnprofil);
        kegiatan = findViewById(R.id.btnkegiatan);

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(menu.this, profil.class);
                startActivity(profil);
            }
        });

        kegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent kegiatan = new Intent(menu.this, kegiatan.class);
                startActivity(kegiatan);
            }
        });
    }

}
