package com.crrit.crrithandbook.lessonplans.lessonplan12;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp12;

import java.util.ArrayList;

public class FilterCategoryAdminlp12 extends Filter {
    //array list
    ArrayList<ModelCategorylp12> filterList;
    //adapter
    AdapterCategoryAdminlp12 adapterCategoryAdminlp12;
    //constructor

    public FilterCategoryAdminlp12(ArrayList<ModelCategorylp12> filterList, AdapterCategoryAdminlp12 adapterCategoryAdminlp12) {
        this.filterList = filterList;
        this.adapterCategoryAdminlp12 = adapterCategoryAdminlp12;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorylp12> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminlp12.categoryArrayList=(ArrayList<ModelCategorylp12>)results.values;
        //notify changes
        adapterCategoryAdminlp12.notifyDataSetChanged();

    }
}
