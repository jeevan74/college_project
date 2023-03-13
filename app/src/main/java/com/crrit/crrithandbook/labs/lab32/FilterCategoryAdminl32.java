package com.crrit.crrithandbook.labs.lab32;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl32;

import java.util.ArrayList;

public class FilterCategoryAdminl32 extends Filter {
    //array list
    ArrayList<ModelCategoryl32> filterList;
    //adapter
    AdapterCategoryAdminl32 adapterCategoryAdminl32;
    //constructor

    public FilterCategoryAdminl32(ArrayList<ModelCategoryl32> filterList, AdapterCategoryAdminl32 adapterCategoryAdminl32) {
        this.filterList = filterList;
        this.adapterCategoryAdminl32 = adapterCategoryAdminl32;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl32> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminl32.categoryArrayList=(ArrayList<ModelCategoryl32>)results.values;
        //notify changes
        adapterCategoryAdminl32.notifyDataSetChanged();

    }
}
