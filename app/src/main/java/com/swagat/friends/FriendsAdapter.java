package com.swagat.friends;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {

    private final ArrayList<FriendsData> friendsData;
    private LayoutInflater mInflater;



    public FriendsAdapter(Context context, ArrayList<FriendsData> friendsData) {
        this.friendsData = friendsData;
        this.mInflater = LayoutInflater.from(context);
   }
    class FriendsViewHolder extends RecyclerView.ViewHolder {
        public final TextView friendItemview;
        public final CircleImageView imageView;
        final FriendsAdapter mAdapter;


        public FriendsViewHolder(View itemView, FriendsAdapter adapter){
            super(itemView);
            friendItemview = itemView.findViewById(R.id.tvitem);
            imageView = itemView.findViewById(R.id.imageView);
            this.mAdapter = adapter;
        }
    }



    @NonNull
    @Override
    public FriendsAdapter.FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.friend_item,
                parent, false);
        return new FriendsViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsAdapter.FriendsViewHolder holder, int position) {
        String mCurrent = friendsData.get(position).getName();
        holder.friendItemview.setText(mCurrent);
        String mUrl = friendsData.get(position).getUrl();
        Glide.with(mInflater.getContext()).load(friendsData.get(position).getUrl()).into(holder.imageView);



        holder.friendItemview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(mInflater.getContext(),FriendsWindow.class);
                i.putExtra("name",mCurrent);
                Log.d("name", mCurrent);
                i.putExtra("photo",mUrl);
                Log.d("photo","mUrl");




                mInflater.getContext().startActivity(i);


            }
        });




    }

    @Override
    public int getItemCount() {
        return friendsData.size();
    }
}
