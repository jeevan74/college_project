package com.crrit.crrithandbook.labs.lab42;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminl42 extends Filter {
    //array list
    ArrayList<ModelCategoryl42> filterList;
    //adapter
    AdapterCategoryAdminl42 adapterCategoryAdminl42;
    //constructor

    public FilterCategoryAdminl42(ArrayList<ModelCategoryl42> filterList, AdapterCategoryAdminl42 adapterCategoryAdminl42) {
        this.filterList = filterList;
        this.adapterCategoryAdminl42 = adapterCategoryAdminl42;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl42> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminl42.categoryArrayList=(ArrayList<ModelCategoryl42>)results.values;
        //notify changes
        adapterCategoryAdminl42.notifyDataSetChanged();

    }
}
