package com.fearlessbear.androidexperiment.arch.paging;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.fearlessbear.androidexperiment.arch.paging.model.Student;
import com.fearlessbear.androidexperiment.arch.paging.model.StudentDatabase;
import com.fearlessbear.androidexperiment.databinding.ActivityPagingListBinding;

public class PagingListActivity extends AppCompatActivity {

    private ActivityPagingListBinding binding;
    private MyAdapter mAdapter;

    private StudentViewModel mStudentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPagingListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(new MyItemCallBack());
        binding.rvList.setAdapter(mAdapter);

        StudentDatabase studentDB = Room.databaseBuilder(this, StudentDatabase.class, "student").build();
        mStudentViewModel = new StudentViewModel(studentDB.studentDao());
        mStudentViewModel.studentList.observe(this, mAdapter::submitList);

        //insertStudent();
    }

    private void insertStudent() {
        mStudentViewModel.insert();
    }

    public static class MyAdapter extends PagedListAdapter<Student, MyHolder> {
        protected MyAdapter(@NonNull DiffUtil.ItemCallback<Student> diffCallback) {
            super(diffCallback);
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_1, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            Student item = getItem(position);
            if (item != null) {
                holder.bindTo(item);
            } else {
                holder.reset();
            }
        }
    }

    public static class MyItemCallBack extends DiffUtil.ItemCallback<Student> {

        @Override
        public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return !TextUtils.isEmpty(oldItem.name) && TextUtils.equals(oldItem.name, newItem.name);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return true;
        }
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        TextView tvTxt;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvTxt = itemView.findViewById(android.R.id.text1);
        }

        public void bindTo(Student student) {
            tvTxt.setText(student.name);
        }

        public void reset() {
            tvTxt.setText("PlaceHolder");
        }
    }
}