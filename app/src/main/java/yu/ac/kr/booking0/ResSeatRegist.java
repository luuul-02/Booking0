package yu.ac.kr.booking0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ResSeatRegist extends AppCompatActivity {

    Button btn_seatAdd,btn_seatEdit;
    ImageView imgview_seatRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_seat_regist);

        btn_seatAdd = (Button)findViewById(R.id.btn_seatAdd);
        btn_seatEdit = (Button)findViewById(R.id.btn_seatEdit);
        imgview_seatRegist = (ImageView)findViewById(R.id.imgview_seatRegist);


        btn_seatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgview_seatRegist.setVisibility(View.VISIBLE);
            }
        });

        btn_seatEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "수정을 위해 등록된 좌석을 삭제합니다", Toast.LENGTH_SHORT).show();
                imgview_seatRegist.setVisibility(View.INVISIBLE);
            }
        });
    }




}