package com.crrit.crrithandbook.labs.lab31;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminl31 extends Filter {
    //array list
    ArrayList<ModelCategoryl31> filterList;
    //adapter
    AdapterCategoryAdminl31 adapterCategoryAdminl31;
    //constructor

    public FilterCategoryAdminl31(ArrayList<ModelCategoryl31> filterList, AdapterCategoryAdminl31 adapterCategoryAdminl31) {
        this.filterList = filterList;
        this.adapterCategoryAdminl31 = adapterCategoryAdminl31;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl31> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminl31.categoryArrayList=(ArrayList<ModelCategoryl31>)results.values;
        //notify changes
        adapterCategoryAdminl31.notifyDataSetChanged();

    }
}
