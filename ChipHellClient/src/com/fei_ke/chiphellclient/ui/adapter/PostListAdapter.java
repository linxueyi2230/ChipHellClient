
package com.fei_ke.chiphellclient.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fei_ke.chiphellclient.bean.Thread;
import com.fei_ke.chiphellclient.constant.Post;
import com.fei_ke.chiphellclient.ui.customviews.PostItemView;
import com.fei_ke.chiphellclient.ui.customviews.ThreadItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * 回帖列表适配器
 * 
 * @author 杨金阳
 * @2014-6-15
 */
public class PostListAdapter extends BaseAdapter {
    private List<Post> mPosts;

    @Override
    public int getCount() {
        return mPosts == null ? 0 : mPosts.size();
    }

    @Override
    public Post getItem(int position) {
        return mPosts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PostItemView postItemView = null;
        if (convertView == null) {
            postItemView = PostItemView.getInstance(parent.getContext());
        } else {
            postItemView = (PostItemView) convertView;
        }
        Post post = getItem(position);
        postItemView.bindValue(post);
        return postItemView;
    }

    public void update(List<Post> posts) {
        if (mPosts == null) {
            mPosts = new ArrayList<Post>();
        }/*
          * else {
          * mThreads.clear();
          * }
          */
        mPosts.addAll(posts);
        notifyDataSetChanged();
    }

    public void clear() {
        if (mPosts != null) {
            mPosts.clear();
        }
    }

}