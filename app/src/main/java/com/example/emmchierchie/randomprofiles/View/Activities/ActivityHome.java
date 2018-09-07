package com.example.emmchierchie.randomprofiles.View.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.example.emmchierchie.randomprofiles.Controller.UserController;
import com.example.emmchierchie.randomprofiles.Model.POJO.User;
import com.example.emmchierchie.randomprofiles.Model.ResultListener;
import com.example.emmchierchie.randomprofiles.R;
import com.example.emmchierchie.randomprofiles.View.Adapters.AdapterRecyclerViewUsers;
import java.util.List;

public class ActivityHome extends AppCompatActivity implements AdapterRecyclerViewUsers.UserListener {

    private RecyclerView recyclerViewUsers;
    private AdapterRecyclerViewUsers adapterRecyclerViewUsers;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome to Random Profiles!");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        // recyclerview
        recyclerViewUsers = findViewById(R.id.recyclerViewUsers);
        adapterRecyclerViewUsers = new AdapterRecyclerViewUsers(this);
        recyclerViewUsers.setAdapter(adapterRecyclerViewUsers);

        // galería en grid
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewUsers.setLayoutManager(layoutManager);
        recyclerViewUsers.setHasFixedSize(true);
        loadUserList();
    }

    // cargamos la lista de usuarios al adapter
    private void loadUserList(){
        UserController userController = new UserController();
        userController.getUserResults(new ResultListener<List<User>>() {
            @Override
            public void finish(List<User> results) {
                adapterRecyclerViewUsers.updateUserList(results);
            }
        });
    }

    // ir al detalle de la celda
    @Override
    public void showUserDetail(User user) {
        Intent intent = new Intent(this, ActivityDetail.class);
        Bundle bundle = new Bundle();
        bundle.putString(ActivityDetail.FIRST_NAME, user.getName().getFirst());
        bundle.putString(ActivityDetail.LAST_NAME, user.getName().getLast());
        bundle.putString(ActivityDetail.EMAIL, user.getEmail());
        bundle.putString(ActivityDetail.USERNAME, user.getLogin().getUsername());
        bundle.putString(ActivityDetail.PICTURE, user.getPicture().getLarge());
        intent.putExtras(bundle );
        startActivity(intent);
    }
}
