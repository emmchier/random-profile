package com.example.emmchierchie.randomprofiles.View.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.emmchierchie.randomprofiles.Model.POJO.User;
import com.example.emmchierchie.randomprofiles.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerViewUsers extends RecyclerView.Adapter  {

    private List<User> userList;
    private UserListener userListener;

    public AdapterRecyclerViewUsers(UserListener userListener) {
        this.userList = new ArrayList<>();
        this.userListener = userListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View cell = layoutInflater.inflate(R.layout.user_cell,parent,false);
        ViewHolder viewHolder = new ViewHolder(cell);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = userList.get(position);
        ViewHolder userViewHolder = (ViewHolder) holder;
        userViewHolder.loadUser(user);
    }
    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void updateUserList(List<User> list) {
        userList.clear();
        userList.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewUserImage;
        private TextView textViewFirstName;
        private TextView textViewLastName;

        public ViewHolder(final View itemView) {
            super(itemView);
            imageViewUserImage = itemView.findViewById( R.id.imageViewUserImage);
            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userListener.showUserDetail(userList.get(getAdapterPosition()));
                }
            });
        }
        public void loadUser(User user) {
            Glide.with(itemView.getContext()).load(user.getPicture().getLarge()).into(imageViewUserImage);
            textViewFirstName.setText(user.getName().getFirst());
            textViewLastName.setText(user.getName().getLast());
        }
    }
    public interface UserListener {
        void showUserDetail(User user);
    }
}
