package com.crrit.crrithandbook.materials.materials12;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminm12 extends Filter {
    //array list
    ArrayList<ModelCategorym12> filterList;
    //adapter
    AdapterCategoryAdminm12 adapterCategoryAdminm12;
    //constructor

    public FilterCategoryAdminm12(ArrayList<ModelCategorym12> filterList, AdapterCategoryAdminm12 adapterCategoryAdminm12) {
        this.filterList = filterList;
        this.adapterCategoryAdminm12 = adapterCategoryAdminm12;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym12> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminm12.categoryArrayList=(ArrayList<ModelCategorym12>)results.values;
        //notify changes
        adapterCategoryAdminm12.notifyDataSetChanged();

    }
}
