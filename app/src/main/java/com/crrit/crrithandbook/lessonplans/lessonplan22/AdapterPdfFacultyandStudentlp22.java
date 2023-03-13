package com.crrit.crrithandbook.lessonplans.lessonplan22;

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
import com.crrit.crrithandbook.models.ModelPdflp22;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;

public class AdapterPdfFacultyandStudentlp22 extends RecyclerView.Adapter<AdapterPdfFacultyandStudentlp22.HolderPdfAdmin>implements Filterable {//

    private final Context context;//context


    public ArrayList<ModelPdflp22> pdfArrayList,filterlist;//array holder


    private RowPdfFacultyAndStudentBinding binding;//vb

    private FilterPdfFacultyandStudentlp22 filter;
    private static final String TAG ="PDF_ADAPTER_TAG";
    private final ProgressDialog progressDialog;

    //con
    public AdapterPdfFacultyandStudentlp22(Context context1, ArrayList<ModelPdflp22> pdfArrayList) {
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
        ModelPdflp22 model = pdfArrayList.get(position);
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
            date = MyApplicationlp22.formatTimestamp(Long.parseLong(String.valueOf(timestamp)));
        }

        holder.dateTv.setText(date);

        //load extra

        //loadCategory(model,holder);
        MyApplicationlp22.loadCategory(
                ""+categoryId,
                holder.categoryTv
        );

        //loadFromUrl(model,holder);
        MyApplicationlp22.loadFromUrlSinglePage(
                ""+pdfUrl,
                ""+title,
                holder.pdfView,
                holder.progressBar
        );

        //loadSize(model,holder);
        MyApplicationlp22.loadSize(
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
                Intent intent = new Intent(context, PdfDetailedActivitylp22.class);
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
            filter = new FilterPdfFacultyandStudentlp22(filterlist,this);
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