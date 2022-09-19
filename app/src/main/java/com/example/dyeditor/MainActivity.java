package com.example.dyeditor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dyeditor.databinding.ActivityMainBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public static Uri imgUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Opening Gallery!", Toast.LENGTH_SHORT).show();
//                imageChooser();
                ImagePicker.Companion.with(MainActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       try {
            imgUri = data.getData();
           if(!imgUri.equals(""))
           startActivity(new Intent(MainActivity.this,finalactivity.class));
       }
       catch(Exception e){

       }
        
    }
}