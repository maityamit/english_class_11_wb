package hsenglishsuggestionabenglsih11.example.class11wbenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ModelPaper extends AppCompatActivity {


    private String As01 = "",
            As02 = "",
            As03 = "",
            As04 = "",
            As05 = "";
    private ProgressDialog progressDialog;
    private DatabaseReference RootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_model_paper );

        RootRef= FirebaseDatabase.getInstance ().getReference ();
        progressDialog = new ProgressDialog ( ModelPaper.this );


        progressDialog.setContentView ( R.layout.loading );
        progressDialog.setTitle ( "Please Wait" );
        progressDialog.setCanceledOnTouchOutside ( false );
        progressDialog.setMessage ( "Tips: Please Cheak your Internet or Wi-fi Connection" );

        RetriveYouserInfo();
    }

    private void RetriveYouserInfo() {
    }


}