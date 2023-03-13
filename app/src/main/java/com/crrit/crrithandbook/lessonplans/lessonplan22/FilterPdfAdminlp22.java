package com.crrit.crrithandbook.lessonplans.lessonplan22;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdflp22;

import java.util.ArrayList;

public class FilterPdfAdminlp22 extends Filter {
    //array list
    ArrayList<ModelPdflp22> filterList;
    //adapter
    AdapterPdfAdminlp22 adapterPdfAdminlp22;
    //constructor

    public FilterPdfAdminlp22(ArrayList<ModelPdflp22> filterList, AdapterPdfAdminlp22 adapterPdfAdminlp22) {
        this.filterList = filterList;
        this.adapterPdfAdminlp22 = adapterPdfAdminlp22;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp22> filteredModels = new ArrayList<>();
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

        adapterPdfAdminlp22.pdfArrayList=(ArrayList<ModelPdflp22>)results.values;
        //notify changes
        adapterPdfAdminlp22.notifyDataSetChanged();

    }
}
