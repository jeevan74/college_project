package com.crrit.crrithandbook.users.admin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.lessonplans.lessonplan42.DashboardAdminActivitylp42;
import com.crrit.crrithandbook.lessonplans.lessonplan41.DashboardAdminActivitylp41;
import com.crrit.crrithandbook.lessonplans.lessonplan32.DashboardAdminActivitylp32;
import com.crrit.crrithandbook.lessonplans.lessonplan31.DashboardAdminActivitylp31;
import com.crrit.crrithandbook.lessonplans.lessonplan22.DashboardAdminActivitylp22;
import com.crrit.crrithandbook.lessonplans.lessonplan21.DashboardAdminActivitylp21;
import com.crrit.crrithandbook.lessonplans.lessonplan12.DashboardAdminActivitylp12;
import com.crrit.crrithandbook.lessonplans.lessonplan11.DashboardAdminActivitylp11;
import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.databinding.ActivitySemLessonplansAdminBinding;


public class SemLessonplansAdminActivity extends AppCompatActivity {
    private ActivitySemLessonplansAdminBinding binding;

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
        binding = ActivitySemLessonplansAdminBinding.inflate(getLayoutInflater());
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
                startActivity(new Intent(SemLessonplansAdminActivity.this, DashboardAdminActivitylp11.class));
            }
        });

        binding.Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansAdminActivity.this, DashboardAdminActivitylp12.class));
            }
        });

        binding.Btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansAdminActivity.this, DashboardAdminActivitylp21.class));
            }
        });
        binding.Btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansAdminActivity.this, DashboardAdminActivitylp22.class));
            }
        });

        binding.Btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansAdminActivity.this, DashboardAdminActivitylp31.class));
            }
        });
        binding.Btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansAdminActivity.this, DashboardAdminActivitylp32.class));
            }
        });
        binding.Btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansAdminActivity.this, DashboardAdminActivitylp41.class));
            }
        });
        binding.Btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansAdminActivity.this, DashboardAdminActivitylp42.class));
            }
        });
    }
}