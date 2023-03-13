package com.crrit.crrithandbook.lessonplans.lessonplan32;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdflp32;

import java.util.ArrayList;

public class FilterPdfAdminlp32 extends Filter {
    //array list
    ArrayList<ModelPdflp32> filterList;
    //adapter
    AdapterPdfAdminlp32 adapterPdfAdminlp32;
    //constructor

    public FilterPdfAdminlp32(ArrayList<ModelPdflp32> filterList, AdapterPdfAdminlp32 adapterPdfAdminlp32) {
        this.filterList = filterList;
        this.adapterPdfAdminlp32 = adapterPdfAdminlp32;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp32> filteredModels = new ArrayList<>();
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

        adapterPdfAdminlp32.pdfArrayList=(ArrayList<ModelPdflp32>)results.values;
        //notify changes
        adapterPdfAdminlp32.notifyDataSetChanged();

    }
}
