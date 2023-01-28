package com.crrit.crrithandbook.lessonplans.lessonplan12;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentlp12 extends Filter {
    //array list
    ArrayList<ModelPdflp12> filterList;
    //adapter
    AdapterPdfFacultyandStudentlp12 adapterPdfFacultyandStudentlp12;
    //constructor

    public FilterPdfFacultyandStudentlp12(ArrayList<ModelPdflp12> filterList, AdapterPdfFacultyandStudentlp12 adapterPdfFacultyandStudentlp12) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentlp12 = adapterPdfFacultyandStudentlp12;
    }

    public FilterPdfFacultyandStudentlp12(ArrayList<ModelCategorylp12> filterList, AdapterCategoryFacultyandStudentlp12 adapterCategoryFacultyandStudentlp12) {
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

        adapterPdfFacultyandStudentlp12.pdfArrayList=(ArrayList<ModelPdflp12>)results.values;
        //notify changes
        adapterPdfFacultyandStudentlp12.notifyDataSetChanged();

    }
}
