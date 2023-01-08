package com.crrit.crrithandbook.materials.materials11;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminm11 extends Filter {
    //array list
    ArrayList<ModelCategorym11> filterList;
    //adapter
    AdapterCategoryAdminm11 adapterCategoryAdminm11;
    //constructor

    public FilterCategoryAdminm11(ArrayList<ModelCategorym11> filterList, AdapterCategoryAdminm11 adapterCategoryAdminm11) {
        this.filterList = filterList;
        this.adapterCategoryAdminm11 = adapterCategoryAdminm11;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym11> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminm11.categoryArrayList=(ArrayList<ModelCategorym11>)results.values;
        //notify changes
        adapterCategoryAdminm11.notifyDataSetChanged();

    }
}
