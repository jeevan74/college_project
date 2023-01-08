package com.crrit.crrithandbook.materials.materials22;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryAdminm22 extends Filter {
    //array list
    ArrayList<ModelCategorym22> filterList;
    //adapter
    AdapterCategoryAdminm22 adapterCategoryAdminm22;
    //constructor

    public FilterCategoryAdminm22(ArrayList<ModelCategorym22> filterList, AdapterCategoryAdminm22 adapterCategoryAdminm22) {
        this.filterList = filterList;
        this.adapterCategoryAdminm22 = adapterCategoryAdminm22;
    }



    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym22> filteredModels = new ArrayList<>();
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

        adapterCategoryAdminm22.categoryArrayList=(ArrayList<ModelCategorym22>)results.values;
        //notify changes
        adapterCategoryAdminm22.notifyDataSetChanged();

    }
}
