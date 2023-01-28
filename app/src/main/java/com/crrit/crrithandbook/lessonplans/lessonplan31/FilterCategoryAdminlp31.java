package com.crrit.crrithandbook.lessonplans.lessonplan31;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminlp31 extends Filter {
    //array list
    ArrayList<ModelCategorylp31> filterList;
    //adapter
    AdapterCategoryAdminlp31 adapterCategoryAdminlp31;
    //constructor

    public FilterCategoryAdminlp31(ArrayList<ModelCategorylp31> filterList, AdapterCategoryAdminlp31 adapterCategoryAdminlp31) {
        this.filterList = filterList;
        this.adapterCategoryAdminlp31 = adapterCategoryAdminlp31;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp31> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminlp31.categoryArrayList=(ArrayList<ModelCategorylp31>)results.values;
        //notify changes
        adapterCategoryAdminlp31.notifyDataSetChanged();

    }
}
