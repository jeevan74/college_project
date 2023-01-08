package com.crrit.crrithandbook.labs.lab41;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentl41 extends Filter {
    //array list
    ArrayList<ModelPdfl41> filterList;
    //adapter
    AdapterPdfFacultyandStudentl41 adapterPdfFacultyandStudentl41;
    //constructor

    public FilterPdfFacultyandStudentl41(ArrayList<ModelPdfl41> filterList, AdapterPdfFacultyandStudentl41 adapterPdfFacultyandStudentl41) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentl41 = adapterPdfFacultyandStudentl41;
    }

    public FilterPdfFacultyandStudentl41(ArrayList<ModelCategoryl41> filterList, AdapterCategoryFacultyandStudentl41 adapterCategoryFacultyandStudentl41) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl41> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentl41.pdfArrayList=(ArrayList<ModelPdfl41>)results.values;
        //notify changes
        adapterPdfFacultyandStudentl41.notifyDataSetChanged();

    }
}
