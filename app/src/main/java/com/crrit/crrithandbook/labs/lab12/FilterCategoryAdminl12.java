package com.crrit.crrithandbook.labs.lab12;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminl12 extends Filter {
    //array list
    ArrayList<ModelCategoryl12> filterList;
    //adapter
    AdapterCategoryAdminl12 adapterCategoryAdminl12;
    //constructor

    public FilterCategoryAdminl12(ArrayList<ModelCategoryl12> filterList, AdapterCategoryAdminl12 adapterCategoryAdminl12) {
        this.filterList = filterList;
        this.adapterCategoryAdminl12 = adapterCategoryAdminl12;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl12> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminl12.categoryArrayList=(ArrayList<ModelCategoryl12>)results.values;
        //notify changes
        adapterCategoryAdminl12.notifyDataSetChanged();

    }
}
