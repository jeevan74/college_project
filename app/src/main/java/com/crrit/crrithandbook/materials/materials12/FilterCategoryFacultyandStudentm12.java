package com.crrit.crrithandbook.materials.materials12;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorym12;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentm12 extends Filter {

    ArrayList<ModelCategorym12> filterList;

    AdapterCategoryFacultyandStudentm12 adapterCategoryFacultyandStudentm12;

    public FilterCategoryFacultyandStudentm12(ArrayList<ModelCategorym12> filterList, AdapterCategoryFacultyandStudentm12 adapterCategoryFacultyandStudentm12) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentm12 = adapterCategoryFacultyandStudentm12;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym12> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentm12.categoryArrayList1 = (ArrayList<ModelCategorym12>)results.values;
        adapterCategoryFacultyandStudentm12.notifyDataSetChanged();
    }
}
