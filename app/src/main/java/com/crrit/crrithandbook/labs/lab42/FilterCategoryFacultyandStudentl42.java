package com.crrit.crrithandbook.labs.lab42;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentl42 extends Filter {

    ArrayList<ModelCategoryl42> filterList;

    AdapterCategoryFacultyandStudentl42 adapterCategoryFacultyandStudentl42;

    public FilterCategoryFacultyandStudentl42(ArrayList<ModelCategoryl42> filterList, AdapterCategoryFacultyandStudentl42 adapterCategoryFacultyandStudentl42) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentl42 = adapterCategoryFacultyandStudentl42;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl42> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentl42.categoryArrayList1 = (ArrayList<ModelCategoryl42>)results.values;
        adapterCategoryFacultyandStudentl42.notifyDataSetChanged();
    }
}
