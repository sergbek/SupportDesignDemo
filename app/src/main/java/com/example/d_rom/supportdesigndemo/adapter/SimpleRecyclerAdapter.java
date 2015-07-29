package com.example.d_rom.supportdesigndemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.d_rom.supportdesigndemo.R;

import java.util.List;

public class SimpleRecyclerAdapter  extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder> {

    private final Context mContext;
    private final List<String> mData;

    public SimpleRecyclerAdapter(Context _context, List<String> _data) {
        mContext = _context;
        mData = _data;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup _viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item,_viewGroup,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder _viewHolder, int i) {
        _viewHolder.onBind();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class SimpleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIconView;
        public TextView mTitleView;

        public SimpleViewHolder(View _view) {
            super(_view);
            mIconView = (ImageView)_view.findViewById(R.id.icon);
            mTitleView = (TextView)_view.findViewById(R.id.text);
        }

        public void onBind() {
            final int position = getAdapterPosition();
//            mIconView
            mTitleView.setText(mData.get(position));
        }
    }
}