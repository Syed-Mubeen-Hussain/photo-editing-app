package com.example.photoeditingapp;

import static com.example.photoeditingapp.MainActivity.imgUri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.photoeditingapp.databinding.ActivityFinalBinding;

import java.awt.font.NumericShaper;

public class FinalActivity extends AppCompatActivity {

    ActivityFinalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFinalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);

        dsPhotoEditorIntent.setData(imgUri);
        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "MY EDITOR");
        startActivityForResult(dsPhotoEditorIntent, 200);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            switch (requestCode) {

                case 200:

                    imgUri = data.getData();

                    // handle the result uri as you want, such as display it in an imageView;

                    try {

                        binding.imgVIew.setImageURI(imgUri);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;

            }

        }

    }
}