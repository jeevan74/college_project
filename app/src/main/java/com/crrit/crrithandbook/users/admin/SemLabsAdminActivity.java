package com.crrit.crrithandbook.users.admin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.databinding.ActivitySemLabsAdminBinding;
import com.crrit.crrithandbook.labs.lab32.DashboardAdminActivityl32;
import com.crrit.crrithandbook.labs.lab11.DashboardAdminActivityl11;
import com.crrit.crrithandbook.labs.lab12.DashboardAdminActivityl12;
import com.crrit.crrithandbook.labs.lab21.DashboardAdminActivityl21;
import com.crrit.crrithandbook.labs.lab22.DashboardAdminActivityl22;
import com.crrit.crrithandbook.labs.lab31.DashboardAdminActivityl31;
import com.crrit.crrithandbook.labs.lab41.DashboardAdminActivityl41;
import com.crrit.crrithandbook.labs.lab42.DashboardAdminActivityl42;

public class SemLabsAdminActivity extends AppCompatActivity {
    private ActivitySemLabsAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.primary));
            // window.setNavigationBarColor(this.getResources().getColor(R.color.blue));
        }

        super.onCreate(savedInstanceState);
        binding = ActivitySemLabsAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        binding.Btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsAdminActivity.this, DashboardAdminActivityl11.class));
            }
        });

        binding.Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsAdminActivity.this, DashboardAdminActivityl12.class));
            }
        });

        binding.Btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsAdminActivity.this, DashboardAdminActivityl21.class));
            }
        });

        binding.Btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsAdminActivity.this, DashboardAdminActivityl22.class));
            }
        });

        binding.Btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsAdminActivity.this, DashboardAdminActivityl31.class));
            }
        });

        binding.Btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsAdminActivity.this, DashboardAdminActivityl32.class));
            }
        });

        binding.Btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsAdminActivity.this, DashboardAdminActivityl41.class));
            }
        });

        binding.Btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsAdminActivity.this, DashboardAdminActivityl42.class));
            }
        });
    }
}