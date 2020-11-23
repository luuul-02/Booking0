package yu.ac.kr.booking0.ResManage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import yu.ac.kr.booking0.R;

public class Fragment_Day extends Fragment {

    LineChart lineChart_day;

    public Fragment_Day() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//fragment_month를 view로 연결
        View view = (View) inflater.inflate(R.layout.fragment_day, container, false);

        //Line차트 선언
        lineChart_day = (LineChart) view.findViewById(R.id.linechart_day);

        //Line차트 하단의 범례 표시
        LineDataSet lineDataSet1 = new LineDataSet(dataValues2(), "일간 판매량");

        //Line차트 데이터 표시
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        lineChart_day.setData(data);
        lineChart_day.invalidate();

        //Line차트 Line 두께 조정
        lineDataSet1.setLineWidth(5);
        //Line차트 데이터 값 텍스트 크기 조정
        lineDataSet1.setValueTextSize(20);

        //fragment_month가 연결되어있는 view를 반환하여 화면에 보여줌
        return view;
    }

    //Line차트 데이터 값
    private ArrayList<Entry> dataValues2() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();

        //x축: 월, y축: 판매금액
        dataVals.add(new Entry(1, 0));
        dataVals.add(new Entry(2, 38));
        dataVals.add(new Entry(3, 4));
        dataVals.add(new Entry(4, 20));
        dataVals.add(new Entry(5, 18));
        dataVals.add(new Entry(6, 12));
        dataVals.add(new Entry(7, 28));

        //위의 Line차트 데이터 값을 화면에 보여줌
        return dataVals;

    }



}

