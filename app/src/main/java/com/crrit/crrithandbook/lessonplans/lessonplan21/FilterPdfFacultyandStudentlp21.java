package com.crrit.crrithandbook.lessonplans.lessonplan21;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorylp21;
import com.crrit.crrithandbook.models.ModelPdflp21;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentlp21 extends Filter {
    //array list
    ArrayList<ModelPdflp21> filterList;
    //adapter
    AdapterPdfFacultyandStudentlp21 adapterPdfFacultyandStudentlp21;
    //constructor

    public FilterPdfFacultyandStudentlp21(ArrayList<ModelPdflp21> filterList, AdapterPdfFacultyandStudentlp21 adapterPdfFacultyandStudentlp21) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentlp21 = adapterPdfFacultyandStudentlp21;
    }

    public FilterPdfFacultyandStudentlp21(ArrayList<ModelCategorylp21> filterList, AdapterCategoryFacultyandStudentlp21 adapterCategoryFacultyandStudentlp21) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdflp21> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentlp21.pdfArrayList=(ArrayList<ModelPdflp21>)results.values;
        //notify changes
        adapterPdfFacultyandStudentlp21.notifyDataSetChanged();

    }
}
