package com.crrit.crrithandbook.labs.lab31;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminl31 extends Filter {
    //array list
    ArrayList<ModelPdfl31> filterList;
    //adapter
    AdapterPdfAdminl31 adapterPdfAdminl31;
    //constructor

    public FilterPdfAdminl31(ArrayList<ModelPdfl31> filterList, AdapterPdfAdminl31 adapterPdfAdminl31) {
        this.filterList = filterList;
        this.adapterPdfAdminl31 = adapterPdfAdminl31;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl31> filteredModels = new ArrayList<>();
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

        adapterPdfAdminl31.pdfArrayList=(ArrayList<ModelPdfl31>)results.values;
        //notify changes
        adapterPdfAdminl31.notifyDataSetChanged();

    }
}
