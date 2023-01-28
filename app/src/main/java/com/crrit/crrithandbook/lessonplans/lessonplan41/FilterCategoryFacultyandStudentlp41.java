package com.crrit.crrithandbook.lessonplans.lessonplan41;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentlp41 extends Filter {

    ArrayList<ModelCategorylp41> filterList;

    AdapterCategoryFacultyandStudentlp41 adapterCategoryFacultyandStudentlp41;

    public FilterCategoryFacultyandStudentlp41(ArrayList<ModelCategorylp41> filterList, AdapterCategoryFacultyandStudentlp41 adapterCategoryFacultyandStudentlp41) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentlp41 = adapterCategoryFacultyandStudentlp41;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp41> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentlp41.categoryArrayList1 = (ArrayList<ModelCategorylp41>)results.values;
        adapterCategoryFacultyandStudentlp41.notifyDataSetChanged();
    }
}
