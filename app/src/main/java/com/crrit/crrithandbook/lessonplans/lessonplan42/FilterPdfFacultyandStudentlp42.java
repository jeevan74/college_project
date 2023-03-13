package com.crrit.crrithandbook.lessonplans.lessonplan42;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp42;
import com.crrit.crrithandbook.models.ModelPdflp42;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentlp42 extends Filter {
    //array list
    ArrayList<ModelPdflp42> filterList;
    //adapter
    AdapterPdfFacultyandStudentlp42 adapterPdfFacultyandStudentlp42;
    //constructor

    public FilterPdfFacultyandStudentlp42(ArrayList<ModelPdflp42> filterList, AdapterPdfFacultyandStudentlp42 adapterPdfFacultyandStudentlp42) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentlp42 = adapterPdfFacultyandStudentlp42;
    }

    public FilterPdfFacultyandStudentlp42(ArrayList<ModelCategorylp42> filterList, AdapterCategoryFacultyandStudentlp42 adapterCategoryFacultyandStudentlp42) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp42> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentlp42.pdfArrayList=(ArrayList<ModelPdflp42>)results.values;
        //notify changes
        adapterPdfFacultyandStudentlp42.notifyDataSetChanged();

    }
}
