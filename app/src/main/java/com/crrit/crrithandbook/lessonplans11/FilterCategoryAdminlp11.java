package com.crrit.crrithandbook.lessonplans11;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminlp11 extends Filter {
    //array list
    ArrayList<ModelCategorylp11> filterList;
    //adapter
    AdapterCategoryAdminlp11 adapterCategoryAdminlp11;
    //constructor

    public FilterCategoryAdminlp11(ArrayList<ModelCategorylp11> filterList, AdapterCategoryAdminlp11 adapterCategoryAdminlp11) {
        this.filterList = filterList;
        this.adapterCategoryAdminlp11 = adapterCategoryAdminlp11;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp11> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminlp11.categoryArrayList=(ArrayList<ModelCategorylp11>)results.values;
        //notify changes
        adapterCategoryAdminlp11.notifyDataSetChanged();

    }
}
