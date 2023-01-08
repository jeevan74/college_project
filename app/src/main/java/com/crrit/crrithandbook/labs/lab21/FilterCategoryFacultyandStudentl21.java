package com.crrit.crrithandbook.labs.lab21;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentl21 extends Filter {

    ArrayList<ModelCategoryl21> filterList;

    AdapterCategoryFacultyandStudentl21 adapterCategoryFacultyandStudentl21;

    public FilterCategoryFacultyandStudentl21(ArrayList<ModelCategoryl21> filterList, AdapterCategoryFacultyandStudentl21 adapterCategoryFacultyandStudentl21) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentl21 = adapterCategoryFacultyandStudentl21;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl21> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentl21.categoryArrayList1 = (ArrayList<ModelCategoryl21>)results.values;
        adapterCategoryFacultyandStudentl21.notifyDataSetChanged();
    }
}
