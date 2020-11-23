package yu.ac.kr.booking0;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ManageActivity extends AppCompatActivity {

    Button btn_bookInfo,btn_seatRegist,btn_bookRegist;
    ImageView imgview_seat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        //예약정보, 좌석등록,예약등록 버튼 선언,설정
        btn_bookInfo = (Button)findViewById(R.id.btn_bookInfo);
        btn_seatRegist = (Button)findViewById(R.id.btn_seatRegist);
        btn_bookRegist = (Button)findViewById(R.id.btn_bookRegist);

        //예약정보 버튼 눌렀을 시, 예약정보 Activity 페이지로 이동
        btn_bookInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageActivity.this,ResBookInfo.class);
                startActivity(intent);

                //제목줄(ActionBar) 객체를 얻어오기
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("ResBookInfo");
            }
        });

        //좌석 등록 버튼 눌렀을 시, 좌석 등록  Activity 페이지로 이동
        btn_seatRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageActivity.this,ResSeatRegist.class);
                startActivity(intent);


                //제목줄(ActionBar) 객체를 얻어오기
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("ResSeatRegist");
            }
        });

        //예약등록 버튼 눌렀을 시, 예약등록 Activity 페이지로 이동
        btn_bookRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageActivity.this,ResBookRegist.class);
                startActivity(intent);

                //제목줄(ActionBar) 객체를 얻어오기
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("ResBookRegist");
            }
        });
    }
}