package com.crrit.crrithandbook.lessonplans.lessonplan41;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crrit.crrithandbook.databinding.RowCategoryFacultyAndStudentBinding;
import com.crrit.crrithandbook.models.ModelCategorylp41;

import java.util.ArrayList;


public class AdapterCategoryFacultyandStudentlp41 extends RecyclerView.Adapter<AdapterCategoryFacultyandStudentlp41.HolderCategory>implements Filterable {

    private final Context context;
    public ArrayList<ModelCategorylp41> categoryArrayList1,filterList;

    private RowCategoryFacultyAndStudentBinding binding;

    private FilterCategoryFacultyandStudentlp41 filter;

    public AdapterCategoryFacultyandStudentlp41(Context context, ArrayList<ModelCategorylp41> categoryArrayList) {
        this.context = context;
        this.categoryArrayList1 = categoryArrayList;
        this.filterList = categoryArrayList;
    }

    @NonNull
    @Override
    public HolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //bind
        binding = RowCategoryFacultyAndStudentBinding.inflate(LayoutInflater.from(context),parent,false);

        return new HolderCategory(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCategory holder, int position) {
        //get data
        ModelCategorylp41 model = categoryArrayList1.get(position);
        String id = model.getId();
        String category = model.getCategory();
        String uid = model.getUid();
        long timestamp = model.getTimestamp();

        //set data
        holder.categoryTv.setText(category);
        //handel delete click



        //iteam click

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PdfListFacultyandStudentActivitylp41.class);
                intent.putExtra("categoryId",id);
                intent.putExtra("categoryTitle",category);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryArrayList1.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter = new FilterCategoryFacultyandStudentlp41(filterList,this);
        }
        return filter;
    }


    class HolderCategory extends RecyclerView.ViewHolder{

        TextView categoryTv;


        public HolderCategory(@NonNull View itemView) {
            super(itemView);
            //init ui views
            categoryTv = binding.categoryTv;

        }
    }

}
