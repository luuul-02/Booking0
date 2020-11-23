
package yu.ac.kr.booking0.ResManage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import yu.ac.kr.booking0.R;

//Tab레이아웃 사용위한 추가 코드

//차트 사용위한 추가 코드 (MPAndroidChart import)


public class RestaurantManageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_manage);

        //메뉴별/월별/일별 판매량/ 리뷰 페이지로 이동하기 위한 viewpager 설정과 adapter 설정
        ViewPager vp = findViewById(R.id.resmanage_viewpager);
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

        // tab table과 연동
        TabLayout tab = findViewById(R.id.resmanage_tab);
        tab.setupWithViewPager(vp);
        for(int i=0;i<4;i++) tab.getTabAt(i);

    }
}
