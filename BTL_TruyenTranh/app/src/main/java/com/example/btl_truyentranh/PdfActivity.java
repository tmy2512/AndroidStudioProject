package com.example.btl_truyentranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {
    String name_pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        PDFView pdfView = findViewById(R.id.pdfview);
        Intent i = getIntent();
        if(i.getExtras() != null) {
            name_pdf = i.getStringExtra("name_pdf");
        }
        pdfView.fromAsset(name_pdf).load();
    }
}