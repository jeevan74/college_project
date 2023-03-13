package com.crrit.crrithandbook.timetables;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdftt12;

import java.util.ArrayList;

public class FilterPdfAdmintt12 extends Filter {
    //array list
    ArrayList<ModelPdftt12> filterList;
    //adapter
    AdapterPdfAdmintt12 adapterPdfAdmintt12;
    //constructor

    public FilterPdfAdmintt12(ArrayList<ModelPdftt12> filterList, AdapterPdfAdmintt12 adapterPdfAdmintt12) {
        this.filterList = filterList;
        this.adapterPdfAdmintt12 = adapterPdfAdmintt12;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdftt12> filteredModels = new ArrayList<>();
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

        adapterPdfAdmintt12.pdfArrayList=(ArrayList<ModelPdftt12>)results.values;
        //notify changes
        adapterPdfAdmintt12.notifyDataSetChanged();

    }
}
