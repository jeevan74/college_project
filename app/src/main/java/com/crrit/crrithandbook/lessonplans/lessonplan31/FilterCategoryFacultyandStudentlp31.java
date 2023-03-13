package com.crrit.crrithandbook.lessonplans.lessonplan31;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp31;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentlp31 extends Filter {

    ArrayList<ModelCategorylp31> filterList;

    AdapterCategoryFacultyandStudentlp31 adapterCategoryFacultyandStudentlp31;

    public FilterCategoryFacultyandStudentlp31(ArrayList<ModelCategorylp31> filterList, AdapterCategoryFacultyandStudentlp31 adapterCategoryFacultyandStudentlp31) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentlp31 = adapterCategoryFacultyandStudentlp31;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp31> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentlp31.categoryArrayList1 = (ArrayList<ModelCategorylp31>)results.values;
        adapterCategoryFacultyandStudentlp31.notifyDataSetChanged();
    }
}
