package com.crrit.crrithandbook.materials.materials21;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorym21;

import java.util.ArrayList;

public class FilterCategoryAdminm21 extends Filter {
    //array list
    ArrayList<ModelCategorym21> filterList;
    //adapter
    AdapterCategoryAdminm21 adapterCategoryAdminm21;
    //constructor

    public FilterCategoryAdminm21(ArrayList<ModelCategorym21> filterList, AdapterCategoryAdminm21 adapterCategoryAdminm21) {
        this.filterList = filterList;
        this.adapterCategoryAdminm21 = adapterCategoryAdminm21;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym21> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminm21.categoryArrayList=(ArrayList<ModelCategorym21>)results.values;
        //notify changes
        adapterCategoryAdminm21.notifyDataSetChanged();

    }
}
