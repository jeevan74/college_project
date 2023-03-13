package com.crrit.crrithandbook.labs.lab41;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl41;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentl41 extends Filter {

    ArrayList<ModelCategoryl41> filterList;

    AdapterCategoryFacultyandStudentl41 adapterCategoryFacultyandStudentl41;

    public FilterCategoryFacultyandStudentl41(ArrayList<ModelCategoryl41> filterList, AdapterCategoryFacultyandStudentl41 adapterCategoryFacultyandStudentl41) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentl41 = adapterCategoryFacultyandStudentl41;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl41> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentl41.categoryArrayList1 = (ArrayList<ModelCategoryl41>)results.values;
        adapterCategoryFacultyandStudentl41.notifyDataSetChanged();
    }
}
