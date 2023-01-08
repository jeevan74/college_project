package com.crrit.crrithandbook.materials.materials41;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminm41 extends Filter {
    //array list
    ArrayList<ModelPdfm41> filterList;
    //adapter
    AdapterPdfAdminm41 adapterPdfAdminm41;
    //constructor

    public FilterPdfAdminm41(ArrayList<ModelPdfm41> filterList, AdapterPdfAdminm41 adapterPdfAdminm41) {
        this.filterList = filterList;
        this.adapterPdfAdminm41 = adapterPdfAdminm41;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm41> filteredModels = new ArrayList<>();
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

        adapterPdfAdminm41.pdfArrayList=(ArrayList<ModelPdfm41>)results.values;
        //notify changes
        adapterPdfAdminm41.notifyDataSetChanged();

    }
}
