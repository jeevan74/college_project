package com.crrit.crrithandbook.materials.materials41;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorym41;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentm41 extends Filter {

    ArrayList<ModelCategorym41> filterList;

    AdapterCategoryFacultyandStudentm41 adapterCategoryFacultyandStudentm41;

    public FilterCategoryFacultyandStudentm41(ArrayList<ModelCategorym41> filterList, AdapterCategoryFacultyandStudentm41 adapterCategoryFacultyandStudentm41) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentm41 = adapterCategoryFacultyandStudentm41;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym41> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentm41.categoryArrayList1 = (ArrayList<ModelCategorym41>)results.values;
        adapterCategoryFacultyandStudentm41.notifyDataSetChanged();
    }
}
