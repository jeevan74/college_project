package com.crrit.crrithandbook.labs.lab11;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentl11 extends Filter {

    ArrayList<ModelCategoryl11> filterList;

    AdapterCategoryFacultyandStudentl11 adapterCategoryFacultyandStudentl11;

    public FilterCategoryFacultyandStudentl11(ArrayList<ModelCategoryl11> filterList, AdapterCategoryFacultyandStudentl11 adapterCategoryFacultyandStudentl11) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentl11 = adapterCategoryFacultyandStudentl11;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl11> filterModels = new ArrayList<>();
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
        adapterCategoryFacultyandStudentl11.categoryArrayList1 = (ArrayList<ModelCategoryl11>)results.values;
        adapterCategoryFacultyandStudentl11.notifyDataSetChanged();
    }
}
