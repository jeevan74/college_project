package com.crrit.crrithandbook.timetables;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorytt12;

import java.util.ArrayList;

public class FilterCategoryAdmintt12 extends Filter {
    //array list
    ArrayList<ModelCategorytt12> filterList;
    //adapter
    AdapterCategoryAdmintt12 adapterCategoryAdmintt12;
    //constructor

    public FilterCategoryAdmintt12(ArrayList<ModelCategorytt12> filterList, AdapterCategoryAdmintt12 adapterCategoryAdmintt12) {
        this.filterList = filterList;
        this.adapterCategoryAdmintt12 = adapterCategoryAdmintt12;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorytt12> filteredModels = new ArrayList<>();
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

        adapterCategoryAdmintt12.categoryArrayList=(ArrayList<ModelCategorytt12>)results.values;
        //notify changes
        adapterCategoryAdmintt12.notifyDataSetChanged();

    }
}
