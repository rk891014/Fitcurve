package com.example.girls_fitness;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


public class uploadvideo extends AppCompatActivity {
    FirebaseStorage storage;

        private Button btnUpload;
        private Uri videouri;
        private static final int REQUEST_CODE = 101;
        private StorageReference videoref;
        private Button btn;
        private VideoView videoView;
        private static final String VIDEO_DIRECTORY = "/demonuts";
        private int GALLERY = 1, CAMERA = 2;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_uploadvideo);

            StorageReference storageRef = FirebaseStorage.getInstance().getReference();
            videoref =storageRef.child("/videos" +"/userIntro.3gp");

            btn = (Button) findViewById(R.id.btn);
            videoView = (VideoView) findViewById(R.id.iv);
            btnUpload = (Button) findViewById(R.id.btnUpload);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPictureDialog();
                }
            });

            btnUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uploadVideo();
                }
            });



        }

        private void showPictureDialog() {
            AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
            pictureDialog.setTitle("Select Action");
            String[] pictureDialogItems = {
                    "Select video from gallery",
                    "Record video from camera"};
            pictureDialog.setItems(pictureDialogItems,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    chooseVideoFromGallary();
                                    break;
                                case 1:
                                    record();
                                    break;
                            }
                        }
                    });
            pictureDialog.show();
        }

        public void chooseVideoFromGallary() {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);

            startActivityForResult(galleryIntent, GALLERY);
        }

        public void record() {
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(intent, REQUEST_CODE);

        }



        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {

            videouri = data.getData();
            if (requestCode == GALLERY && resultCode == RESULT_OK
                    && data != null && data.getData() != null) {



                    videoView.setVideoURI(videouri);
                    videoView.requestFocus();
                    videoView.start();

                }else if (requestCode == REQUEST_CODE) {
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, "Video saved to:\n" +
                            videouri, Toast.LENGTH_LONG).show();
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "Video recording cancelled.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Failed to record video",
                            Toast.LENGTH_LONG).show();
                }
            }

            }





   public void uploadVideo() {

           if (videouri != null) {
               final ProgressDialog progressDialog = new ProgressDialog(this);
               progressDialog.setTitle("Uploading...");
               progressDialog.show();

               UploadTask uploadTask = videoref.putFile(videouri);

               uploadTask.addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Toast.makeText(uploadvideo.this,
                               "Upload failed: " + e.getLocalizedMessage(),
                               Toast.LENGTH_LONG).show();

                   }
               }).addOnSuccessListener(
                       new OnSuccessListener<UploadTask.TaskSnapshot>() {
                           @Override
                           public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                               Toast.makeText(uploadvideo.this, "Upload complete",
                                       Toast.LENGTH_LONG).show();
                           }
                       }).addOnProgressListener(
                       new OnProgressListener<UploadTask.TaskSnapshot>() {
                           @Override
                           public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                               double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                       .getTotalByteCount());
                               progressDialog.setMessage("Uploaded "+(int)progress+"%");
                           }
                       });
           } else {
               Toast.makeText(uploadvideo.this, "Nothing to upload",
                       Toast.LENGTH_LONG).show();
           }
       }






}