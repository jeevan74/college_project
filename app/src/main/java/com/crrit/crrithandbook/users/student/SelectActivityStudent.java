package com.crrit.crrithandbook.users.student;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.constants.MainActivity;
import com.crrit.crrithandbook.databinding.ActivitySelectStudentBinding;
import com.crrit.crrithandbook.syllabus.DashboardStudentActivitySyllabus;
import com.crrit.crrithandbook.timetables.DashboardStudentActivitytt12;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SelectActivityStudent extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private ActivitySelectStudentBinding binding;

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
        binding = ActivitySelectStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        firebaseAuth = FirebaseAuth.getInstance();

//        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                firebaseAuth.signOut();
//                checkUser();
//            }
//        });

        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });

        binding.CV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivityStudent.this, DashboardStudentActivitySyllabus.class));
            }
        });


        binding.CV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivityStudent.this, SemMaterialsActivityStudent.class));
            }
        });

        binding.CV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(SelectActivityStudent.this, SemLabsStudentActivity.class));
            }
        });

        binding.CV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivityStudent.this, SemLessonplansStudentActivity.class));
            }
        });
        binding.CV5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivityStudent.this, DashboardStudentActivitytt12.class));
            }
        });
    }

    private void logOut() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SelectActivityStudent.this);
        builder.setTitle("Logout")
                .setMessage("Are you sure you want to Logout")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        firebaseAuth.signOut();
                        checkUser();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }


    private void checkUser() {
        //get current user
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser==null){
            //not login goto main screen
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        else {
            //logged in ,get user info
            // String email = firebaseUser.getEmail();
            //set in text view of toolbar
            //binding.subTitleTv.setText(email);
        }
    }
}