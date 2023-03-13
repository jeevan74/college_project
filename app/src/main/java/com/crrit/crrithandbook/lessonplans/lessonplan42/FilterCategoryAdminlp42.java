package com.crrit.crrithandbook.lessonplans.lessonplan42;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp42;

import java.util.ArrayList;

public class FilterCategoryAdminlp42 extends Filter {
    //array list
    ArrayList<ModelCategorylp42> filterList;
    //adapter
    AdapterCategoryAdminlp42 adapterCategoryAdminlp42;
    //constructor

    public FilterCategoryAdminlp42(ArrayList<ModelCategorylp42> filterList, AdapterCategoryAdminlp42 adapterCategoryAdminlp42) {
        this.filterList = filterList;
        this.adapterCategoryAdminlp42 = adapterCategoryAdminlp42;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp42> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminlp42.categoryArrayList=(ArrayList<ModelCategorylp42>)results.values;
        //notify changes
        adapterCategoryAdminlp42.notifyDataSetChanged();

    }
}
