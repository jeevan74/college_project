package com.crrit.crrithandbook.syllabus;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdfSyllabus;

import java.util.ArrayList;

public class FilterPdfAdminSyllabus extends Filter {
    //array list
    ArrayList<ModelPdfSyllabus> filterList;
    //adapter
    AdapterPdfAdminSyllabus adapterPdfAdminSyllabus;
    //constructor

    public FilterPdfAdminSyllabus(ArrayList<ModelPdfSyllabus> filterList, AdapterPdfAdminSyllabus adapterPdfAdminSyllabus) {
        this.filterList = filterList;
        this.adapterPdfAdminSyllabus = adapterPdfAdminSyllabus;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfSyllabus> filteredModels = new ArrayList<>();
            for (int i=0;i<filterList.size();i++){
                //validate
                if (filterList.get(i).getTitle().toUpperCase().contains(constraint)){
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

        adapterPdfAdminSyllabus.pdfArrayList=(ArrayList<ModelPdfSyllabus>)results.values;
        //notify changes
        adapterPdfAdminSyllabus.notifyDataSetChanged();

    }
}
