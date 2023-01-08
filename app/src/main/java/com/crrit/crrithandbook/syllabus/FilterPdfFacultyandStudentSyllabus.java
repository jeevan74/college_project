package com.crrit.crrithandbook.syllabus;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentSyllabus extends Filter {
    //array list
    ArrayList<ModelPdfSyllabus> filterList;
    //adapter
    AdapterPdfFacultyandStudentSyllabus adapterPdfFacultyandStudentSyllabus;
    //constructor

    public FilterPdfFacultyandStudentSyllabus(ArrayList<ModelPdfSyllabus> filterList, AdapterPdfFacultyandStudentSyllabus adapterPdfFacultyandStudentSyllabus) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentSyllabus = adapterPdfFacultyandStudentSyllabus;
    }

    public FilterPdfFacultyandStudentSyllabus(ArrayList<ModelCategorySyllabus> filterList, AdapterCategoryFacultyandStudentSyllabus adapterCategoryFacultyandStudentSyllabus) {
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

        adapterPdfFacultyandStudentSyllabus.pdfArrayList=(ArrayList<ModelPdfSyllabus>)results.values;
        //notify changes
        adapterPdfFacultyandStudentSyllabus.notifyDataSetChanged();

    }
}
