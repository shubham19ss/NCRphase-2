package com.e.qrscanner;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 24-06-2019.
 */

public class QrDataListGenerator extends RecyclerView.Adapter<QrDataListGenerator.DataViewHolder> {
    private List<QrData> dataList;

    public QrDataListGenerator(List<QrData> list) {
        this.dataList = list;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        DataViewHolder holder = new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_card, viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {
        QrData details = dataList.get(position);
        String type="<b>Type:<b>"+details.getType();
        String data="<b>Data<b>"+details.getData();

        dataViewHolder.typeTextView.setText(Html.fromHtml(type, Typeface.BOLD));
        dataViewHolder.descTextView.setText(Html.fromHtml(data,Typeface.BOLD));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        TextView typeTextView;
        TextView descTextView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            typeTextView = itemView.findViewById(R.id.line1);
            descTextView = itemView.findViewById(R.id.line2);
        }
    }

}
