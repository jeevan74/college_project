package com.crrit.crrithandbook.users.student;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.lessonplans.lessonplan42.DashboardStudentActivitylp42;
import com.crrit.crrithandbook.lessonplans.lessonplan41.DashboardStudentActivitylp41;
import com.crrit.crrithandbook.lessonplans.lessonplan32.DashboardStudentActivitylp32;
import com.crrit.crrithandbook.lessonplans.lessonplan31.DashboardStudentActivitylp31;
import com.crrit.crrithandbook.lessonplans.lessonplan22.DashboardStudentActivitylp22;
import com.crrit.crrithandbook.lessonplans.lessonplan21.DashboardStudentActivitylp21;
import com.crrit.crrithandbook.lessonplans.lessonplan12.DashboardStudentActivitylp12;
import com.crrit.crrithandbook.lessonplans.lessonplan11.DashboardStudentActivitylp11;
import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.databinding.ActivitySemLessonplansStudentBinding;


public class SemLessonplansStudentActivity extends AppCompatActivity {
    private ActivitySemLessonplansStudentBinding binding;

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
        binding = ActivitySemLessonplansStudentBinding.inflate(getLayoutInflater());
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
                startActivity(new Intent(SemLessonplansStudentActivity.this, DashboardStudentActivitylp11.class));
            }
        });

        binding.Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansStudentActivity.this, DashboardStudentActivitylp12.class));
            }
        });

        binding.Btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansStudentActivity.this, DashboardStudentActivitylp21.class));
            }
        });
        binding.Btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansStudentActivity.this, DashboardStudentActivitylp22.class));
            }
        });
        binding.Btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansStudentActivity.this, DashboardStudentActivitylp31.class));
            }
        });
        binding.Btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansStudentActivity.this, DashboardStudentActivitylp32.class));
            }
        });
        binding.Btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansStudentActivity.this, DashboardStudentActivitylp41.class));
            }
        });
        binding.Btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemLessonplansStudentActivity.this, DashboardStudentActivitylp42.class));
            }
        });
    }
}