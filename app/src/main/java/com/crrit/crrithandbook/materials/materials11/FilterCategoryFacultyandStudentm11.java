package com.crrit.crrithandbook.materials.materials11;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentm11 extends Filter {

    ArrayList<ModelCategorym11> filterList;

    AdapterCategoryFacultyandStudentm11 adapterCategoryFacultyandStudentm11;

    public FilterCategoryFacultyandStudentm11(ArrayList<ModelCategorym11> filterList, AdapterCategoryFacultyandStudentm11 adapterCategoryFacultyandStudentm11) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentm11 = adapterCategoryFacultyandStudentm11;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym11> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentm11.categoryArrayList1 = (ArrayList<ModelCategorym11>)results.values;
        adapterCategoryFacultyandStudentm11.notifyDataSetChanged();
    }
}
