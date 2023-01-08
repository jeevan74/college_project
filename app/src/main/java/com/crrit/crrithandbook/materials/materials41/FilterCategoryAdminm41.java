package com.crrit.crrithandbook.materials.materials41;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminm41 extends Filter {
    //array list
    ArrayList<ModelCategorym41> filterList;
    //adapter
    AdapterCategoryAdminm41 adapterCategoryAdminm41;
    //constructor

    public FilterCategoryAdminm41(ArrayList<ModelCategorym41> filterList, AdapterCategoryAdminm41 adapterCategoryAdminm41) {
        this.filterList = filterList;
        this.adapterCategoryAdminm41 = adapterCategoryAdminm41;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym41> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminm41.categoryArrayList=(ArrayList<ModelCategorym41>)results.values;
        //notify changes
        adapterCategoryAdminm41.notifyDataSetChanged();

    }
}
