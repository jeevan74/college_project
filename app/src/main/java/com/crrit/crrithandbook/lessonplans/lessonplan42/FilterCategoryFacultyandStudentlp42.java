package com.crrit.crrithandbook.lessonplans.lessonplan42;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp42;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentlp42 extends Filter {

    ArrayList<ModelCategorylp42> filterList;

    AdapterCategoryFacultyandStudentlp42 adapterCategoryFacultyandStudentlp42;

    public FilterCategoryFacultyandStudentlp42(ArrayList<ModelCategorylp42> filterList, AdapterCategoryFacultyandStudentlp42 adapterCategoryFacultyandStudentlp42) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentlp42 = adapterCategoryFacultyandStudentlp42;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp42> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentlp42.categoryArrayList1 = (ArrayList<ModelCategorylp42>)results.values;
        adapterCategoryFacultyandStudentlp42.notifyDataSetChanged();
    }
}
