package com.crrit.crrithandbook.timetables;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudenttt12 extends Filter {

    ArrayList<ModelCategorytt12> filterList;

    AdapterCategoryFacultyandStudenttt12 adapterCategoryFacultyandStudenttt12;

    public FilterCategoryFacultyandStudenttt12(ArrayList<ModelCategorytt12> filterList, AdapterCategoryFacultyandStudenttt12 adapterCategoryFacultyandStudenttt12) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudenttt12 = adapterCategoryFacultyandStudenttt12;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorytt12> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudenttt12.categoryArrayList1 = (ArrayList<ModelCategorytt12>)results.values;
        adapterCategoryFacultyandStudenttt12.notifyDataSetChanged();
    }
}
