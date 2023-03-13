package com.crrit.crrithandbook.labs.lab22;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl22;

import java.util.ArrayList;

public class FilterCategoryAdminl22 extends Filter {
    //array list
    ArrayList<ModelCategoryl22> filterList;
    //adapter
    AdapterCategoryAdminl22 adapterCategoryAdminl22;
    //constructor

    public FilterCategoryAdminl22(ArrayList<ModelCategoryl22> filterList, AdapterCategoryAdminl22 adapterCategoryAdminl22) {
        this.filterList = filterList;
        this.adapterCategoryAdminl22 = adapterCategoryAdminl22;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl22> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminl22.categoryArrayList=(ArrayList<ModelCategoryl22>)results.values;
        //notify changes
        adapterCategoryAdminl22.notifyDataSetChanged();

    }
}
