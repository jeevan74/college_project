package com.crrit.crrithandbook.materials.materials22;

import android.widget.Filter;

import com.crrit.crrithandbook.models.ModelPdfm22;

import java.util.ArrayList;

public class FilterPdfAdminm22 extends Filter {
    //array list
    ArrayList<ModelPdfm22> filterList;
    //adapter
    AdapterPdfAdminm22 adapterPdfAdminm22;
    //constructor

    public FilterPdfAdminm22(ArrayList<ModelPdfm22> filterList, AdapterPdfAdminm22 adapterPdfAdminm22) {
        this.filterList = filterList;
        this.adapterPdfAdminm22 = adapterPdfAdminm22;
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

        adapterPdfAdminm22.pdfArrayList=(ArrayList<ModelPdfm22>)results.values;
        //notify changes
        adapterPdfAdminm22.notifyDataSetChanged();

    }
}
