package com.crrit.crrithandbook.materials.materials11;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentm11 extends Filter {
    //array list
    ArrayList<ModelPdfm11> filterList;
    //adapter
    AdapterPdfFacultyandStudentm11 adapterPdfFacultyandStudentm11;
    //constructor

    public FilterPdfFacultyandStudentm11(ArrayList<ModelPdfm11> filterList, AdapterPdfFacultyandStudentm11 adapterPdfFacultyandStudentm11) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentm11 = adapterPdfFacultyandStudentm11;
    }

    public FilterPdfFacultyandStudentm11(ArrayList<ModelCategorym11> filterList, AdapterCategoryFacultyandStudentm11 adapterCategoryFacultyandStudentm11) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm11> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentm11.pdfArrayList=(ArrayList<ModelPdfm11>)results.values;
        //notify changes
        adapterPdfFacultyandStudentm11.notifyDataSetChanged();

    }
}
