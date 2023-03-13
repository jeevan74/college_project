package com.crrit.crrithandbook.labs.lab12;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl12;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentl12 extends Filter {

    ArrayList<ModelCategoryl12> filterList;

    AdapterCategoryFacultyandStudentl12 adapterCategoryFacultyandStudentl12;

    public FilterCategoryFacultyandStudentl12(ArrayList<ModelCategoryl12> filterList, AdapterCategoryFacultyandStudentl12 adapterCategoryFacultyandStudentl12) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentl12 = adapterCategoryFacultyandStudentl12;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl12> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentl12.categoryArrayList1 = (ArrayList<ModelCategoryl12>)results.values;
        adapterCategoryFacultyandStudentl12.notifyDataSetChanged();
    }
}
