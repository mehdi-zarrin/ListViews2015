package com.example.mehdi.listview2015;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomerListAdapter extends BaseAdapter{
    private ArrayList<Customer> customers;
    private LayoutInflater mInflater;

    public CustomerListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        customers = new ArrayList<Customer>();
    }

    public void add(Customer customer) {
        customers.add(customer);
        notifyDataSetChanged();
    }

    public void remove(Customer customer) {
        customers.remove(customer);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return customers.size();
    }

    @Override
    public Object getItem(int position) {
        return (Customer) customers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomerViewHolder viewHolder;
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new CustomerViewHolder();
            viewHolder.firstname = (TextView) convertView.findViewById(R.id.firstname);
            viewHolder.lastname  = (TextView) convertView.findViewById(R.id.lastname);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomerViewHolder) convertView.getTag();
        }

        viewHolder.firstname.setText(customers.get(position).getFirstName());
        viewHolder.lastname.setText(customers.get(position).getLastName());
        return convertView;
    }

    public class CustomerViewHolder {
        public TextView firstname;
        public TextView lastname;
    }
}
