package com.crrit.crrithandbook.materials.materials22;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentm22 extends Filter {
    //array list
    ArrayList<ModelPdfm22> filterList;
    //adapter
    AdapterPdfFacultyandStudentm22 adapterPdfFacultyandStudentm22;
    //constructor

    public FilterPdfFacultyandStudentm22(ArrayList<ModelPdfm22> filterList, AdapterPdfFacultyandStudentm22 adapterPdfFacultyandStudentm22) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentm22 = adapterPdfFacultyandStudentm22;
    }

    public FilterPdfFacultyandStudentm22(ArrayList<ModelCategorym22> filterList, AdapterCategoryFacultyandStudentm22 adapterCategoryFacultyandStudentm22) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfm22> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentm22.pdfArrayList=(ArrayList<ModelPdfm22>)results.values;
        //notify changes
        adapterPdfFacultyandStudentm22.notifyDataSetChanged();

    }
}
