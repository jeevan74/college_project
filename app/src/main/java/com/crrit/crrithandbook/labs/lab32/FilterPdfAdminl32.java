package com.crrit.crrithandbook.labs.lab32;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminl32 extends Filter {
    //array list
    ArrayList<ModelPdfl32> filterList;
    //adapter
    AdapterPdfAdminl32 adapterPdfAdminl32;
    //constructor

    public FilterPdfAdminl32(ArrayList<ModelPdfl32> filterList, AdapterPdfAdminl32 adapterPdfAdminl32) {
        this.filterList = filterList;
        this.adapterPdfAdminl32 = adapterPdfAdminl32;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl32> filteredModels = new ArrayList<>();
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

        adapterPdfAdminl32.pdfArrayList=(ArrayList<ModelPdfl32>)results.values;
        //notify changes
        adapterPdfAdminl32.notifyDataSetChanged();

    }
}
