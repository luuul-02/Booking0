package yu.ac.kr.booking0;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class ResBookRegist extends AppCompatActivity {

    RadioButton btn_cal,btn_time;
    DatePicker datepic;
    TimePicker timepic;
    TextView tv_year, tv_month,tv_day, tv_hour,tv_minn;
    LinearLayout layout_bookdate;
    EditText numberEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_book_regist);


        layout_bookdate = (LinearLayout)findViewById(R.id.layout_bookdate);
        btn_cal = (RadioButton)findViewById(R.id.btn_cal);
        btn_time = (RadioButton)findViewById(R.id.btn_time);

        datepic = (DatePicker)findViewById(R.id.datepic);
        timepic = (TimePicker)findViewById(R.id.timepic);

        tv_year = (TextView)findViewById(R.id.tv_year);
        tv_month = (TextView)findViewById(R.id.tv_month);
        tv_day = (TextView)findViewById(R.id.tv_day);
        tv_hour = (TextView)findViewById(R.id.tv_hour);
        tv_minn = (TextView)findViewById(R.id.tv_minn);
        numberEditText = (EditText)findViewById(R.id.numberEditText);



        btn_cal.setVisibility(View.INVISIBLE);
        btn_time.setVisibility(View.INVISIBLE);
        timepic.setVisibility(View.INVISIBLE);
        datepic.setVisibility(View.INVISIBLE);


        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepic.setVisibility(View.VISIBLE);
                datepic.setVisibility(View.INVISIBLE);
            }
        });

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepic.setVisibility(View.INVISIBLE);
                datepic.setVisibility(View.VISIBLE);
            }
        });

                btn_cal.setVisibility(View.VISIBLE);
                btn_time.setVisibility(View.VISIBLE);

        //화면 최하단의 LinearLayout (layout_bookdate) 선택시 예약 시간을 표시

        layout_bookdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_year.setText(Integer.toString(datepic.getYear()));
                tv_month.setText(Integer.toString(datepic.getMonth()));
                tv_day.setText(Integer.toString(datepic.getDayOfMonth()));

                tv_hour.setText(Integer.toString(timepic.getCurrentHour()));
                tv_minn.setText(Integer.toString(timepic.getCurrentMinute()));

                btn_cal.setVisibility(View.INVISIBLE);
                btn_time.setVisibility(View.INVISIBLE);
                datepic.setVisibility(View.INVISIBLE);
                timepic.setVisibility(View.INVISIBLE);
                numberEditText.setVisibility(View.INVISIBLE);


            }
        });

    }
}