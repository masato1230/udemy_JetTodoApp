package com.example.jettodoapp

import androidx.room.*

@Dao
interface TaskDao {
    @Insert
    fun insertTask(task: Task)

    @Query("SELECT * FROM Task")
    fun loadAllTasks(): List<Task>

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}