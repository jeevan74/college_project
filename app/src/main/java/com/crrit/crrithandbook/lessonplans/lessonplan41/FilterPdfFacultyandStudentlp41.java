package com.crrit.crrithandbook.lessonplans.lessonplan41;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp41;
import com.crrit.crrithandbook.models.ModelPdflp41;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentlp41 extends Filter {
    //array list
    ArrayList<ModelPdflp41> filterList;
    //adapter
    AdapterPdfFacultyandStudentlp41 adapterPdfFacultyandStudentlp41;
    //constructor

    public FilterPdfFacultyandStudentlp41(ArrayList<ModelPdflp41> filterList, AdapterPdfFacultyandStudentlp41 adapterPdfFacultyandStudentlp41) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentlp41 = adapterPdfFacultyandStudentlp41;
    }

    public FilterPdfFacultyandStudentlp41(ArrayList<ModelCategorylp41> filterList, AdapterCategoryFacultyandStudentlp41 adapterCategoryFacultyandStudentlp41) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp41> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentlp41.pdfArrayList=(ArrayList<ModelPdflp41>)results.values;
        //notify changes
        adapterPdfFacultyandStudentlp41.notifyDataSetChanged();

    }
}
