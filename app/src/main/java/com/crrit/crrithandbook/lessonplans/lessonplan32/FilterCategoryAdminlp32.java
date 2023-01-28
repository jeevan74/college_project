package com.crrit.crrithandbook.lessonplans.lessonplan32;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminlp32 extends Filter {
    //array list
    ArrayList<ModelCategorylp32> filterList;
    //adapter
    AdapterCategoryAdminlp32 adapterCategoryAdminlp32;
    //constructor

    public FilterCategoryAdminlp32(ArrayList<ModelCategorylp32> filterList, AdapterCategoryAdminlp32 adapterCategoryAdminlp32) {
        this.filterList = filterList;
        this.adapterCategoryAdminlp32 = adapterCategoryAdminlp32;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp32> filteredModels = new ArrayList<>();
            for (int i=0;i<filterList.size();i++){
                //validate
                if (filterList.get(i).getCategory().toUpperCase().contains(constraint)){
                    //add to filter
                    filteredModels.add(filterList.get(i));
                }
            }

            results.count = filteredModels.size();
            results.values = filteredModels;
        }
        else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        //apply filter

        adapterCategoryAdminlp32.categoryArrayList=(ArrayList<ModelCategorylp32>)results.values;
        //notify changes
        adapterCategoryAdminlp32.notifyDataSetChanged();

    }
}
