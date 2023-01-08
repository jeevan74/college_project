package com.crrit.crrithandbook.materials.materials22;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterCategoryFacultyandStudentm22 extends Filter {

    ArrayList<ModelCategorym22> filterList;

    AdapterCategoryFacultyandStudentm22 adapterCategoryFacultyandStudentm22;

    public FilterCategoryFacultyandStudentm22(ArrayList<ModelCategorym22> filterList, AdapterCategoryFacultyandStudentm22 adapterCategoryFacultyandStudentm22) {
        this.filterList = filterList;
        this.adapterCategoryFacultyandStudentm22 = adapterCategoryFacultyandStudentm22;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if(constraint !=null&&constraint.length()>0){
            constraint = constraint.toString().toUpperCase();
            ArrayList<ModelCategorym22> filterModels = new ArrayList<>();
            for(int i=0;i<filterList.size();i++){
                if (filterList.get(i).getCategory().toUpperCase().contains(constraint)){
                    filterModels.add(filterList.get(i));

                }
            }

            results.count = filterModels.size();
            results.values = filterModels;
        }
        else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults results) {
        adapterCategoryFacultyandStudentm22.categoryArrayList1 = (ArrayList<ModelCategorym22>)results.values;
        adapterCategoryFacultyandStudentm22.notifyDataSetChanged();
    }
}
