package com.crrit.crrithandbook.users.student;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.databinding.ActivitySemMaterialsStudentBinding;
import com.crrit.crrithandbook.materials.materials11.DashboardStudentActivitym11;
import com.crrit.crrithandbook.materials.materials12.DashboardStudentActivitym12;
import com.crrit.crrithandbook.materials.materials21.DashboardStudentActivitym21;
import com.crrit.crrithandbook.materials.materials22.DashboardStudentActivitym22;
import com.crrit.crrithandbook.materials.materials31.DashboardStudentActivitym31;
import com.crrit.crrithandbook.materials.materials32.DashboardStudentActivitym32;
import com.crrit.crrithandbook.materials.materials41.DashboardStudentActivitym41;
import com.crrit.crrithandbook.materials.materials42.DashboardStudentActivitym42;

public class SemMaterialsActivityStudent extends AppCompatActivity {
    private ActivitySemMaterialsStudentBinding binding;

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
        binding=ActivitySemMaterialsStudentBinding.inflate(getLayoutInflater());
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
                startActivity(new Intent(SemMaterialsActivityStudent.this, DashboardStudentActivitym11.class));
            }
        });

        binding.Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityStudent.this, DashboardStudentActivitym12.class));

            }
        });

        binding.Btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityStudent.this, DashboardStudentActivitym21.class));
            }
        });


        binding.Btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityStudent.this, DashboardStudentActivitym22.class));
            }
        });

        binding.Btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityStudent.this, DashboardStudentActivitym32.class));
            }
        });

        binding.Btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityStudent.this, DashboardStudentActivitym31.class));
            }
        });

        binding.Btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityStudent.this, DashboardStudentActivitym41.class));
            }
        });

        binding.Btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityStudent.this, DashboardStudentActivitym42.class));
            }
        });
    }
}