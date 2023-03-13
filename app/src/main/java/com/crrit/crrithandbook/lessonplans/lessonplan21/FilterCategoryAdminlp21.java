package com.crrit.crrithandbook.lessonplans.lessonplan21;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp21;

import java.util.ArrayList;

public class FilterCategoryAdminlp21 extends Filter {
    //array list
    ArrayList<ModelCategorylp21> filterList;
    //adapter
    AdapterCategoryAdminlp21 adapterCategoryAdminlp21;
    //constructor

    public FilterCategoryAdminlp21(ArrayList<ModelCategorylp21> filterList, AdapterCategoryAdminlp21 adapterCategoryAdminlp21) {
        this.filterList = filterList;
        this.adapterCategoryAdminlp21 = adapterCategoryAdminlp21;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp21> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminlp21.categoryArrayList=(ArrayList<ModelCategorylp21>)results.values;
        //notify changes
        adapterCategoryAdminlp21.notifyDataSetChanged();

    }
}
