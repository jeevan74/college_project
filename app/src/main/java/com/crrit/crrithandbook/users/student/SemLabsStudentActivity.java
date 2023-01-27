package com.crrit.crrithandbook.users.student;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.DashboardStudentActivityl32;
import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.databinding.ActivitySemLabsStudentBinding;
import com.crrit.crrithandbook.labs.lab11.DashboardStudentActivityl11;
import com.crrit.crrithandbook.labs.lab12.DashboardStudentActivityl12;
import com.crrit.crrithandbook.labs.lab21.DashboardStudentActivityl21;
import com.crrit.crrithandbook.labs.lab22.DashboardStudentActivityl22;
import com.crrit.crrithandbook.labs.lab31.DashboardStudentActivityl31;
import com.crrit.crrithandbook.labs.lab41.DashboardStudentActivityl41;
import com.crrit.crrithandbook.labs.lab42.DashboardStudentActivityl42;

public class SemLabsStudentActivity extends AppCompatActivity {
    private ActivitySemLabsStudentBinding binding;
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
        binding=ActivitySemLabsStudentBinding.inflate(getLayoutInflater());
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
                startActivity(new Intent(SemLabsStudentActivity.this, DashboardStudentActivityl11.class));
            }
        });

        binding.Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsStudentActivity.this, DashboardStudentActivityl12.class));
            }
        });

        binding.Btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsStudentActivity.this, DashboardStudentActivityl21.class));
            }
        });
        binding.Btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsStudentActivity.this, DashboardStudentActivityl22.class));
            }
        });

        binding.Btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsStudentActivity.this, DashboardStudentActivityl31.class));
            }
        });

        binding.Btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsStudentActivity.this, DashboardStudentActivityl32.class));
            }
        });

        binding.Btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsStudentActivity.this, DashboardStudentActivityl41.class));
            }
        });
        binding.Btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLabsStudentActivity.this, DashboardStudentActivityl42.class));
            }
        });
    }
}