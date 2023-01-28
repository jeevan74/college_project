package com.crrit.crrithandbook.lessonplans.lessonplan12;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentlp12 extends Filter {

    ArrayList<ModelCategorylp12> filterList;

    AdapterCategoryFacultyandStudentlp12 adapterCategoryFacultyandStudentlp12;

    public FilterCategoryFacultyandStudentlp12(ArrayList<ModelCategorylp12> filterList, AdapterCategoryFacultyandStudentlp12 adapterCategoryFacultyandStudentlp12) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentlp12 = adapterCategoryFacultyandStudentlp12;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp12> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentlp12.categoryArrayList1 = (ArrayList<ModelCategorylp12>)results.values;
        adapterCategoryFacultyandStudentlp12.notifyDataSetChanged();
    }
}
