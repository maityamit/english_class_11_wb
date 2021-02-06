package hsenglishsuggestionabenglsih11.example.class11wbenglish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QuizHomeActivity extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private ProgressDialog progressDialog;
    private DatabaseReference RootRef;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Button button;
    private TextView Quiz_Time,first,second,third;
    private String As01 = "https://docs.google.com/forms/d/e/1FAIpQLSfcyMPPJ-HIKAg-erq9IyZAj55Z_xSuH18GbykVzbHjH4_E9g/viewform?usp=sf_link";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_quiz_home );



        button = findViewById ( R.id. startquiz);
        swipeRefreshLayout = findViewById ( R.id.swipe );
        RootRef= FirebaseDatabase.getInstance ().getReference ().child ( "QuizSection" );
        progressDialog = new ProgressDialog ( QuizHomeActivity.this );
        progressDialog.setContentView ( R.layout.loading );
        progressDialog.setTitle ( "Please Wait.." );
        progressDialog.setCanceledOnTouchOutside ( false );


        Quiz_Time = findViewById ( R.id.Quiz_Fixed_Time );
        first = findViewById ( R.id.Quiz_First_Result );

        second = findViewById ( R.id.Quiz_Second_Result );

        third = findViewById ( R.id.Quiz_Third_Result );



        RetriveQUizInformstion();
        swipeRefreshLayout.setOnRefreshListener ( new SwipeRefreshLayout.OnRefreshListener () {
            @Override
            public void onRefresh() {
                RetriveQUizInformstion();
                swipeRefreshLayout.setRefreshing ( false);
            }
        } );
    }


    private void RetriveQUizInformstion() {

        progressDialog.show ();
        RootRef.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String retrieveUserNAme = dataSnapshot.child ( "condition" ).getValue ().toString ();
                String retrieveTime = dataSnapshot.child ( "TodayTime" ).getValue ().toString ();
                String retrieveFirstUserNAme = dataSnapshot.child ( "First" ).getValue ().toString ();
                String retrieveSecondUserNAme = dataSnapshot.child ( "Second" ).getValue ().toString ();
                String retrieveThirdUserNAme = dataSnapshot.child ( "Third" ).getValue ().toString ();

                Quiz_Time.setText ( retrieveTime );
                first.setText ( retrieveFirstUserNAme );

                second.setText ( retrieveSecondUserNAme );

                third.setText ( retrieveThirdUserNAme );



                if (retrieveUserNAme.equals ( "start" ))
                {
                    button.setEnabled ( true );
                    button.setAlpha ( 1 );
                    progressDialog.dismiss ();
                    Toast.makeText ( QuizHomeActivity.this, "Quiz Start", Toast.LENGTH_SHORT ).show ();

                }
                else {
                    progressDialog.dismiss ();
                    button.setAlpha ( 0.45f );
                    Toast.makeText ( QuizHomeActivity.this, "Quiz not Start", Toast.LENGTH_SHORT ).show ();
                    button.setEnabled ( false );

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss ();
            }
        } );

    }

    public void Quiz_Start(View view) {


        Intent intent = new Intent ( QuizHomeActivity.this,pdfviewActivity.class );
        intent.putExtra ( "KOR1",As01 );
        startActivity ( intent );
    }

    public void QUizGra(View view) {
        Intent intr = new Intent ( QuizHomeActivity.this,ContactUSActivity.class );
        startActivity ( intr);
    }

}