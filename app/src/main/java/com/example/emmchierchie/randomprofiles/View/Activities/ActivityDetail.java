package com.example.emmchierchie.randomprofiles.View.Activities;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.emmchierchie.randomprofiles.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDetail extends AppCompatActivity {

    public static final String PICTURE = "PICTURE";
    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String USERNAME = "USERNAME";
    public static final String EMAIL = "EMAIL";

    private String picture;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    // uso ButterKnife para llamar y crear la vista en 2 lineas
    @BindView(R.id.imageViewUserPicture)
    ImageView imageViewUserPicture;

    @BindView(R.id.textViewFirstName)
    TextView textViewFirstName;

    @BindView(R.id.textViewLastName)
    TextView textViewLastName;

    @BindView(R.id.textViewUsername)
    TextView textViewUsername;

    @BindView(R.id.textViewUserEmail)
    TextView textViewUserEmail;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        // variables en las que guardo lo que recibo por bundle
        if(bundle != null){
            picture = bundle.getString(PICTURE);
            firstName = bundle.getString(FIRST_NAME);
            lastName = bundle.getString(LAST_NAME);
            username = bundle.getString(USERNAME);
            email = bundle.getString(EMAIL);
        }
        UpdateResults();

        // toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Follow me");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // back button
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // floating action button
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "You are following " + firstName + " now. Let´s meeting!", Snackbar.LENGTH_LONG ).show();
            }
        } );
    }

    // seteamos las vistas
    private void UpdateResults() {
        Glide.with(this).load(picture).into(imageViewUserPicture);
        textViewFirstName.setText(firstName);
        textViewLastName.setText(lastName);
        textViewUsername.setText(username);
        textViewUserEmail.setText(email);
    }
}
