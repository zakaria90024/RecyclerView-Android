package com.androwep.miniappzakaria.insertupdatedelete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androwep.miniappzakaria.R;
import com.androwep.miniappzakaria.util.SqliteHelper;
import com.androwep.miniappzakaria.util.data.local.Student;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DataBaseActivity extends AppCompatActivity implements View.OnClickListener, MyAdapter.MyAdapterItemClickListener {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private Button addBtn;
    private EditText nameText;
    private EditText priceText;
    private EditText discreptionText;
    private EditText categoryText;

    private final String TAG = "firstactivity";
    List<Student> students;
    private SqliteHelper dbHelper;
    private EditText depText;
    private int toUpdate=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        recyclerView = findViewById(R.id.recycerview);
        addBtn = findViewById(R.id.button);

        depText=findViewById(R.id.dep_id_edit);
        nameText = findViewById(R.id.editText);

        priceText = findViewById(R.id.product_price_editText);
        discreptionText = findViewById(R.id.product_discreptin_editText);
        categoryText = findViewById(R.id.product_category_editText);


        students = new ArrayList<>();

        mAdapter = new MyAdapter(DataBaseActivity.this, students);
        //je adapter use hobe
        recyclerView.setAdapter(mAdapter);
        //layout type jeta hobe
        recyclerView.setLayoutManager(new LinearLayoutManager(DataBaseActivity.this));

        addBtn.setOnClickListener(this);
        mAdapter.setListener(this);
        //  mAdapter.notifyDataSetChanged();
        dbHelper=new SqliteHelper(this);
        showList();

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




    @Override
    public void onClick(View v) {

        String var = nameText.getText().toString().trim();
        String depid = depText.getText().toString().trim();

        String price = priceText.getText().toString().trim();
        String discreption = discreptionText.getText().toString().trim();
        String category = categoryText.getText().toString().trim();

//        strings.add(var);
//        mAdapter.notifyDataSetChanged();
//        nameText.setText("");
        if(toUpdate==0)
        {
            dbHelper.save(var,Integer.parseInt(depid),category, price, discreption);
        }
        else {

            dbHelper.update(new Student(toUpdate,var,Integer.parseInt(depid),category,price,discreption));
            toUpdate=0;

        }
        //dbHelper.getAllStudent();
//        for(Student student:dbHelper.getAllStudent())
//        {
//            Log.d("chklog;",student.toString());
//        }
        showList();
        clearAll();
        Toast.makeText(DataBaseActivity.this,"Data Saved!",Toast.LENGTH_SHORT).show();

    }
    public void showList(){
        students.clear();
        students.addAll(dbHelper.getAllStudent());
        mAdapter.notifyDataSetChanged();
    }
    public void clearAll()
    {
        nameText.setText("");
        depText.setText("");

        priceText.setText("");
        discreptionText.setText("");
        categoryText.setText("");



        toUpdate=0;
    }
    @Override
    public void onItemClick(Student item, int position) {
        //Log.d(TAG,"Item:"+item+" Position:"+position);
        // students.remove(position);
        nameText.setText(item.getName());
        depText.setText(""+item.getDep_id());

        priceText.setText(""+item.getPrice());
        discreptionText.setText(""+item.getDiscreption());
        categoryText.setText(""+item.getCategory());

        toUpdate=item.getId();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemLongClick(Student item, int position) {
        dbHelper.delete(item.getId());
        showList();
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
