package yu.ac.kr.booking0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import static yu.ac.kr.booking0.LoginActivity.loginUser;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RestaurantRegisterActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;


    EditText resName, resAddress, resNum, resSeat, resLocationX, resLocationY;
    CheckBox resGroupSeat, resParking, resPacking, resWifi, resKid;
    Button registerRestaurantButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_register);

        resName = (EditText)findViewById(R.id.resName);
        resAddress = (EditText)findViewById(R.id.resAddress);
        resNum = (EditText)findViewById(R.id.resNum);
        resSeat = (EditText)findViewById(R.id.resSeat);
        resLocationX = (EditText)findViewById(R.id.resLocationX);
        resLocationY = (EditText)findViewById(R.id.resLocationY);

        resGroupSeat = (CheckBox)findViewById(R.id.resGroupSeat);
        resParking = (CheckBox)findViewById(R.id.resParking);
        resPacking = (CheckBox)findViewById(R.id.resPacking);
        resWifi = (CheckBox)findViewById(R.id.resWifi);
        resKid = (CheckBox)findViewById(R.id.resKid);

        registerRestaurantButton = (Button)findViewById(R.id.registerRestaurantButton);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        registerRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerRestaurant();
            }
        });

    }

    private  void registerRestaurant(){

        mDatabase.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Restaurant restaurant = new Restaurant(loginUser.id ,resName.getText().toString(), resNum.getText().toString(), resAddress.getText().toString(),
                resLocationX.getText().toString(), resLocationY.getText().toString(), resSeat.getText().toString(), resGroupSeat.isChecked(),
                resParking.isChecked(), resPacking.isChecked(), resWifi.isChecked(), resKid.isChecked());

        if(resName.getText().length() > 0 && resNum.getText().length() > 0 && resSeat.getText().length() > 0 && resAddress.getText().length() > 0 &&
        resLocationX.getText().length() > 0 && resLocationY.getText().length() > 0){

            mDatabase.child("Restaurant").child(resName.getText().toString()).setValue(restaurant);
            Toast.makeText(this, "등록 성공!", Toast.LENGTH_SHORT).show();
            onBackPressed();
        } else {
            Toast.makeText(this, "요소를 모두 입력하시오", Toast.LENGTH_SHORT).show();
        }
    }
}