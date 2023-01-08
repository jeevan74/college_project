package com.crrit.crrithandbook.lessonplans11;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentlp11 extends Filter {

    ArrayList<ModelCategorylp11> filterList;

    AdapterCategoryFacultyandStudentlp11 adapterCategoryFacultyandStudentlp11;

    public FilterCategoryFacultyandStudentlp11(ArrayList<ModelCategorylp11> filterList, AdapterCategoryFacultyandStudentlp11 adapterCategoryFacultyandStudentlp11) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentlp11 = adapterCategoryFacultyandStudentlp11;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp11> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentlp11.categoryArrayList1 = (ArrayList<ModelCategorylp11>)results.values;
        adapterCategoryFacultyandStudentlp11.notifyDataSetChanged();
    }
}
