package com.crrit.crrithandbook.users.faculty;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.databinding.ActivitySemMaterialsFacultyBinding;
import com.crrit.crrithandbook.materials.materials11.DashboardFacultyActivitym11;
import com.crrit.crrithandbook.materials.materials12.DashboardFacultyActivitym12;
import com.crrit.crrithandbook.materials.materials21.DashboardFacultyActivitym21;
import com.crrit.crrithandbook.materials.materials22.DashboardFacultyActivitym22;
import com.crrit.crrithandbook.materials.materials31.DashboardFacultyActivitym31;
import com.crrit.crrithandbook.materials.materials32.DashboardFacultyActivitym32;
import com.crrit.crrithandbook.materials.materials41.DashboardFacultyActivitym41;
import com.crrit.crrithandbook.materials.materials42.DashboardFacultyActivitym42;

public class SemMaterialsActivityFaculty extends AppCompatActivity {
    private ActivitySemMaterialsFacultyBinding binding;
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
        binding = ActivitySemMaterialsFacultyBinding.inflate(getLayoutInflater());
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
                startActivity(new Intent(SemMaterialsActivityFaculty.this, DashboardFacultyActivitym11.class));
            }
        });

        binding.Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SemMaterialsActivityFaculty.this, DashboardFacultyActivitym12.class));
            }
        });


        binding.Btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SemMaterialsActivityFaculty.this, DashboardFacultyActivitym21.class));
            }
        });

        binding.Btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityFaculty.this, DashboardFacultyActivitym22.class));
            }
        });

        binding.Btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityFaculty.this, DashboardFacultyActivitym31.class));
            }
        });


        binding.Btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SemMaterialsActivityFaculty.this, DashboardFacultyActivitym32.class));
            }
        });

        binding.Btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(SemMaterialsActivityFaculty.this, DashboardFacultyActivitym41.class));
            }
        });

        binding.Btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SemMaterialsActivityFaculty.this, DashboardFacultyActivitym42.class));
            }
        });

    }
}