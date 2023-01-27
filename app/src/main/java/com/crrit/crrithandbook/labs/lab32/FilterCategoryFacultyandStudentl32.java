package com.crrit.crrithandbook.labs.lab32;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentl32 extends Filter {

    ArrayList<ModelCategoryl32> filterList;

    AdapterCategoryFacultyandStudentl32 adapterCategoryFacultyandStudentl32;

    public FilterCategoryFacultyandStudentl32(ArrayList<ModelCategoryl32> filterList, AdapterCategoryFacultyandStudentl32 adapterCategoryFacultyandStudentl32) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentl32 = adapterCategoryFacultyandStudentl32;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl32> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentl32.categoryArrayList1 = (ArrayList<ModelCategoryl32>)results.values;
        adapterCategoryFacultyandStudentl32.notifyDataSetChanged();
    }
}
