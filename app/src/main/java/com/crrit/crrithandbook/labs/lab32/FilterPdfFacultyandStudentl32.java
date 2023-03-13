package com.crrit.crrithandbook.labs.lab32;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl32;
import com.crrit.crrithandbook.models.ModelPdfl32;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentl32 extends Filter {
    //array list
    ArrayList<ModelPdfl32> filterList;
    //adapter
    AdapterPdfFacultyandStudentl32 adapterPdfFacultyandStudentl32;
    //constructor

    public FilterPdfFacultyandStudentl32(ArrayList<ModelPdfl32> filterList, AdapterPdfFacultyandStudentl32 adapterPdfFacultyandStudentl32) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentl32 = adapterPdfFacultyandStudentl32;
    }

    public FilterPdfFacultyandStudentl32(ArrayList<ModelCategoryl32> filterList, AdapterCategoryFacultyandStudentl32 adapterCategoryFacultyandStudentl32) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl32> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentl32.pdfArrayList=(ArrayList<ModelPdfl32>)results.values;
        //notify changes
        adapterPdfFacultyandStudentl32.notifyDataSetChanged();

    }
}
