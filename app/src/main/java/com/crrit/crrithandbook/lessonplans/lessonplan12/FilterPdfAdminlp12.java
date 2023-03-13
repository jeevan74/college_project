package com.crrit.crrithandbook.lessonplans.lessonplan12;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdflp12;

import java.util.ArrayList;

public class FilterPdfAdminlp12 extends Filter {
    //array list
    ArrayList<ModelPdflp12> filterList;
    //adapter
    AdapterPdfAdminlp12 adapterPdfAdminlp12;
    //constructor

    public FilterPdfAdminlp12(ArrayList<ModelPdflp12> filterList, AdapterPdfAdminlp12 adapterPdfAdminlp12) {
        this.filterList = filterList;
        this.adapterPdfAdminlp12 = adapterPdfAdminlp12;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp12> filteredModels = new ArrayList<>();
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

        adapterPdfAdminlp12.pdfArrayList=(ArrayList<ModelPdflp12>)results.values;
        //notify changes
        adapterPdfAdminlp12.notifyDataSetChanged();

    }
}
