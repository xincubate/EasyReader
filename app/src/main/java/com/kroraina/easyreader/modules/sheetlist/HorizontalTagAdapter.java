package com.kroraina.easyreader.modules.sheetlist;

import android.content.Context;
import android.support.annotation.NonNull;

import com.xincubate.lego.adapter.core.BaseAdapter;
import com.xincubate.lego.adapter.core.BaseItem;
import com.xincubate.lego.adapter.core.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class HorizontalTagAdapter extends BaseAdapter {
    private int currentSelected = 0;


    public HorizontalTagAdapter(Context context){
        super(context);
        setOnItemClickListener((item, position) -> {
            selectTag(position);
            return false;
        });
    }

    public List<String> getBeans() {
        List<String> results = new ArrayList<>();
        for (BaseItem item : getItems()){
            if (item instanceof HorizontalTagItem){
                results.add(((HorizontalTagItem) item).name);
            }
        }
        return results;
    }

    public void addItemByBeans(Context context,List<String> beans){
        for (String bean : beans){
            addItem(new HorizontalTagItem(context,bean));
        }
    }

    public void setCurrentSelected(int pos){
        selectTag(pos);
    }

    private void selectTag(int position){
        currentSelected = position;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int position) {
        super.onBindViewHolder(viewHolder, position);
        if (position == currentSelected){
            ((HorizontalTagItem)getItem(position)).setIsSelected(viewHolder);
        }
    }
}