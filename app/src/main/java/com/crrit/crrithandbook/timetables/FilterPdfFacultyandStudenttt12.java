package com.crrit.crrithandbook.timetables;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorytt12;
import com.crrit.crrithandbook.models.ModelPdftt12;

import java.util.ArrayList;

public class FilterPdfFacultyandStudenttt12 extends Filter {
    //array list
    ArrayList<ModelPdftt12> filterList;
    //adapter
    AdapterPdfFacultyandStudenttt12 adapterPdfFacultyandStudenttt12;
    //constructor

    public FilterPdfFacultyandStudenttt12(ArrayList<ModelPdftt12> filterList, AdapterPdfFacultyandStudenttt12 adapterPdfFacultyandStudenttt12) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudenttt12 = adapterPdfFacultyandStudenttt12;
    }

    public FilterPdfFacultyandStudenttt12(ArrayList<ModelCategorytt12> filterList, AdapterCategoryFacultyandStudenttt12 adapterCategoryFacultyandStudenttt12) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdftt12> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudenttt12.pdfArrayList=(ArrayList<ModelPdftt12>)results.values;
        //notify changes
        adapterPdfFacultyandStudenttt12.notifyDataSetChanged();

    }
}
