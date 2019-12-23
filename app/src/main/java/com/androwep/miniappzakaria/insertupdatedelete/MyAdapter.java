package com.androwep.miniappzakaria.insertupdatedelete;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.androwep.miniappzakaria.R;
import com.androwep.miniappzakaria.util.data.local.Student;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Student> datalist;
    private Context context;
    private MyAdapterItemClickListener listener;

    public MyAdapter(Context context, List<Student> datalist) {
        this.datalist = datalist;
    }

    //je child layout k use korbo
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    public void setListener(MyAdapterItemClickListener listener) {
        this.listener = listener;
    }

    //dataset jevabe initialize hobe
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(datalist.get(position).getName());
        holder.idTextView.setText(""+datalist.get(position).getId());
        holder.depidTextView.setText(""+datalist.get(position).getDep_id());

        holder.category.setText(""+datalist.get(position).getCategory());
        holder.price.setText(""+datalist.get(position).getPrice());
        holder.discreption.setText(""+datalist.get(position).getDiscreption());


        holder.cardViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null)
                {
                    listener.onItemClick(datalist.get(position),position);


                }
            }
        });
        holder.cardViewLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onItemLongClick(datalist.get(position),position);
                return false;
            }
        });
//        Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHWAoQ916iRw6xL3xgw8ebhq_XYl6yhiFeq1DMQuQRqLmOR7vv2g&s")
//                .into(holder.imageView);
    }

    //jotogula item create hobe
    @Override
    public int getItemCount() {
        return datalist.size();
    }

    //mapping kora
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private CardView cardViewLayout;
        private TextView idTextView;
        private TextView depidTextView;

        private TextView category;
        private TextView price;
        private TextView discreption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            cardViewLayout = itemView.findViewById(R.id.cardview);
            idTextView=itemView.findViewById(R.id.idtext);
            depidTextView=itemView.findViewById(R.id.depidtext);

            category = itemView.findViewById(R.id.categoryId);
            price = itemView.findViewById(R.id.priceId);
            discreption = itemView.findViewById(R.id.discreptionaId);
        }
    }

    public interface MyAdapterItemClickListener{
        public void onItemClick(Student item,int position);
        public void onItemLongClick(Student item,int position);
    }
}

