package com.crrit.crrithandbook.labs.lab22;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentl22 extends Filter {

    ArrayList<ModelCategoryl22> filterList;

    AdapterCategoryFacultyandStudentl22 adapterCategoryFacultyandStudentl22;

    public FilterCategoryFacultyandStudentl22(ArrayList<ModelCategoryl22> filterList, AdapterCategoryFacultyandStudentl22 adapterCategoryFacultyandStudentl22) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentl22 = adapterCategoryFacultyandStudentl22;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl22> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentl22.categoryArrayList1 = (ArrayList<ModelCategoryl22>)results.values;
        adapterCategoryFacultyandStudentl22.notifyDataSetChanged();
    }
}
