package com.crrit.crrithandbook.syllabus;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.crrit.crrithandbook.databinding.RowPdfAdminsyllabusBinding;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;

public class AdapterPdfAdminSyllabus extends RecyclerView.Adapter<AdapterPdfAdminSyllabus.HolderPdfAdmin> implements Filterable {//

    private Context context;//context
    public ArrayList<ModelPdfSyllabus> pdfArrayList,filterlist;//array holder
    private RowPdfAdminsyllabusBinding binding;//vb
    private FilterPdfAdminSyllabus filter;
    private static final String TAG ="PDF_ADAPTER_TAG";
    private ProgressDialog progressDialog;

    //con
    public AdapterPdfAdminSyllabus(Context context1, ArrayList<ModelPdfSyllabus> pdfArrayList) {
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
        binding = RowPdfAdminsyllabusBinding.inflate(LayoutInflater.from(context),parent,false);


        return new HolderPdfAdmin(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPdfAdmin holder, int position) {

        //get&set data
        //get data
        ModelPdfSyllabus model = pdfArrayList.get(position);
        String pdfId = model.getId();
        String categoryId = model.getCategoryId();
        String title = model.getTitle();
        String description = model.getDescription();
        String pdfUrl = model.getUrl();
        long timestamp = model.getTimestamp();

        //set data
        holder.titleTv.setText(title);


        String date = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            date = MyApplicationSyllabus.formatTimestamp(Long.parseLong(String.valueOf(timestamp)));
        }


        holder.dateTv.setText(date);

        //load extra

        //loadCategory(model,holder);
        MyApplicationSyllabus.loadCategory(
                ""+categoryId,
                holder.categoryTv
        );

        //loadFromUrl(model,holder);
        MyApplicationSyllabus.loadFromUrlSinglePage(
                ""+pdfUrl,
                ""+title,
                holder.pdfView,
                holder.progressBar
        );

        //loadSize(model,holder);
        MyApplicationSyllabus.loadSize(
                ""+pdfUrl,
                ""+title,
                holder.sizeTv
        );



        //more options edit,delete
        holder.moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moreOptionsDalog(model,holder);
            }
        });

        //change to pdf view if possible
        //openpdf
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PdfDetailedActivitySyllabus.class);
                intent.putExtra("expId",pdfId);
                context.startActivity(intent);
            }
        });

    }



    private void moreOptionsDalog(ModelPdfSyllabus model, HolderPdfAdmin holder) {

        String expId = model.getId();
        String expUrl = model.getUrl();
        String expTitle = model.getTitle();

        String[] options = {"Edit","Delete"};

        //Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose Options")
                .setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //action
                        if (which==0){
                            //edit
                            Intent intent = new Intent(context, PdfEditActivitySyllabus.class);
                            intent.putExtra("expId",expId);
                            context.startActivity(intent);
                        }
                        else if (which==1){
                            //delete
                            MyApplicationSyllabus.deleteExp(
                                    context,
                                    ""+expId,
                                    ""+expUrl,
                                    ""+expTitle
                            );
                            //deleteExp(model,holder);
                        }
                    }
                })
                .show();
    }

//code is removed

    @Override
    public int getItemCount() {
        return pdfArrayList.size();
    }

    //filter method
    @Override
    public Filter getFilter() {
        if (filter == null){
            filter = new FilterPdfAdminSyllabus(filterlist,this);
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

            categoryTv = binding.categoryTv;
            sizeTv = binding.sizeTv;
            dateTv = binding.dateTv;
            moreBtn = binding.moreBtn;
        }
    }
}