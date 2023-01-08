package com.crrit.crrithandbook.labs.lab11;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminl11 extends Filter {
    //array list
    ArrayList<ModelCategoryl11> filterList;
    //adapter
    AdapterCategoryAdminl11 adapterCategoryAdminl11;
    //constructor

    public FilterCategoryAdminl11(ArrayList<ModelCategoryl11> filterList, AdapterCategoryAdminl11 adapterCategoryAdminl11) {
        this.filterList = filterList;
        this.adapterCategoryAdminl11 = adapterCategoryAdminl11;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategoryl11> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminl11.categoryArrayList=(ArrayList<ModelCategoryl11>)results.values;
        //notify changes
        adapterCategoryAdminl11.notifyDataSetChanged();

    }
}
