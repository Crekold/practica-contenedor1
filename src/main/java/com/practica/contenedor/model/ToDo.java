package com.practica.contenedor.model;

import java.util.Date;

public class ToDo {
    private Long taskId;
    private String name;
    private Date dueDate;
    private String status;

    public ToDo(Long taskId, String name, Date dueDate, String status) {
        this.taskId = taskId;
        this.name = name;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
