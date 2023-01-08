package com.crrit.crrithandbook.materials.materials31;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentm31 extends Filter {

    ArrayList<ModelCategorym31> filterList;

    AdapterCategoryFacultyandStudentm31 adapterCategoryFacultyandStudentm31;

    public FilterCategoryFacultyandStudentm31(ArrayList<ModelCategorym31> filterList, AdapterCategoryFacultyandStudentm31 adapterCategoryFacultyandStudentm31) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentm31 = adapterCategoryFacultyandStudentm31;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym31> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentm31.categoryArrayList1 = (ArrayList<ModelCategorym31>)results.values;
        adapterCategoryFacultyandStudentm31.notifyDataSetChanged();
    }
}
