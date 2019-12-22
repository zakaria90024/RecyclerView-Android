package com.androwep.miniappzakaria.insertupdatedelete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.androwep.miniappzakaria.R;

public class DataBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        //Toolber code
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        changePageTitle("HomePage");

    }
    public  void  changePageTitle(String title){
        setTitle(title);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu );
        return super.onCreateOptionsMenu(menu);
    }


//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        switch (menuItem.getItemId()){
//
//            case R.id.home:
//
//                changePageTitle("Home");
//                break;
//
//            case  R.id.blog:
//
//
//                changePageTitle("Blog");
//                //Toast.makeText(MainActivity.this,"blog", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.profile:
//                changePageTitle("Profile");
//                break;
//
//            default:changePageTitle("");
//        }
//        return true;
//    }




}
