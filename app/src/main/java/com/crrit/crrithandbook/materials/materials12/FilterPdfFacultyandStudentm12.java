package com.crrit.crrithandbook.materials.materials12;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorym12;
import com.crrit.crrithandbook.models.ModelPdfm12;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentm12 extends Filter {
    //array list
    ArrayList<ModelPdfm12> filterList;
    //adapter
    AdapterPdfFacultyandStudentm12 adapterPdfFacultyandStudentm12;
    //constructor

    public FilterPdfFacultyandStudentm12(ArrayList<ModelPdfm12> filterList, AdapterPdfFacultyandStudentm12 adapterPdfFacultyandStudentm12) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentm12 = adapterPdfFacultyandStudentm12;
    }

    public FilterPdfFacultyandStudentm12(ArrayList<ModelCategorym12> filterList, AdapterCategoryFacultyandStudentm12 adapterCategoryFacultyandStudentm12) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm12> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentm12.pdfArrayList=(ArrayList<ModelPdfm12>)results.values;
        //notify changes
        adapterPdfFacultyandStudentm12.notifyDataSetChanged();

    }
}
