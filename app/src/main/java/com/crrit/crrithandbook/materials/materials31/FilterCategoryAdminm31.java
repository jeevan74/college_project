package com.crrit.crrithandbook.materials.materials31;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminm31 extends Filter {
    //array list
    ArrayList<ModelCategorym31> filterList;
    //adapter
    AdapterCategoryAdminm31 adapterCategoryAdminm31;
    //constructor

    public FilterCategoryAdminm31(ArrayList<ModelCategorym31> filterList, AdapterCategoryAdminm31 adapterCategoryAdminm31) {
        this.filterList = filterList;
        this.adapterCategoryAdminm31 = adapterCategoryAdminm31;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym31> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminm31.categoryArrayList=(ArrayList<ModelCategorym31>)results.values;
        //notify changes
        adapterCategoryAdminm31.notifyDataSetChanged();

    }
}
