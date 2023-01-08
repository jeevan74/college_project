package com.crrit.crrithandbook.materials.materials42;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminm42 extends Filter {
    //array list
    ArrayList<ModelPdfm42> filterList;
    //adapter
    AdapterPdfAdminm42 adapterPdfAdminm42;
    //constructor

    public FilterPdfAdminm42(ArrayList<ModelPdfm42> filterList, AdapterPdfAdminm42 adapterPdfAdminm42) {
        this.filterList = filterList;
        this.adapterPdfAdminm42 = adapterPdfAdminm42;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm42> filteredModels = new ArrayList<>();
            for (int i=0;i<filterList.size();i++){
                //validate
                if (filterList.get(i).getDescription().toUpperCase().contains(constraint)){
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

        adapterPdfAdminm42.pdfArrayList=(ArrayList<ModelPdfm42>)results.values;
        //notify changes
        adapterPdfAdminm42.notifyDataSetChanged();

    }
}
