package yu.ac.kr.booking0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static yu.ac.kr.booking0.LoginActivity.loginUser;
import static yu.ac.kr.booking0.searchActivity.throwRestaurant;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    ImageView searchImageView;
    ImageView reRollImageView;
    Button myPageButton;
    Button bucketButton;
    Button btn_book;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MainActivity.this);

        myPageButton = (Button)findViewById(R.id.myPageButton);
        searchImageView = (ImageView)findViewById(R.id.searchImageView);
        reRollImageView = (ImageView)findViewById(R.id.reRollImageView);
        bucketButton = (Button)findViewById(R.id.bucketButton);
        btn_book = (Button)findViewById(R.id.btn_book);
        setTitle("메인페이지");

        if(loginUser.isBusiness() != true){
            btn_book.setVisibility(View.VISIBLE);
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();

        myPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MypageActivity.class));
            }
        });

        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, searchActivity.class));
            }
        });

        reRollImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 클릭하면 메뉴 추천 (구현 전)
            }
        });

        bucketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), bucketActivity.class);
                //startActivityForResult(intent,1001);
            }
        });

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BookingActivity.class));
            }
        });
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                //Intent intent = new Intent(getApplicationContext(), restaurantActivity.class);
               // startActivityForResult(intent,1001);
            }
        });


        //mapRestaurantShow();
        LatLng RestaurantA = new LatLng(35.832442, 128.757660);
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(RestaurantA);
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(RestaurantA, 15));

//        LatLng RestaurantB = new LatLng(35.830642, 128.754420);
//        markerOptions.position(RestaurantB);
//        markerOptions.title("식당B");
//        markerOptions.snippet("양식");
//        mMap.addMarker(markerOptions);
//
//        LatLng RestaurantC = new LatLng(35.831807, 128.760128);
//        markerOptions.position(RestaurantC);
//        markerOptions.title("식당C");
//        markerOptions.snippet("일식");
//        mMap.addMarker(markerOptions);
    }

    public void mapRestaurantShow(){
        //위치용A


        mDatabase.child("Restaurant").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Restaurant restaurant = snapshot.getValue(Restaurant.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}