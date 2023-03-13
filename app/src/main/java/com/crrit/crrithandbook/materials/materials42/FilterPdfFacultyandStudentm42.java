package com.crrit.crrithandbook.materials.materials42;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorym42;
import com.crrit.crrithandbook.models.ModelPdfm42;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentm42 extends Filter {
    //array list
    ArrayList<ModelPdfm42> filterList;
    //adapter
    AdapterPdfFacultyandStudentm42 adapterPdfFacultyandStudentm42;
    //constructor

    public FilterPdfFacultyandStudentm42(ArrayList<ModelPdfm42> filterList, AdapterPdfFacultyandStudentm42 adapterPdfFacultyandStudentm42) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentm42 = adapterPdfFacultyandStudentm42;
    }

    public FilterPdfFacultyandStudentm42(ArrayList<ModelCategorym42> filterList, AdapterCategoryFacultyandStudentm42 adapterCategoryFacultyandStudentm42) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm42> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentm42.pdfArrayList=(ArrayList<ModelPdfm42>)results.values;
        //notify changes
        adapterPdfFacultyandStudentm42.notifyDataSetChanged();

    }
}
