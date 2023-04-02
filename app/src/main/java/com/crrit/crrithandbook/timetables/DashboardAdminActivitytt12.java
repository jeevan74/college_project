package com.crrit.crrithandbook.timetables;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.crrit.crrithandbook.R;
import com.crrit.crrithandbook.constants.MainActivity;
import com.crrit.crrithandbook.databinding.ActivityDashboardAdminTt12Binding;
import com.crrit.crrithandbook.models.ModelCategorytt12;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashboardAdminActivitytt12 extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private ActivityDashboardAdminTt12Binding binding;

    private ArrayList<ModelCategorytt12> categoryArrayList;
    //adapter
    private AdapterCategoryAdmintt12 adapterCategoryAdmintt12;

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
        binding = ActivityDashboardAdminTt12Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();
        loadCategories();

        //edit text change
        binding.searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //call when user type
                try {
                    adapterCategoryAdmintt12.getFilter().filter(s);

                }catch (Exception e){

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //handle click logout
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        //handle click,start category add screen
        binding.addCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardAdminActivitytt12.this, CategoryAddActivitytt12.class));
            }
        });

        //handle click,start pdf add screen
        binding.addPdfFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardAdminActivitytt12.this, PdfAddActivitytt12.class));
            }
        });

    }

    private void loadCategories() {
        //init arraylist
        categoryArrayList = new ArrayList<>();

        //get all labs from DB
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Timetable12");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                categoryArrayList.clear();
                for (DataSnapshot ds: snapshot.getChildren()){
                    //get data
                    ModelCategorytt12 model = ds.getValue(ModelCategorytt12.class);

                    //add to arraylist
                    categoryArrayList.add(model);

                }
                //setup adapter
                adapterCategoryAdmintt12 = new AdapterCategoryAdmintt12(DashboardAdminActivitytt12.this,categoryArrayList);
                //set adapter to recycler view
                binding.categoryRv.setAdapter(adapterCategoryAdmintt12);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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
            //String email = firebaseUser.getEmail();
            //set in text view of toolbar
            //binding.subTitleTv.setText(email);
        }
    }
}