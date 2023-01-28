package com.crrit.crrithandbook.lessonplans.lessonplan22;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminlp22 extends Filter {
    //array list
    ArrayList<ModelCategorylp22> filterList;
    //adapter
    AdapterCategoryAdminlp22 adapterCategoryAdminlp22;
    //constructor

    public FilterCategoryAdminlp22(ArrayList<ModelCategorylp22> filterList, AdapterCategoryAdminlp22 adapterCategoryAdminlp22) {
        this.filterList = filterList;
        this.adapterCategoryAdminlp22 = adapterCategoryAdminlp22;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp22> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminlp22.categoryArrayList=(ArrayList<ModelCategorylp22>)results.values;
        //notify changes
        adapterCategoryAdminlp22.notifyDataSetChanged();

    }
}
