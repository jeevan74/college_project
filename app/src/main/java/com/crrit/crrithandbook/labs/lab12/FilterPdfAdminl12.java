package com.crrit.crrithandbook.labs.lab12;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminl12 extends Filter {
    //array list
    ArrayList<ModelPdfl12> filterList;
    //adapter
    AdapterPdfAdminl12 adapterPdfAdminl12;
    //constructor

    public FilterPdfAdminl12(ArrayList<ModelPdfl12> filterList, AdapterPdfAdminl12 adapterPdfAdminl12) {
        this.filterList = filterList;
        this.adapterPdfAdminl12 = adapterPdfAdminl12;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl12> filteredModels = new ArrayList<>();
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

        adapterPdfAdminl12.pdfArrayList=(ArrayList<ModelPdfl12>)results.values;
        //notify changes
        adapterPdfAdminl12.notifyDataSetChanged();

    }
}
