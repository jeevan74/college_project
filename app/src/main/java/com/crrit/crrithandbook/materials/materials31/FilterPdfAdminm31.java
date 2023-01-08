package com.crrit.crrithandbook.materials.materials31;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminm31 extends Filter {
    //array list
    ArrayList<ModelPdfm31> filterList;
    //adapter
    AdapterPdfAdminm31 adapterPdfAdminm31;
    //constructor

    public FilterPdfAdminm31(ArrayList<ModelPdfm31> filterList, AdapterPdfAdminm31 adapterPdfAdminm31) {
        this.filterList = filterList;
        this.adapterPdfAdminm31 = adapterPdfAdminm31;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm31> filteredModels = new ArrayList<>();
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

        adapterPdfAdminm31.pdfArrayList=(ArrayList<ModelPdfm31>)results.values;
        //notify changes
        adapterPdfAdminm31.notifyDataSetChanged();

    }
}
