package com.crrit.crrithandbook.lessonplans.lessonplan31;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfAdminlp31 extends Filter {
    //array list
    ArrayList<ModelPdflp31> filterList;
    //adapter
    AdapterPdfAdminlp31 adapterPdfAdminlp31;
    //constructor

    public FilterPdfAdminlp31(ArrayList<ModelPdflp31> filterList, AdapterPdfAdminlp31 adapterPdfAdminlp31) {
        this.filterList = filterList;
        this.adapterPdfAdminlp31 = adapterPdfAdminlp31;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp31> filteredModels = new ArrayList<>();
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

        adapterPdfAdminlp31.pdfArrayList=(ArrayList<ModelPdflp31>)results.values;
        //notify changes
        adapterPdfAdminlp31.notifyDataSetChanged();

    }
}
