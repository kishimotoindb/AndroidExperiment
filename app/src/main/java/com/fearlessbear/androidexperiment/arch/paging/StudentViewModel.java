package com.fearlessbear.androidexperiment.arch.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.fearlessbear.androidexperiment.arch.paging.model.Student;
import com.fearlessbear.androidexperiment.arch.paging.model.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel extends ViewModel {
    private StudentDao studentDao;
    public final LiveData<PagedList<Student>> studentList;

    public StudentViewModel(StudentDao studentDao) {
        this.studentDao = studentDao;
        studentList = new LivePagedListBuilder<>(studentDao.getDataSource(), 50).build();
    }

    public void insert() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Student> students = new ArrayList<>();
                for (int i = 0; i < 10000; i++) {
                    Student s = new Student();
                    s.name = "name_" + i;
                    students.add(s);
                }
                studentDao.insertAll(students);
            }
        }).start();

    }
}
