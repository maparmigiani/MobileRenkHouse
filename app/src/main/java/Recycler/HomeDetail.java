package Recycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maiaraalmeida_comp304_lab2_exerc01.GetHouse;
import com.example.maiaraalmeida_comp304_lab2_exerc01.R;

import java.util.ArrayList;

public class HomeDetail extends RecyclerView.Adapter<HomeDetail.MyViewHolder> {

    private Context context;
    private ArrayList<GetHouse> homeList;
    private OnItemListener myListener;


    public HomeDetail(Context context, ArrayList<GetHouse> homeList){
        this.context = context;
        this.homeList = homeList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_info,parent,false);
        return new HomeDetail.MyViewHolder(view, myListener);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        int pos = holder.getAdapterPosition();
        GetHouse homeItem = homeList.get(pos);
        holder.txtViewAddress.setText(homeList.get(position).getAddress());
        holder.txtViewPrice.setText(String.valueOf(homeList.get(position).getPrice()));
        holder.txtViewImgPath.setText(homeList.get(position).getImgPath());
        //holder.txtViewCity.setText(homeList.get(position).getCity());
        holder.chkVirtual.setChecked(homeItem.isVisitVirtual());
        holder.chkInPerson.setChecked(homeItem.isVisitInPerson());
        Uri path = Uri.parse("android.resource://com.example.maiaraalmeida_comp304_lab2_exerc01/" + homeList.get(position).getImgPath());
        holder.imgView.setImageURI(path);

        //CheckBoxes Event Listeners
        holder.chkVirtual.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                homeItem.setVisitVirtual(check);
                Log.i("adapterPosition",String.valueOf(holder.getAdapterPosition()));
                Log.i("adapterPosition check",String.valueOf(check));

            }
        });
        holder.chkInPerson.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                homeItem.setVisitInPerson(check);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtViewAddress, txtViewPrice, txtViewImgPath, txtViewCity;
        ImageView imgView;
        CheckBox chkVirtual, chkInPerson;

        public MyViewHolder(@NonNull View itemView, OnItemListener listener) {
            super(itemView);
            txtViewAddress = itemView.findViewById(R.id.txtViewAddress);
            txtViewPrice = itemView.findViewById(R.id.txtViewPrice);
            txtViewImgPath = itemView.findViewById(R.id.txtViewImgPath);
            imgView = itemView.findViewById(R.id.imageViewRow);
            chkVirtual = itemView.findViewById(R.id.chkVirtual);
            chkInPerson = itemView.findViewById(R.id.chkInPerson);

            //Event Listeners
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener !=null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    //Creating OnItemClick Listener
    public interface OnItemListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemListener listener){
        myListener = listener;
    }
}