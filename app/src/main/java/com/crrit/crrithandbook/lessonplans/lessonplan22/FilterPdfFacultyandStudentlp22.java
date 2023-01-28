package com.crrit.crrithandbook.lessonplans.lessonplan22;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentlp22 extends Filter {
    //array list
    ArrayList<ModelPdflp22> filterList;
    //adapter
    AdapterPdfFacultyandStudentlp22 adapterPdfFacultyandStudentlp22;
    //constructor

    public FilterPdfFacultyandStudentlp22(ArrayList<ModelPdflp22> filterList, AdapterPdfFacultyandStudentlp22 adapterPdfFacultyandStudentlp22) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentlp22 = adapterPdfFacultyandStudentlp22;
    }

    public FilterPdfFacultyandStudentlp22(ArrayList<ModelCategorylp22> filterList, AdapterCategoryFacultyandStudentlp22 adapterCategoryFacultyandStudentlp22) {
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

        adapterPdfFacultyandStudentlp22.pdfArrayList=(ArrayList<ModelPdflp22>)results.values;
        //notify changes
        adapterPdfFacultyandStudentlp22.notifyDataSetChanged();

    }
}
