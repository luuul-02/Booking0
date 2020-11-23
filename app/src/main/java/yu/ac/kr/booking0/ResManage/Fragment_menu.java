package yu.ac.kr.booking0.ResManage;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import yu.ac.kr.booking0.R;


public class Fragment_menu extends Fragment {

    PieChart pieChart;
    int[] colorArray = new int[]{Color.LTGRAY, Color.BLUE, Color.RED};  //Pie차트 표시 색

    public Fragment_menu() {
        // Required empty public constructor
    }

    //Pie차트 생성 함수
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //fragment_menu를 view로 연결
        View view = (View) inflater.inflate(R.layout.fragment_menu, container, false);

        //Pie차트 선언
        pieChart =(PieChart) view.findViewById(R.id.piechart);

        //Pie차트 하단의 범례 표시
        PieDataSet pieDataSet = new PieDataSet(data1(),"");
        pieDataSet.setColors(colorArray);

        //Pie차트에 data 설정
        PieData piedata = new PieData(pieDataSet);
        pieChart.setData(piedata);
        pieChart.invalidate();

        //Pie차트 가운데 텍스트 표시, 텍스트크기, Pie차트 데이터 텍스트 크기,색 설정
        pieChart.setCenterText("메뉴별 판매량");
        pieChart.setCenterTextSize(25);
        piedata.setValueTextSize(30);
        piedata.setValueTextColor(Color.BLACK);


        //fragment_menu가 연결되어있는 view를 반환하여 화면에 보여줌
        return view;
    }

    //Pie차트 내용 입력
    private ArrayList<PieEntry> data1() {
        ArrayList<PieEntry> datavalue = new ArrayList<>();

        datavalue.add(new PieEntry(30, "크림우동"));
        datavalue.add(new PieEntry(10, "명란크림우동"));
        datavalue.add(new PieEntry(50, "타코야끼"));

        return datavalue;
    }

}
