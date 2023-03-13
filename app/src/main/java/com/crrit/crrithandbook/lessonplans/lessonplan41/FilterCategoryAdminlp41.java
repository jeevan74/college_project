package com.crrit.crrithandbook.lessonplans.lessonplan41;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp41;

import java.util.ArrayList;

public class FilterCategoryAdminlp41 extends Filter {
    //array list
    ArrayList<ModelCategorylp41> filterList;
    //adapter
    AdapterCategoryAdminlp41 adapterCategoryAdminlp41;
    //constructor

    public FilterCategoryAdminlp41(ArrayList<ModelCategorylp41> filterList, AdapterCategoryAdminlp41 adapterCategoryAdminlp41) {
        this.filterList = filterList;
        this.adapterCategoryAdminlp41 = adapterCategoryAdminlp41;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp41> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminlp41.categoryArrayList=(ArrayList<ModelCategorylp41>)results.values;
        //notify changes
        adapterCategoryAdminlp41.notifyDataSetChanged();

    }
}
