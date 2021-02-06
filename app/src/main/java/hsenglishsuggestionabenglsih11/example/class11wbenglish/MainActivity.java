package hsenglishsuggestionabenglsih11.example.class11wbenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private LinearLayout notifications,class11,about,contact,QUiz,mainnee;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;
    private String versions = "1.0";
    private TextView version;
    private String currentUserID;
    private ProgressDialog progressDialog;
    private DatabaseReference UserRef,VersionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        notifications = findViewById ( R.id.notifications );
        class11 = findViewById ( R.id.class11);
        RootRef= FirebaseDatabase.getInstance ().getReference ();
        about = findViewById ( R.id.about);
        contact = findViewById ( R.id.cotacts);
        QUiz = findViewById ( R.id.problems_quiz );
        mainnee = findViewById ( R.id.problems_quiz_main );


        UserRef= FirebaseDatabase.getInstance ().getReference ().child ( "Users" );
        VersionRef= FirebaseDatabase.getInstance ().getReference ();
        version = findViewById ( R.id.versionCode );
        mAuth = FirebaseAuth.getInstance ();
        progressDialog = new ProgressDialog ( MainActivity.this );

        progressDialog.setContentView ( R.layout.loading );
        progressDialog.setTitle ( "Please Wait.." );

        progressDialog.setCanceledOnTouchOutside ( false );


        try {
            PackageInfo packageInfo = getPackageManager ().getPackageInfo ( getPackageName (),0 );
            versions = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace ();
        }

        version.setText ( versions );


        QUiz.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intentuu = new Intent ( MainActivity.this,PastyearmainhomeActivity.class );
                startActivity ( intentuu );
            }
        } );

        mainnee.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent ( MainActivity.this,QuizHomeActivity.class );
                startActivity ( inte );
            }
        } );



        notifications.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( MainActivity.this,NotificationActivity.class );
                startActivity ( intent );
            }
        } );


        class11.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intenter = new Intent ( MainActivity.this,Class11HomeActivity.class );
                startActivity ( intenter );
            }
        } );


        about.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intentrrttt = new Intent ( MainActivity.this,AboutusActivity.class );
                startActivity ( intentrrttt);
            }
        } );

        contact.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intentrrtty = new Intent ( MainActivity.this,ContactUSActivity.class );
                startActivity ( intentrrtty);
            }
        } );




    }









    public void GooglePLay(View view) {

        Intent sendIntent = new Intent (  Intent.ACTION_SEND);
        sendIntent.putExtra ( Intent.EXTRA_TEXT,
                "\n\nPlease Download HS Class 11 English Suggestion From Google PlayStore:-\n" +
                        "\n\nhttps://play.google.com/store/apps/details?id=hsfinheejeamitjeeelenglishcshumnagamaortk.example.wbchseclass11english");
        sendIntent.putExtra ( Intent.EXTRA_SUBJECT,"WBCHSE Physics Life App" );
        sendIntent.setType ( "text/plain" );
        Intent shareIntent = Intent.createChooser ( sendIntent,"WBCHSE Physics Life App" );
        startActivity ( shareIntent );
    }

    public void ProblemModelPage(View view) {
        Toast.makeText ( this, "In January Model Question will ready", Toast.LENGTH_SHORT ).show ();
    }
}