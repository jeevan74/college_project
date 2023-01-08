package com.crrit.crrithandbook.materials.materials41;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentm41 extends Filter {
    //array list
    ArrayList<ModelPdfm41> filterList;
    //adapter
    AdapterPdfFacultyandStudentm41 adapterPdfFacultyandStudentm41;
    //constructor

    public FilterPdfFacultyandStudentm41(ArrayList<ModelPdfm41> filterList, AdapterPdfFacultyandStudentm41 adapterPdfFacultyandStudentm41) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentm41 = adapterPdfFacultyandStudentm41;
    }

    public FilterPdfFacultyandStudentm41(ArrayList<ModelCategorym41> filterList, AdapterCategoryFacultyandStudentm41 adapterCategoryFacultyandStudentm41) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm41> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentm41.pdfArrayList=(ArrayList<ModelPdfm41>)results.values;
        //notify changes
        adapterPdfFacultyandStudentm41.notifyDataSetChanged();

    }
}
