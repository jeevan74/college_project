package com.crrit.crrithandbook.materials.materials32;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategory;

import java.util.ArrayList;

public class FilterCategoryAdmin extends Filter {
    //array list
    ArrayList<ModelCategory> filterList;
    //adapter
    AdapterCategoryAdminm32 adapterCategoryAdminm32;
    //constructor

    public FilterCategoryAdmin(ArrayList<ModelCategory> filterList, AdapterCategoryAdminm32 adapterCategoryAdminm32) {
        this.filterList = filterList;
        this.adapterCategoryAdminm32 = adapterCategoryAdminm32;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategory> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminm32.categoryArrayList=(ArrayList<ModelCategory>)results.values;
        //notify changes
        adapterCategoryAdminm32.notifyDataSetChanged();

    }
}
