package com.crrit.crrithandbook.labs.lab41;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminl41 extends Filter {
    //array list
    ArrayList<ModelPdfl41> filterList;
    //adapter
    AdapterPdfAdminl41 adapterPdfAdminl41;
    //constructor

    public FilterPdfAdminl41(ArrayList<ModelPdfl41> filterList, AdapterPdfAdminl41 adapterPdfAdminl41) {
        this.filterList = filterList;
        this.adapterPdfAdminl41 = adapterPdfAdminl41;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl41> filteredModels = new ArrayList<>();
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

        adapterPdfAdminl41.pdfArrayList=(ArrayList<ModelPdfl41>)results.values;
        //notify changes
        adapterPdfAdminl41.notifyDataSetChanged();

    }
}
