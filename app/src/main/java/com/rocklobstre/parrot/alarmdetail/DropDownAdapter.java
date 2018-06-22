package com.rocklobstre.parrot.alarmdetail;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rocklobstre.parrot.R;

/**
 * @author Anthony Fermin (Fuzz)
 */
public class DropDownAdapter extends RecyclerView.Adapter<DropDownAdapter.StandViewHolder> {

    private final ViewActions actionViewDelegate;
    private final int numOfStands;

    public DropDownAdapter(final ViewActions actionViewDelegate, int size) {
        this.actionViewDelegate = actionViewDelegate;
        this.numOfStands = size;
    }

    @Override
    public StandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drop_down, parent, false);
        return new StandViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StandViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numOfStands;
    }

    class StandViewHolder extends RecyclerView.ViewHolder {

        private final TextView standTitleTV;

        public StandViewHolder(View itemView) {
            super(itemView);
            standTitleTV = (TextView) itemView.findViewById(R.id.cell_stand_title);
            itemView.setBackgroundDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.stand_drop_down_selector));
            itemView.setOnClickListener(standViewItemClickListener);
        }

        public void bind(int position) {
            standTitleTV.setText(actionViewDelegate.getStandTitle(position));
            itemView.setSelected(actionViewDelegate.getSelectedStand() == position);
        }

        private final View.OnClickListener standViewItemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lastSelectedPosition = actionViewDelegate.getSelectedStand();
                actionViewDelegate.setSelectedStand(getAdapterPosition());
                notifyItemChanged(lastSelectedPosition);
                notifyItemChanged(getAdapterPosition());
                actionViewDelegate.collapseDropDown();
            }
        };
    }

    interface ViewActions {
        void collapseDropDown();
        void setSelectedStand(int standId);
        String getStandTitle(int standId);
        int getSelectedStand();
    }
}