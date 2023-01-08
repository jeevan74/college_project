package com.crrit.crrithandbook.users.faculty;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.databinding.ActivitySemLabsFacultyBinding;
import com.crrit.crrithandbook.labs.lab11.DashboardFacultyActivityl11;
import com.crrit.crrithandbook.labs.lab12.DashboardFacultyActivityl12;
import com.crrit.crrithandbook.labs.lab21.DashboardFacultyActivityl21;
import com.crrit.crrithandbook.labs.lab22.DashboardFacultyActivityl22;
import com.crrit.crrithandbook.labs.lab31.DashboardFacultyActivityl31;
import com.crrit.crrithandbook.labs.lab41.DashboardFacultyActivityl41;
import com.crrit.crrithandbook.labs.lab42.DashboardFacultyActivityl42;

public class SemLabsFacultyActivity extends AppCompatActivity {

    private ActivitySemLabsFacultyBinding binding;

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
        binding = ActivitySemLabsFacultyBinding.inflate(getLayoutInflater());
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
                startActivity(new Intent(SemLabsFacultyActivity.this, DashboardFacultyActivityl11.class));
            }
        });

        binding.Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsFacultyActivity.this, DashboardFacultyActivityl12.class));
            }
        });

        binding.Btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsFacultyActivity.this, DashboardFacultyActivityl21.class));
            }
        });

        binding.Btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsFacultyActivity.this, DashboardFacultyActivityl22.class));
            }
        });

        binding.Btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsFacultyActivity.this, DashboardFacultyActivityl31.class));
            }
        });

        binding.Btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsFacultyActivity.this, DashboardFacultyActivityl41.class));
            }
        });

        binding.Btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsFacultyActivity.this, DashboardFacultyActivityl42.class));
            }
        });

    }
}