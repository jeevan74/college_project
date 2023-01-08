package com.crrit.crrithandbook.labs.lab42;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentl42 extends Filter {
    //array list
    ArrayList<ModelPdfl42> filterList;
    //adapter
    AdapterPdfFacultyandStudentl42 adapterPdfFacultyandStudentl42;
    //constructor

    public FilterPdfFacultyandStudentl42(ArrayList<ModelPdfl42> filterList, AdapterPdfFacultyandStudentl42 adapterPdfFacultyandStudentl42) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentl42 = adapterPdfFacultyandStudentl42;
    }

    public FilterPdfFacultyandStudentl42(ArrayList<ModelCategoryl42> filterList, AdapterCategoryFacultyandStudentl42 adapterCategoryFacultyandStudentl42) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl42> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentl42.pdfArrayList=(ArrayList<ModelPdfl42>)results.values;
        //notify changes
        adapterPdfFacultyandStudentl42.notifyDataSetChanged();

    }
}
