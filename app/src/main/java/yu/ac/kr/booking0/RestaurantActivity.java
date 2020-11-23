package yu.ac.kr.booking0;

import androidx.appcompat.app.AppCompatActivity;

import static yu.ac.kr.booking0.searchActivity.throwRestaurant;
import static yu.ac.kr.booking0.ResListAdapter.throwRestaurant2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RestaurantActivity extends AppCompatActivity {

    TextView restaurantNameTextView, restaurantPhoneTextView, addressTextView, groupSeatTextView, parkingTextView, packingTextView, wifiTextView, kidTextView;
    Button bookingButton;

    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        restaurantNameTextView = (TextView)findViewById(R.id.restaurantNameTextView);
        restaurantPhoneTextView = (TextView)findViewById(R.id.restaurantPhoneTextView);
        addressTextView = (TextView)findViewById(R.id.addressTextView);
        groupSeatTextView = (TextView)findViewById(R.id.groupSeatTextView);
        parkingTextView = (TextView)findViewById(R.id.parkingTextView);
        packingTextView = (TextView)findViewById(R.id.packingTextView);
        wifiTextView = (TextView)findViewById(R.id.wifiTextView);
        kidTextView = (TextView)findViewById(R.id.infantTextView);

        restaurantNameTextView.setText(throwRestaurant2.resName);
        restaurantPhoneTextView.setText(throwRestaurant2.resPhone);
        addressTextView.setText(throwRestaurant2.resAddress);
        /*groupSeatTextView.setText((throwRestaurant2.resGroupSeat) ? "O" : "X");
        parkingTextView.setText((throwRestaurant2.resParking) ? "O" : "X");
        packingTextView.setText((throwRestaurant2.resPacking) ? "O" : "X");
        wifiTextView.setText((throwRestaurant2.resWifi) ? "O" : "X");
        kidTextView.setText((throwRestaurant2.resInfant) ? "O" : "X");*/

        //아래로 대체
        if(throwRestaurant2.getResGroupSeat()){
            groupSeatTextView.setText("O");
        }else if(throwRestaurant2.getResGroupSeat() == false){
            groupSeatTextView.setText("X");
        }
        if(throwRestaurant2.getResParking()){
            parkingTextView.setText("O");
        }else if(throwRestaurant2.getResParking() == false){
            parkingTextView.setText("X");
        }
        if(throwRestaurant2.getResPacking()){
            packingTextView.setText("O");
        }else if(throwRestaurant2.getResPacking() == false){
            packingTextView.setText("X");
        }
        if(throwRestaurant2.getResWifi()){
            wifiTextView.setText("O");
        }else if(throwRestaurant2.getResWifi() == false){
            wifiTextView.setText("X");
        }
        if(throwRestaurant2.getResInfant()){
            kidTextView.setText("O");
        }else if(throwRestaurant2.getResInfant() == false){
            kidTextView.setText("X");
        }

        bookingButton = (Button)findViewById(R.id.bookingButton);

        mDatabase = FirebaseDatabase.getInstance().getReference("Restaurant");

        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurantActivity.this, BookingActivity.class));
            }
        });
        

    }


}