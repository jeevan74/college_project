package com.crrit.crrithandbook.lessonplans.lessonplan32;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp32;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentlp32 extends Filter {

    ArrayList<ModelCategorylp32> filterList;

    AdapterCategoryFacultyandStudentlp32 adapterCategoryFacultyandStudentlp32;

    public FilterCategoryFacultyandStudentlp32(ArrayList<ModelCategorylp32> filterList, AdapterCategoryFacultyandStudentlp32 adapterCategoryFacultyandStudentlp32) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentlp32 = adapterCategoryFacultyandStudentlp32;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp32> filterModels = new ArrayList<>();
            for(int i=0;i<filterList.size();i++){
                if (filterList.get(i).getCategory().toUpperCase().contains(constraint)){
                    filterModels.add(filterList.get(i));

                }
            }

            results.count = filterModels.size();
            results.values = filterModels;
        }
        else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults results) {
        adapterCategoryFacultyandStudentlp32.categoryArrayList1 = (ArrayList<ModelCategorylp32>)results.values;
        adapterCategoryFacultyandStudentlp32.notifyDataSetChanged();
    }
}
