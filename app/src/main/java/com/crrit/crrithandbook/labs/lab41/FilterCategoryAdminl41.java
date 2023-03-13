package com.crrit.crrithandbook.labs.lab41;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl41;

import java.util.ArrayList;

public class FilterCategoryAdminl41 extends Filter {
    //array list
    ArrayList<ModelCategoryl41> filterList;
    //adapter
    AdapterCategoryAdminl41 adapterCategoryAdminl41;
    //constructor

    public FilterCategoryAdminl41(ArrayList<ModelCategoryl41> filterList, AdapterCategoryAdminl41 adapterCategoryAdminl41) {
        this.filterList = filterList;
        this.adapterCategoryAdminl41 = adapterCategoryAdminl41;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl41> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminl41.categoryArrayList=(ArrayList<ModelCategoryl41>)results.values;
        //notify changes
        adapterCategoryAdminl41.notifyDataSetChanged();

    }
}
