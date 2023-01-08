package com.crrit.crrithandbook.syllabus;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminSyllabus extends Filter {
    //array list
    ArrayList<ModelCategorySyllabus> filterList;
    //adapter
    AdapterCategoryAdminSyllabus adapterCategoryAdminSyllabus;
    //constructor

    public FilterCategoryAdminSyllabus(ArrayList<ModelCategorySyllabus> filterList, AdapterCategoryAdminSyllabus adapterCategoryAdminSyllabus) {
        this.filterList = filterList;
        this.adapterCategoryAdminSyllabus = adapterCategoryAdminSyllabus;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorySyllabus> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminSyllabus.categoryArrayList=(ArrayList<ModelCategorySyllabus>)results.values;
        //notify changes
        adapterCategoryAdminSyllabus.notifyDataSetChanged();

    }
}
