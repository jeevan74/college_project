package com.crrit.crrithandbook.syllabus;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentSyllabus extends Filter {

    ArrayList<ModelCategorySyllabus> filterList;

    AdapterCategoryFacultyandStudentSyllabus adapterCategoryFacultyandStudentSyllabus;

    public FilterCategoryFacultyandStudentSyllabus(ArrayList<ModelCategorySyllabus> filterList, AdapterCategoryFacultyandStudentSyllabus adapterCategoryFacultyandStudentSyllabus) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentSyllabus = adapterCategoryFacultyandStudentSyllabus;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorySyllabus> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentSyllabus.categoryArrayList1 = (ArrayList<ModelCategorySyllabus>)results.values;
        adapterCategoryFacultyandStudentSyllabus.notifyDataSetChanged();
    }
}
