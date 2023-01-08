package com.crrit.crrithandbook.labs.lab22;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminl22 extends Filter {
    //array list
    ArrayList<ModelPdfl22> filterList;
    //adapter
    AdapterPdfAdminl22 adapterPdfAdminl22;
    //constructor

    public FilterPdfAdminl22(ArrayList<ModelPdfl22> filterList, AdapterPdfAdminl22 adapterPdfAdminl22) {
        this.filterList = filterList;
        this.adapterPdfAdminl22 = adapterPdfAdminl22;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl22> filteredModels = new ArrayList<>();
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

        adapterPdfAdminl22.pdfArrayList=(ArrayList<ModelPdfl22>)results.values;
        //notify changes
        adapterPdfAdminl22.notifyDataSetChanged();

    }
}
