package com.example.m6l2a2;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import android.widget.Toast;
import android.widget.Button;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // Default file name
    private static final String FILE_NAME = "dog";
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button_save);
        btn.setOnClickListener(view -> {

                // To save to storage
                FileOutputStream fileOutputStream = null;
                // Get image view  as BitmapDrawable
                @SuppressLint("UseCompatLoadingForDrawables") BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable(R.drawable.d69);
                // convert bitmap drawable to bitmap
                Bitmap data = bitmapDrawable.getBitmap();

                try {
                    //Assign file name nad its privacy mode
                    fileOutputStream = openFileOutput(FILE_NAME+".jpg", MODE_PRIVATE);
                    //Save image to FileOutputStream
                    data.compress(Bitmap.CompressFormat.JPEG,50, fileOutputStream);

                    // Toast about where file is saved
                    Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME+".jpg",
                            Toast.LENGTH_LONG).show();

                } catch (IOException e)
                {
                    e.printStackTrace();
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            // close output stream
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

        });
    }




}