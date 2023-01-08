package com.crrit.crrithandbook.materials.materials21;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminm21 extends Filter {
    //array list
    ArrayList<ModelPdfm21> filterList;
    //adapter
    AdapterPdfAdminm21 adapterPdfAdminm21;
    //constructor

    public FilterPdfAdminm21(ArrayList<ModelPdfm21> filterList, AdapterPdfAdminm21 adapterPdfAdminm21) {
        this.filterList = filterList;
        this.adapterPdfAdminm21 = adapterPdfAdminm21;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm21> filteredModels = new ArrayList<>();
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

        adapterPdfAdminm21.pdfArrayList=(ArrayList<ModelPdfm21>)results.values;
        //notify changes
        adapterPdfAdminm21.notifyDataSetChanged();

    }
}
