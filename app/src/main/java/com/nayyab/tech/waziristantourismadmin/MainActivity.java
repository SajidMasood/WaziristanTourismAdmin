package com.nayyab.tech.waziristantourismadmin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;

    /*private DatabaseReference mReference;
    private StorageReference  storageReference;
    private ImageView imageNo1,imageNo2,imageNo3,imageNo4;
    private EditText edtSummary, edtName;
    private Button btnUpload;
    private Uri imageUri;
    private ProgressDialog progressDialog;
    private ArrayList imageList;*/


    // Second Code ............
    /*private Button btnUpload;
    private ImageView imageNo1;
    private Uri imageUri;
    private ArrayList<Uri> imageList;
    private ProgressDialog progressDialog;
    private int upload_count = 0;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Secoond Code////////////////
        /*imageNo1 = findViewById(R.id.imageNo1);
        btnUpload = findViewById(R.id.btn_Upload);
        imageList = new ArrayList<Uri>();
        progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setMessage("Images Uplaoding Please Wait!");

        imageNo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent, PICK_IMAGE);
            }
        });





        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                StorageReference ImageFolder = FirebaseStorage.getInstance().getReference().child("Razmak");

                for (upload_count=0; upload_count<imageList.size(); upload_count++){
                    Uri individualImage = imageList.get(upload_count);
                    StorageReference imageName = ImageFolder.child("Image"+individualImage.getLastPathSegment());

                    imageName.putFile(individualImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            imageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String url = String.valueOf(uri);
                                    StoreLink(url);
                                }
                            });
                        }
                    });
                }
            }
        });*/










        /*mReference = FirebaseDatabase.getInstance().getReference("Image");
        storageReference = FirebaseStorage.getInstance().getReference();
        imageNo1 = findViewById(R.id.imageNo1);
        imageNo2 = findViewById(R.id.imageNo2);
        imageNo3 = findViewById(R.id.imageNo3);
        imageNo4 = findViewById(R.id.imageNo4);
        edtName  = findViewById(R.id.txt_name);
        edtSummary = findViewById(R.id.txt_summary);
        btnUpload  = findViewById(R.id.btn_Upload);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("ProgressDialog bar example");

        imageNo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallaryIntent = new Intent();
                gallaryIntent.setAction(Intent.ACTION_GET_CONTENT);
                gallaryIntent.setType("image/*");
                startActivityForResult(gallaryIntent, 2);
            }
        });
        imageNo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallaryIntent = new Intent();
                gallaryIntent.setAction(Intent.ACTION_GET_CONTENT);
                gallaryIntent.setType("image/*");
                startActivityForResult(gallaryIntent, 2);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageUri != null){
                    upLoadToFirebase(imageUri);
                }else {
                    Toast.makeText(getApplicationContext(), "Please Select Image", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    // second Code
    /*private void StoreLink(String url) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Razmak");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ImageLink", url);
        databaseReference.push().setValue(hashMap);
        progressDialog.dismiss();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE){
            if (resultCode == RESULT_OK){
                if (data.getClipData() != null){
                    int countClipData = data.getClipData().getItemCount();
                    int currentImageSelect = 0;
                    while (currentImageSelect < countClipData){
                        imageUri = data.getClipData().getItemAt(currentImageSelect).getUri();
                        imageList.add(imageUri);
                        currentImageSelect = currentImageSelect +1;
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please Select Multiple Images", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
*/









    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null){

            imageUri = data.getData();
            imageNo1.setImageURI(imageUri);
        }
    }


    private void upLoadToFirebase(Uri uri){
        StorageReference fileRef = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(uri));
        fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        ModelClass modelClass = new ModelClass("Makin","Green Makin",uri.toString());
                        String modelId = mReference.push().getKey();
                        mReference.child(modelId).setValue(modelClass);
                        Toast.makeText(getApplicationContext(), "Uploaded Successfully !", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                progressDialog.show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Uploading Failed !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getFileExtension(Uri mUri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));
    }*/
}