package py.com.fuentepy.prontoshop.ui.customerlist;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import py.com.fuentepy.prontoshop.R;
import py.com.fuentepy.prontoshop.core.listeners.OnCustomerSelectedListener;
import py.com.fuentepy.prontoshop.model.Customer;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerListFragment extends Fragment implements OnCustomerSelectedListener{
    private View mRootView;
    private CustomerListAdapter mAdapter;

    @BindView(R.id.customer_list_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.empty_text)
    TextView mEmptyTextView;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    public CustomerListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_customer_list, container, false);
        ButterKnife.bind(this, mRootView);

        //setup Adapter
        List<Customer> tempCustomers = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new CustomerListAdapter(tempCustomers, getActivity(), this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        if(tempCustomers.size() < 1){
            showEmptyTextMessage();
        }else{
            hideEmptyTextMessage();
        }
        return mRootView;
    }

    private void hideEmptyTextMessage() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mEmptyTextView.setVisibility(View.GONE);
    }

    private void showEmptyTextMessage() {
        mRecyclerView.setVisibility(View.GONE);
        mEmptyTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSelectCustomer(Customer customer) {

    }

    @Override
    public void onLongClickCustomer(Customer customer) {

    }
}
