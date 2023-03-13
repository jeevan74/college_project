package com.crrit.crrithandbook.materials.materials42;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorym42;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentm42 extends Filter {

    ArrayList<ModelCategorym42> filterList;

    AdapterCategoryFacultyandStudentm42 adapterCategoryFacultyandStudentm42;

    public FilterCategoryFacultyandStudentm42(ArrayList<ModelCategorym42> filterList, AdapterCategoryFacultyandStudentm42 adapterCategoryFacultyandStudentm42) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentm42 = adapterCategoryFacultyandStudentm42;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym42> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentm42.categoryArrayList1 = (ArrayList<ModelCategorym42>)results.values;
        adapterCategoryFacultyandStudentm42.notifyDataSetChanged();
    }
}
