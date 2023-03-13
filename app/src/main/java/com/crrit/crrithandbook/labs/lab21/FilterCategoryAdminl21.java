package com.crrit.crrithandbook.labs.lab21;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl21;

import java.util.ArrayList;

public class FilterCategoryAdminl21 extends Filter {
    //array list
    ArrayList<ModelCategoryl21> filterList;
    //adapter
    AdapterCategoryAdminl21 adapterCategoryAdminl21;
    //constructor

    public FilterCategoryAdminl21(ArrayList<ModelCategoryl21> filterList, AdapterCategoryAdminl21 adapterCategoryAdminl21) {
        this.filterList = filterList;
        this.adapterCategoryAdminl21 = adapterCategoryAdminl21;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl21> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminl21.categoryArrayList=(ArrayList<ModelCategoryl21>)results.values;
        //notify changes
        adapterCategoryAdminl21.notifyDataSetChanged();

    }
}
