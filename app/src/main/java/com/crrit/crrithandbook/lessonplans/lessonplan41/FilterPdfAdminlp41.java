package com.crrit.crrithandbook.lessonplans.lessonplan41;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdflp41;

import java.util.ArrayList;

public class FilterPdfAdminlp41 extends Filter {
    //array list
    ArrayList<ModelPdflp41> filterList;
    //adapter
    AdapterPdfAdminlp41 adapterPdfAdminlp41;
    //constructor

    public FilterPdfAdminlp41(ArrayList<ModelPdflp41> filterList, AdapterPdfAdminlp41 adapterPdfAdminlp41) {
        this.filterList = filterList;
        this.adapterPdfAdminlp41 = adapterPdfAdminlp41;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp41> filteredModels = new ArrayList<>();
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

        adapterPdfAdminlp41.pdfArrayList=(ArrayList<ModelPdflp41>)results.values;
        //notify changes
        adapterPdfAdminlp41.notifyDataSetChanged();

    }
}
