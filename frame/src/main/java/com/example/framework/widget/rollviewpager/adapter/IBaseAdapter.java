package com.example.framework.widget.rollviewpager.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class IBaseAdapter extends BaseAdapter {
	public List<?> dataList;
	public LayoutInflater factory;

	public void setData(List<?> list) {
		dataList = list;
		this.notifyDataSetChanged();
	}

	public View infateView(Context context, int resId) {
		return infateView(context, resId, null);
	}

	public View infateView(Context context, int resId, ViewGroup rootView) {
		if (factory == null) {
			factory = LayoutInflater.from(context);
		}

		return factory.inflate(resId, rootView);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataList == null ? 0 : dataList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	abstract public View getView(int position, View convertView,
			ViewGroup parent);

	@SuppressWarnings("unchecked")
	protected <T extends View> T findView(View view, int id) {

		SparseArray<View> holder = (SparseArray<View>) view.getTag();
		if (holder == null) {
			holder = new SparseArray<View>();
			view.setTag(holder);
		}

		View child = holder.get(id);
		if (child == null) {
			child = view.findViewById(id);
			holder.put(id, child);
		}

		return (T) child;
	}
}
