package com.crrit.crrithandbook.materials.materials21;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crrit.crrithandbook.databinding.RowPdfFacultyAndStudentBinding;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;

public class AdapterPdfFacultyandStudentm21 extends RecyclerView.Adapter<AdapterPdfFacultyandStudentm21.HolderPdfAdmin>implements Filterable {//

    private final Context context;//context


    public ArrayList<ModelPdfm21> pdfArrayList,filterlist;//array holder


    private RowPdfFacultyAndStudentBinding binding;//vb

    private FilterPdfFacultyandStudentm21 filter;
    private static final String TAG ="PDF_ADAPTER_TAG";
    private final ProgressDialog progressDialog;

    //con
    public AdapterPdfFacultyandStudentm21(Context context1, ArrayList<ModelPdfm21> pdfArrayList) {
        this.context = context1;
        this.pdfArrayList = pdfArrayList;
        this.filterlist = pdfArrayList;
        progressDialog = new ProgressDialog(context1);
        progressDialog.setTitle("Please Wait");
        progressDialog.setCancelable(false);
    }

    @NonNull
    @Override
    public HolderPdfAdmin onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //binding
        binding = RowPdfFacultyAndStudentBinding.inflate(LayoutInflater.from(context),parent,false);


        return new HolderPdfAdmin(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPdfAdmin holder, int position) {

        //get&set data
        //get data
        ModelPdfm21 model = pdfArrayList.get(position);
        String pdfId = model.getId();
        String categoryId = model.getCategoryId();
        String title = model.getTitle();
        String description = model.getDescription();
        String pdfUrl = model.getUrl();
        long timestamp = model.getTimestamp();

        //set data
        holder.titleTv.setText(title);
        holder.descriptionTv.setText(description);



        String date = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            date = MyApplicationm21.formatTimestamp(Long.parseLong(String.valueOf(timestamp)));
        }

        holder.dateTv.setText(date);

        //load extra

        //loadCategory(model,holder);
        MyApplicationm21.loadCategory(
                ""+categoryId,
                holder.categoryTv
        );

        //loadFromUrl(model,holder);
        MyApplicationm21.loadFromUrlSinglePage(
                ""+pdfUrl,
                ""+title,
                holder.pdfView,
                holder.progressBar
        );

        //loadSize(model,holder);
        MyApplicationm21.loadSize(
                ""+pdfUrl,
                ""+title,
                holder.sizeTv
        );



        //more options edit,delete


        //change to pdf view if possible
        //openpdf
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PdfDetailedActivitym21.class);
                intent.putExtra("expId",pdfId);
                context.startActivity(intent);
            }
        });
    }
//more button


//code is removed

    @Override
    public int getItemCount() {
        return pdfArrayList.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter = new FilterPdfFacultyandStudentm21(filterlist,this);
        }
        return filter;
    }


    class HolderPdfAdmin extends RecyclerView.ViewHolder{

        //ui views
        PDFView pdfView;
        ProgressBar progressBar;
        TextView titleTv,descriptionTv,categoryTv,sizeTv,dateTv;
        ImageButton moreBtn;
        public HolderPdfAdmin(@NonNull View itemView) {
            super(itemView);

            //init
            pdfView = binding.pdfView;
            progressBar = binding.progressBar;
            titleTv = binding.titleTv;
            descriptionTv = binding.descriptionTv;
            categoryTv = binding.categoryTv;
            sizeTv = binding.sizeTv;
            dateTv = binding.dateTv;
            //moreBtn = binding.moreBtn;
        }
    }
}