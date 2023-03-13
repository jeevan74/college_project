package com.crrit.crrithandbook.materials.materials31;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategorym31;
import com.crrit.crrithandbook.models.ModelPdfm31;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentm31 extends Filter {
    //array list
    ArrayList<ModelPdfm31> filterList;
    //adapter
    AdapterPdfFacultyandStudentm31 adapterPdfFacultyandStudentm31;
    //constructor

    public FilterPdfFacultyandStudentm31(ArrayList<ModelPdfm31> filterList, AdapterPdfFacultyandStudentm31 adapterPdfFacultyandStudentm31) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentm31 = adapterPdfFacultyandStudentm31;
    }

    public FilterPdfFacultyandStudentm31(ArrayList<ModelCategorym31> filterList, AdapterCategoryFacultyandStudentm31 adapterCategoryFacultyandStudentm31) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm31> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentm31.pdfArrayList=(ArrayList<ModelPdfm31>)results.values;
        //notify changes
        adapterPdfFacultyandStudentm31.notifyDataSetChanged();

    }
}
