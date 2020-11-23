package yu.ac.kr.booking0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static yu.ac.kr.booking0.LoginActivity.loginUser;
import static yu.ac.kr.booking0.searchActivity.throwRestaurant;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookingActivity extends AppCompatActivity {

    EditText numberEditText;
    CalendarView vwCalender;
    TimePicker pkTime;
    TextView txBookDateTime;
    Button bookingButton;
    ListView listview_menulist;
    MenuListAdapter adapter_menulist;

    int year, month, day;
    String[] menulist = {"크림우동","명란크림우동","타코야끼"};

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        numberEditText = (EditText)findViewById(R.id.numberEditText);
        vwCalender = (CalendarView)findViewById(R.id.vwCalender);
        pkTime = (TimePicker)findViewById(R.id.pkTime);
        txBookDateTime = (TextView)findViewById(R.id.txBookDateTime);
        bookingButton = (Button)findViewById(R.id.bookingButton);
        listview_menulist = (ListView)findViewById(R.id.listview_menulist);
        adapter_menulist = new MenuListAdapter();

        //리스트뷰가 어떤 어댑터를 사용할 지 설정
        listview_menulist.setAdapter(adapter_menulist);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        vwCalender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                year = i;
                month = i1+1;
                day = i2;
            }
        });

        bookingButton.setOnClickListener(new View.OnClickListener() { //클릭되면 받은 요소들로 파이어베이스에 저장
            @Override
            public void onClick(View view) {
                booking();
            }
        });
    }

    public void booking(){

        String dateString = year + "/" + month + "/" + day + "/ ";

        String timeString =  pkTime.getCurrentHour() + "H " + pkTime.getCurrentMinute() + "m";

        String number = numberEditText.getText().toString();

        Order order = new Order(loginUser.id, throwRestaurant.resId, number, dateString, timeString);

        mDatabase.child("Order").child(throwRestaurant.resId).setValue(order); //?

        Toast.makeText(this, "예약 완료!",Toast.LENGTH_SHORT).show();

        onBackPressed();

    }

    //메뉴 리스트를 불러오기 위한 Adapter
    class MenuListAdapter extends BaseAdapter{
        //데이터 개수를 리스트뷰에 알려주기 위한 데이터 길이 리턴
        @Override
        public int getCount() {
            return menulist.length;
        }
        //각각의 아이템을 인덱스를 통해 보내주어야 하므로 menulist[position] 을 리턴
        @Override
        public Object getItem(int position) {
            return menulist[position];
        }
        //사용한 인덱스값 리턴
        @Override
        public long getItemId(int position) {
            return position;
        }
        //데이터들이 리스트뷰에서 어떻게 보여질지 뷰 설정
        @Override
        public View getView(int position, View LinearView, ViewGroup parent) {
            TextView view_menulist = new TextView(getApplicationContext());
            view_menulist.setText(menulist[position]);
            view_menulist.setTextSize(20.0f);
            view_menulist.setTextColor(Color.BLACK);
            return view_menulist;
        }
    }

}