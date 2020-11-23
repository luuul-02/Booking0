package yu.ac.kr.booking0;

import androidx.appcompat.app.AppCompatActivity;
//중요!
import static yu.ac.kr.booking0.LoginActivity.loginUser;
//
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import yu.ac.kr.booking0.ResManage.PaymethodEditActivity;
import yu.ac.kr.booking0.ResManage.RestaurantManageActivity;

public class MypageActivity extends AppCompatActivity {

    TextView nameTextView, emailTextView, phoneTextView, pointTextView;
    Button btHistory, btManage, btResReg,btResBook,btResPayReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        emailTextView = (TextView)findViewById(R.id.emailTextView);
        nameTextView = (TextView)findViewById(R.id.nameTextView);
        phoneTextView = (TextView)findViewById(R.id.phoneTextView);
        pointTextView = (TextView)findViewById(R.id.pointTextView);

        btHistory = (Button)findViewById(R.id.btHistory);
        btManage = (Button)findViewById(R.id.btManage);
        btResReg = (Button)findViewById(R.id.btResReg);
        btResBook = (Button)findViewById(R.id.btResBook);
        btResPayReg = (Button)findViewById(R.id.btResPayReg);

        //emailTextView.setText();

        emailTextView.setText(loginUser.id);
        nameTextView.setText(loginUser.name);
        phoneTextView.setText(loginUser.phoneNumber);
        pointTextView.setText(loginUser.point);

        if(loginUser.isBusiness() == true){
            btResReg.setVisibility(View.VISIBLE);
            btManage.setVisibility(View.VISIBLE);
            btResBook.setVisibility(View.VISIBLE);
            btResPayReg.setVisibility(View.VISIBLE);
        }


        btHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MypageActivity.this, HistoryActivity.class));
            }
        });

        btManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MypageActivity.this, RestaurantManageActivity.class));
            }
        });

        btResReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MypageActivity.this, RestaurantRegisterActivity.class));
            }
        });

        btResBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MypageActivity.this,  ManageActivity.class));
            }
        });
        btResPayReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MypageActivity.this,  PaymethodEditActivity.class));
            }
        });
    }
}