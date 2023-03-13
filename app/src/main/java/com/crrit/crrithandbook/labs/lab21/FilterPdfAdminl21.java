package com.crrit.crrithandbook.labs.lab21;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdfl21;

import java.util.ArrayList;

public class FilterPdfAdminl21 extends Filter {
    //array list
    ArrayList<ModelPdfl21> filterList;
    //adapter
    AdapterPdfAdminl21 adapterPdfAdminl21;
    //constructor

    public FilterPdfAdminl21(ArrayList<ModelPdfl21> filterList, AdapterPdfAdminl21 adapterPdfAdminl21) {
        this.filterList = filterList;
        this.adapterPdfAdminl21 = adapterPdfAdminl21;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl21> filteredModels = new ArrayList<>();
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

        adapterPdfAdminl21.pdfArrayList=(ArrayList<ModelPdfl21>)results.values;
        //notify changes
        adapterPdfAdminl21.notifyDataSetChanged();

    }
}
