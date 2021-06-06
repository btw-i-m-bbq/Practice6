package com.mirea.veremeev.l.m.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val app = App()
        val db: AppDatabase = app.getInstance().getDatabase()
        val employeeDao = db.employeeDao()

        var employee: Employee? = Employee()
        employee!!.id = 1
        employee.name = "John Smith"
        employee.salary = 10000

        employeeDao!!.insert(employee)

        val employees = employeeDao.all

        employee = employeeDao.getById(1)

        employee!!.salary = 20000
        employeeDao.update(employee)
        Log.d(TAG, employee.name + " " + employee.salary)
    }
}