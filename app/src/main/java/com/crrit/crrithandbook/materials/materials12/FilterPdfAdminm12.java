package com.crrit.crrithandbook.materials.materials12;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdfm12;

import java.util.ArrayList;

public class FilterPdfAdminm12 extends Filter {
    //array list
    ArrayList<ModelPdfm12> filterList;
    //adapter
    AdapterPdfAdminm12 adapterPdfAdminm12;
    //constructor

    public FilterPdfAdminm12(ArrayList<ModelPdfm12> filterList, AdapterPdfAdminm12 adapterPdfAdminm12) {
        this.filterList = filterList;
        this.adapterPdfAdminm12 = adapterPdfAdminm12;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm12> filteredModels = new ArrayList<>();
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

        adapterPdfAdminm12.pdfArrayList=(ArrayList<ModelPdfm12>)results.values;
        //notify changes
        adapterPdfAdminm12.notifyDataSetChanged();

    }
}
