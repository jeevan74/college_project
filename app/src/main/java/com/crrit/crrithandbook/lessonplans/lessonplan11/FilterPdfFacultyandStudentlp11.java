package com.crrit.crrithandbook.lessonplans.lessonplan11;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentlp11 extends Filter {
    //array list
    ArrayList<ModelPdflp11> filterList;
    //adapter
    AdapterPdfFacultyandStudentlp11 adapterPdfFacultyandStudentlp11;
    //constructor

    public FilterPdfFacultyandStudentlp11(ArrayList<ModelPdflp11> filterList, AdapterPdfFacultyandStudentlp11 adapterPdfFacultyandStudentlp11) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentlp11 = adapterPdfFacultyandStudentlp11;
    }

    public FilterPdfFacultyandStudentlp11(ArrayList<ModelCategorylp11> filterList, AdapterCategoryFacultyandStudentlp11 adapterCategoryFacultyandStudentlp11) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp11> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentlp11.pdfArrayList=(ArrayList<ModelPdflp11>)results.values;
        //notify changes
        adapterPdfFacultyandStudentlp11.notifyDataSetChanged();

    }
}
