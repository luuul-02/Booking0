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


public class Fragment_month extends Fragment {

    LineChart lineChart_month;

    public Fragment_month() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //fragment_month를 view로 연결
        View view = (View) inflater.inflate(R.layout.fragment_month, container, false);

        //Line차트 선언
        lineChart_month = (LineChart) view.findViewById(R.id.linechart_month);

        //Line차트 하단의 범례 표시
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "월별 판매량");

        //Line차트 데이터 표시
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        lineChart_month.setData(data);
        lineChart_month.invalidate();

        //Line차트 Line 두께 조정
        lineDataSet1.setLineWidth(5);
        //Line차트 데이터 값 텍스트 크기 조정
        lineDataSet1.setValueTextSize(20);

        //fragment_month가 연결되어있는 view를 반환하여 화면에 보여줌
        return view;
    }

    //Line차트 데이터 값
    private ArrayList<Entry> dataValues1() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();

        //x축: 월, y축: 판매금액
        dataVals.add(new Entry(1, 0));
        dataVals.add(new Entry(2, 1));
        dataVals.add(new Entry(3, 2));
        dataVals.add(new Entry(4, 5));
        dataVals.add(new Entry(5, 4));
        dataVals.add(new Entry(6, 12));
        dataVals.add(new Entry(7, 6));
        dataVals.add(new Entry(8, 7));
        dataVals.add(new Entry(9, 8));
        dataVals.add(new Entry(10, 10));
        dataVals.add(new Entry(11, 19));
        dataVals.add(new Entry(12, 30));

        //위의 Line차트 데이터 값을 화면에 보여줌
        return dataVals;
    }
}








