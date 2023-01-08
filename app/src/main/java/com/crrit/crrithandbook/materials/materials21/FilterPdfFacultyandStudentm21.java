package com.crrit.crrithandbook.materials.materials21;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentm21 extends Filter {
    //array list
    ArrayList<ModelPdfm21> filterList;
    //adapter
    AdapterPdfFacultyandStudentm21 adapterPdfFacultyandStudentm21;
    //constructor

    public FilterPdfFacultyandStudentm21(ArrayList<ModelPdfm21> filterList, AdapterPdfFacultyandStudentm21 adapterPdfFacultyandStudentm21) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentm21 = adapterPdfFacultyandStudentm21;
    }

    public FilterPdfFacultyandStudentm21(ArrayList<ModelCategorym21> filterList, AdapterCategoryFacultyandStudentm21 adapterCategoryFacultyandStudentm21) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm21> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentm21.pdfArrayList=(ArrayList<ModelPdfm21>)results.values;
        //notify changes
        adapterPdfFacultyandStudentm21.notifyDataSetChanged();

    }
}
