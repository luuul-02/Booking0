package yu.ac.kr.booking0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class searchActivity extends AppCompatActivity {


    private EditText searchEditText;
    private ImageView searchImageView;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Restaurant> arrayList;

    public static Restaurant throwRestaurant;


    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = (EditText)findViewById(R.id.searchEditText);
        searchImageView = (ImageView)findViewById(R.id.searchImageView);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this); // context 자동 입력
        recyclerView.setLayoutManager(layoutManager);

        arrayList = new ArrayList<>(); //Restaurant 객체 잠을 어레이 리스트

        mDatabase = FirebaseDatabase.getInstance().getReference(); //연동


        adapter = new ResListAdapter(arrayList,this); //this가 oncreate에서 context로

        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });

        recyclerView.setAdapter(adapter); //리사이클러뷰에 어댑터 연결
    }


    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    private void search(){
        arrayList.clear();
        String resName1 = searchEditText.getText().toString();

        mDatabase.child("Restaurant").child(resName1).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Restaurant restaurant =  snapshot.getValue(Restaurant.class);


                if(restaurant == null) {
                    startToast("식당명을 정확히 입력해 주십시오.");


                } else if(restaurant.getResName().equals(searchEditText.getText().toString())) {
                    throwRestaurant = restaurant;
                    arrayList.add(restaurant);
                    adapter.notifyDataSetChanged();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 에러
                Log.e("searchActivity", String.valueOf(error.toException()));
                startToast("에러!");
            }
        });
    }


}