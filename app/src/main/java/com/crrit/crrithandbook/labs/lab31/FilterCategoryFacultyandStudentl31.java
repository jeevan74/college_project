package com.crrit.crrithandbook.labs.lab31;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl31;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentl31 extends Filter {

    ArrayList<ModelCategoryl31> filterList;

    AdapterCategoryFacultyandStudentl31 adapterCategoryFacultyandStudentl31;

    public FilterCategoryFacultyandStudentl31(ArrayList<ModelCategoryl31> filterList, AdapterCategoryFacultyandStudentl31 adapterCategoryFacultyandStudentl31) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentl31 = adapterCategoryFacultyandStudentl31;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl31> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentl31.categoryArrayList1 = (ArrayList<ModelCategoryl31>)results.values;
        adapterCategoryFacultyandStudentl31.notifyDataSetChanged();
    }
}
