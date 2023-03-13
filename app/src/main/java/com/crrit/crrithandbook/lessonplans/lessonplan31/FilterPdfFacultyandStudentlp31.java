package com.crrit.crrithandbook.lessonplans.lessonplan31;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp31;
import com.crrit.crrithandbook.models.ModelPdflp31;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentlp31 extends Filter {
    //array list
    ArrayList<ModelPdflp31> filterList;
    //adapter
    AdapterPdfFacultyandStudentlp31 adapterPdfFacultyandStudentlp31;
    //constructor

    public FilterPdfFacultyandStudentlp31(ArrayList<ModelPdflp31> filterList, AdapterPdfFacultyandStudentlp31 adapterPdfFacultyandStudentlp31) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentlp31 = adapterPdfFacultyandStudentlp31;
    }

    public FilterPdfFacultyandStudentlp31(ArrayList<ModelCategorylp31> filterList, AdapterCategoryFacultyandStudentlp31 adapterCategoryFacultyandStudentlp31) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp31> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentlp31.pdfArrayList=(ArrayList<ModelPdflp31>)results.values;
        //notify changes
        adapterPdfFacultyandStudentlp31.notifyDataSetChanged();

    }
}
