package com.crrit.crrithandbook.labs.lab31;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl31;
import com.crrit.crrithandbook.models.ModelPdfl31;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentl31 extends Filter {
    //array list
    ArrayList<ModelPdfl31> filterList;
    //adapter
    AdapterPdfFacultyandStudentl31 adapterPdfFacultyandStudentl31;
    //constructor

    public FilterPdfFacultyandStudentl31(ArrayList<ModelPdfl31> filterList, AdapterPdfFacultyandStudentl31 adapterPdfFacultyandStudentl31) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentl31 = adapterPdfFacultyandStudentl31;
    }

    public FilterPdfFacultyandStudentl31(ArrayList<ModelCategoryl31> filterList, AdapterCategoryFacultyandStudentl31 adapterCategoryFacultyandStudentl31) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl31> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentl31.pdfArrayList=(ArrayList<ModelPdfl31>)results.values;
        //notify changes
        adapterPdfFacultyandStudentl31.notifyDataSetChanged();

    }
}
