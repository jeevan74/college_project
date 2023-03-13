package com.crrit.crrithandbook.materials.materials11;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdfm11;

import java.util.ArrayList;

public class FilterPdfAdminm11 extends Filter {
    //array list
    ArrayList<ModelPdfm11> filterList;
    //adapter
    AdapterPdfAdminm11 adapterPdfAdminm11;
    //constructor

    public FilterPdfAdminm11(ArrayList<ModelPdfm11> filterList, AdapterPdfAdminm11 adapterPdfAdminm11) {
        this.filterList = filterList;
        this.adapterPdfAdminm11 = adapterPdfAdminm11;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm11> filteredModels = new ArrayList<>();
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

        adapterPdfAdminm11.pdfArrayList=(ArrayList<ModelPdfm11>)results.values;
        //notify changes
        adapterPdfAdminm11.notifyDataSetChanged();

    }
}
