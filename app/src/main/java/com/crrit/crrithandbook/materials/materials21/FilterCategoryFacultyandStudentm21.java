package com.crrit.crrithandbook.materials.materials21;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentm21 extends Filter {

    ArrayList<ModelCategorym21> filterList;

    AdapterCategoryFacultyandStudentm21 adapterCategoryFacultyandStudentm21;

    public FilterCategoryFacultyandStudentm21(ArrayList<ModelCategorym21> filterList, AdapterCategoryFacultyandStudentm21 adapterCategoryFacultyandStudentm21) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentm21 = adapterCategoryFacultyandStudentm21;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym21> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentm21.categoryArrayList1 = (ArrayList<ModelCategorym21>)results.values;
        adapterCategoryFacultyandStudentm21.notifyDataSetChanged();
    }
}
