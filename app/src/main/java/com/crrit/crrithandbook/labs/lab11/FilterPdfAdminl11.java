package com.crrit.crrithandbook.labs.lab11;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminl11 extends Filter {
    //array list
    ArrayList<ModelPdfl11> filterList;
    //adapter
    AdapterPdfAdminl11 adapterPdfAdminl11;
    //constructor

    public FilterPdfAdminl11(ArrayList<ModelPdfl11> filterList, AdapterPdfAdminl11 adapterPdfAdminl11) {
        this.filterList = filterList;
        this.adapterPdfAdminl11 = adapterPdfAdminl11;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl11> filteredModels = new ArrayList<>();
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

        adapterPdfAdminl11.pdfArrayList=(ArrayList<ModelPdfl11>)results.values;
        //notify changes
        adapterPdfAdminl11.notifyDataSetChanged();

    }
}
