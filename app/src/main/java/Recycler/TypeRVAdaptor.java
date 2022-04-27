package Recycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maiaraalmeida_comp304_lab2_exerc01.R;

import java.util.ArrayList;

public class TypeRVAdaptor extends RecyclerView.Adapter<TypeRVAdaptor.MyViewHolder> {

    private Context context;
    private ArrayList<String> homeTypes;
    private OnItemListener myListener;

    public TypeRVAdaptor(Context context, ArrayList<String> homeTypes){
        this.context = context;
        this.homeTypes = homeTypes;
    }
    @Override
    public TypeRVAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.type_info,parent,false);
        return new TypeRVAdaptor.MyViewHolder(view, myListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeRVAdaptor.MyViewHolder holder, int position) {

        holder.txtViewHomeType.setText(homeTypes.get(position));
    }

    @Override
    public int getItemCount() {
        return homeTypes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtViewHomeType;

        public MyViewHolder(@NonNull View itemView, OnItemListener listener) {
            super(itemView);
            txtViewHomeType = itemView.findViewById(R.id.txtViewHomeType);
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