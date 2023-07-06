package com.example.cardiac_recoder_36_39.Adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardiac_recoder_36_39.DataList;
import com.example.cardiac_recoder_36_39.R;
import com.example.cardiac_recoder_36_39.model.CardiacModel;

import java.util.ArrayList;

/**
 * CustomAdapter class is used to create a custom adapter for the recycler view
 * It is used to display the data in the recycler view
 * It is used to set the data in the recycler view
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CardiacViewHolder> {
    private static CustomClickListener customClickListener;
    private ArrayList<CardiacModel> cardiacModelsArrayList;
    private CardiacModel cardiacModel;
    private final Context context;

    /**
     * Constructor of the class
     * @param context context of the activity
     * @param rList  list of the data
     */
    public CustomAdapter(Context context, ArrayList<CardiacModel> rList) {
        this.cardiacModelsArrayList =rList;
        this.context = context;

    }

    /**
     * @param cardiacModelsArrayList list of the data
     * @param context context of the activity
     */
    public CustomAdapter(ArrayList<CardiacModel> cardiacModelsArrayList, Context context) {
        this.cardiacModelsArrayList = cardiacModelsArrayList;
        this.context = context;
    }

    /**
     * @param customClickListener custom click listener
     */
    public void setCustomClickListener(CustomClickListener customClickListener) //called from mainactivity
    {
        this.customClickListener = customClickListener; //setting data
    }

    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public CardiacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //an object of roomview holder which contain itemview
        View view = LayoutInflater.from(context).inflate(R.layout.patientsdata_row, parent, false);
        return new CardiacViewHolder(view); //passed in itemview

    }

    /**
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CardiacViewHolder holder,@SuppressLint("RecyclerView") int position) {
        if (!cardiacModelsArrayList.isEmpty()) cardiacModel = DataList.array.get(position);
        // Toast.makeText(context, ""+cardiacModel.getDate(), Toast.LENGTH_LONG).show();
        holder.dateTextView.setText("Date: "+cardiacModel.getDate());
        holder.systolicTextView.setText("Systolic: "+cardiacModel.getSystolic());
        holder.diastolicTextView.setText("Diastolic: "+cardiacModel.getDiastolic());
        holder.heartTextView.setText("Heart Rate: "+cardiacModel.getHeartRate());
        holder.deleterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customClickListener != null)
                {
                    int position = holder.getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                    {
                        customClickListener.onDeleteClick(position);
                    }
                }
            }
        });

        cardiacModel = cardiacModelsArrayList.get(position);
        if (Integer.parseInt(cardiacModel.getDiastolic())>60 && (Integer.parseInt(cardiacModel.getDiastolic())<90))holder.diastolicTextView.setTextColor(Color.parseColor("#FF018786"));
            // else if(Integer.parseInt(modelClass.getDiastolic())<89)
            // holder.tx3.setTextColor(Color.parseColor("#3C96DD"));
        else holder.diastolicTextView.setTextColor(Color.parseColor("#C36830"));


        if (Integer.parseInt(cardiacModel.getSystolic())>90 &&( Integer.parseInt(cardiacModel.getSystolic())<140)) holder.systolicTextView.setTextColor(Color.parseColor("#FF018786"));
            //else if(Integer.parseInt(modelClass.getSystolic())<=140) holder.tx2.setTextColor(Color.parseColor("#3C96DD"));
        else holder.systolicTextView.setTextColor(Color.parseColor("#C36830"));


        if (Integer.parseInt(cardiacModel.getHeartRate())>60 && Integer.parseInt(cardiacModel.getHeartRate())<100) holder.heartTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(Integer.parseInt(cardiacModel.getHeartRate())>=40) holder.heartTextView.setTextColor(Color.parseColor("#3C96DD"));
        else holder.heartTextView.setTextColor(Color.parseColor("#C36830"));


    }

    /**
     * @return Returns the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return cardiacModelsArrayList.size();
    }

    /**
     * CustomClickListener interface is used to create a custom click listener
     */
    public interface CustomClickListener {
        void customOnClick(int position, View v);

        void customOnLongClick(int position, View v);

        void onDeleteClick(int position);
        //declaring method which will provide to main activity //position and view will also be provided
    }

    /**
     * CardiacViewHolder class is used to create a view holder for the recycler view
     */
    public class CardiacViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView systolicTextView;
        TextView heartTextView;
        TextView diastolicTextView;
        TextView dateTextView;
        CardView containerCardView;
        ImageView deleterButton;

        public CardiacViewHolder(@NonNull View itemView) {
            super(itemView);
            systolicTextView = itemView.findViewById(R.id.data_systolic_txt);
            diastolicTextView = itemView.findViewById(R.id.data_diastolic_txt);
            dateTextView = itemView.findViewById(R.id.data_date_txt);
            heartTextView = itemView.findViewById(R.id.data_heartrate_txt);
            containerCardView = itemView.findViewById(R.id.llContainerCardView);
            deleterButton = itemView.findViewById(R.id.deleteButton);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        } //to create view of every list item

        /**
         * @param view The view that was clicked. //view is passed to mainactivity
         */
        @Override
        public void onClick(View view) {
            customClickListener.customOnClick(getAdapterPosition(), view);  //position and view setting to provide to mainactivity
        }

        /**
         * @param view The view that was clicked and held. //view is passed to mainactivity
         * @return true if the callback consumed the long click, false otherwise.
         */
        public boolean onLongClick(View view) {

            customClickListener.customOnLongClick(getAdapterPosition(), view);  //position and view setting to provide to mainactivity
            return true;

        }
    }
}
