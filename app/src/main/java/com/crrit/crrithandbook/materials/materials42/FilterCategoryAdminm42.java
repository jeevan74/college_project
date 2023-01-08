package com.crrit.crrithandbook.materials.materials42;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminm42 extends Filter {
    //array list
    ArrayList<ModelCategorym42> filterList;
    //adapter
    AdapterCategoryAdminm42 adapterCategoryAdminm42;
    //constructor

    public FilterCategoryAdminm42(ArrayList<ModelCategorym42> filterList, AdapterCategoryAdminm42 adapterCategoryAdminm42) {
        this.filterList = filterList;
        this.adapterCategoryAdminm42 = adapterCategoryAdminm42;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym42> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminm42.categoryArrayList=(ArrayList<ModelCategorym42>)results.values;
        //notify changes
        adapterCategoryAdminm42.notifyDataSetChanged();

    }
}
