package com.crrit.crrithandbook.labs.lab11;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelCategoryl11;
import com.crrit.crrithandbook.models.ModelPdfl11;

import java.util.ArrayList;

public class FilterPdfFacultyandStudentl11 extends Filter {
    //array list
    ArrayList<ModelPdfl11> filterList;
    //adapter
    AdapterPdfFacultyandStudentl11 adapterPdfFacultyandStudentl11;
    //constructor

    public FilterPdfFacultyandStudentl11(ArrayList<ModelPdfl11> filterList, AdapterPdfFacultyandStudentl11 adapterPdfFacultyandStudentl11) {
        this.filterList = filterList;
        this.adapterPdfFacultyandStudentl11 = adapterPdfFacultyandStudentl11;
    }

    public FilterPdfFacultyandStudentl11(ArrayList<ModelCategoryl11> filterList, AdapterCategoryFacultyandStudentl11 adapterCategoryFacultyandStudentl11) {
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //value not null
        if (constraint !=null && constraint.length()>0){
            //avoid case sensitivity
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelPdfl11> filteredModels = new ArrayList<>();
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

        adapterPdfFacultyandStudentl11.pdfArrayList=(ArrayList<ModelPdfl11>)results.values;
        //notify changes
        adapterPdfFacultyandStudentl11.notifyDataSetChanged();

    }
}
