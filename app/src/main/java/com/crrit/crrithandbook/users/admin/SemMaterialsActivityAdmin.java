package com.crrit.crrithandbook.users.admin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.databinding.ActivitySemMaterialsAdminBinding;
import com.crrit.crrithandbook.materials.materials11.DashboardAdminActivitym11;
import com.crrit.crrithandbook.materials.materials12.DashboardAdminActivitym12;
import com.crrit.crrithandbook.materials.materials21.DashboardAdminActivitym21;
import com.crrit.crrithandbook.materials.materials22.DashboardAdminActivitym22;
import com.crrit.crrithandbook.materials.materials31.DashboardAdminActivitym31;
import com.crrit.crrithandbook.materials.materials32.DashboardAdminActivitym32;
import com.crrit.crrithandbook.materials.materials41.DashboardAdminActivitym41;
import com.crrit.crrithandbook.materials.materials42.DashboardAdminActivitym42;

public class SemMaterialsActivityAdmin extends AppCompatActivity {
    private ActivitySemMaterialsAdminBinding binding;

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
        binding = ActivitySemMaterialsAdminBinding.inflate(getLayoutInflater());
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
                startActivity(new Intent(SemMaterialsActivityAdmin.this, DashboardAdminActivitym11.class));
            }
        });

        binding.Btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityAdmin.this, DashboardAdminActivitym12.class));
            }
        });

        binding.Btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityAdmin.this, DashboardAdminActivitym21.class));
            }
        });

        binding.Btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SemMaterialsActivityAdmin.this, DashboardAdminActivitym22.class));
            }
        });

        binding.Btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SemMaterialsActivityAdmin.this, DashboardAdminActivitym31.class));
            }
        });

        binding.Btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SemMaterialsActivityAdmin.this, DashboardAdminActivitym32.class));
            }
        });

        binding.Btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SemMaterialsActivityAdmin.this, DashboardAdminActivitym41.class));
            }
        });

        binding.Btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SemMaterialsActivityAdmin.this, DashboardAdminActivitym42.class));
            }
        });

    }
}