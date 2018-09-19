package com.example.zf.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;
    private Map<Integer,Boolean> map1 ;
    private Map<Integer,Boolean> map2 ;
    private  List<Fruit> fruitList;
    public FruitAdapter(Context context, int textViewResourceId,
                        List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
        fruitList = objects;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        for(int i = 0;i < objects.size();i++){
            map1.put(i,false);
            map2.put(i,false);
        }
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Fruit fruit = fruitList.get(position); // 获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById (R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById (R.id.fruit_name);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map1.put(position,true);
                map2.put(position,false);
//
                for(int i = 0; i < 10;i++){
                    if(i != position){

                        map1.put(i,false);
                        map2.put(i,false);
                    }
                }
                FruitAdapter.this.notifyDataSetChanged();
            }
        });
        viewHolder.fruitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        map1.put(position,false);
                        map2.put(position,true);
//
                        for(int i = 0; i < 10;i++){
                            if( i != position){
                                map1.put(i,false);
                                map2.put(i,false);
                            }
                        }
                        FruitAdapter.this.notifyDataSetChanged();
            }
        });



        if(map1.get(position))
            viewHolder.fruitImage.setImageResource(R.mipmap.ic_launcher);
        else
            viewHolder.fruitImage.setImageResource(R.mipmap.ic_launcher_round);

        if(map2.get(position))
            viewHolder.fruitName.setText("i am a boy");
        else
            viewHolder.fruitName.setText("i am a girl");


        return view;
    }

    class ViewHolder {

        ImageView fruitImage;

        TextView fruitName;

    }

}

