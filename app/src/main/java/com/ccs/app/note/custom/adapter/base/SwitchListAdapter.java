package com.ccs.app.note.custom.adapter.base;

import android.view.View;

public abstract class SwitchListAdapter<Item, VH extends SwitchListAdapter.ViewHolder<Item, ?>>
        extends ListAdapter<Item, VH> {

    public static final int LIST_VIEW = 1;
    public static final int GRID_VIEW = 2;

    public static String getTypeView(int typeView) {
        switch (typeView) {
            case LIST_VIEW:
                return "LIST_VIEW";

            case GRID_VIEW:
                return "GRID_VIEW";

            default:
                return "LIST_VIEW";
        }
    }

    private int typeView;

    public SwitchListAdapter(OnItemClickListener onItemClickListener) {
        super(onItemClickListener);
    }

    public int getTypeView() {
        return typeView;
    }

    public void setTypeView(int typeView) {
        this.typeView = typeView;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        switch (getTypeView()) {
            case LIST_VIEW:
                return getItemListLayoutId(viewType);

            case GRID_VIEW:
                return getItemGridLayoutId(viewType);

            default:
                return getItemListLayoutId(viewType);
        }
    }

    protected abstract int getItemListLayoutId(int viewType);

    protected abstract int getItemGridLayoutId(int viewType);

    public static class ViewHolder<Item, RA extends SwitchListAdapter<Item, ?>>
            extends ListAdapter.ViewHolder<Item, RA> {

        public ViewHolder(RA adapter, View itemView) {
            super(adapter, itemView);
        }
    }
}
