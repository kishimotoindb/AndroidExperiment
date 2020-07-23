package com.fearlessbear.androidexperiment.arch.paging.model;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM STUDENT")
    List<Student> getAll();

    @Query("SELECT * FROM STUDENT")
    DataSource.Factory<Integer, Student> getDataSource();

    @Insert
    void insertAll(List<Student> students);

    @Insert
    void insert(Student student);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);

    @Update
    void update(List<Student> students);
}
