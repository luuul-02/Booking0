package yu.ac.kr.booking0;

import static yu.ac.kr.booking0.searchActivity.throwRestaurant;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ResListAdapter extends RecyclerView.Adapter<ResListAdapter.ResViewHolder> {

    private ArrayList<Restaurant> arrayList;
    private Context context; // 선택한 액티비디 context 가져올때

    public static Restaurant throwRestaurant2;

    public ResListAdapter(ArrayList<Restaurant> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }




    @NonNull
    @Override
    public ResViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 실제 리스트 뷰와 어댑터 연결 후 만들어짐

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_list_item,parent,false);
        ResViewHolder resViewHolder = new ResViewHolder(view);



        return resViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResViewHolder holder, int position) {

        //이미지 받아올 때 (사용X)
        //Glide.with(holder.itemView).load(arrayList.get(position).getProfile());

        holder.resNameTextView.setText(arrayList.get(position).getResName());
        holder.resNumTextView.setText(arrayList.get(position).getResPhone());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            ///////////클릭
            @Override
            public void onClick(View view) {
                throwRestaurant2 = throwRestaurant;

                Intent intent = new Intent(view.getContext(),RestaurantActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class ResViewHolder extends RecyclerView.ViewHolder {

        TextView resNameTextView, resNumTextView;




        public ResViewHolder(@NonNull View itemView) {
            super(itemView);

            this.resNameTextView = itemView.findViewById(R.id.resNameTextView);
            this.resNumTextView = itemView.findViewById(R.id.resNumTextView);

        }
    }


}
