package ru.itmo.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AreaResult {
    private double x;
    private double y;
    private double r;
    private boolean isInside;
    private String currentTime;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public AreaResult(double x, double y, double r, boolean isInside) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInside = isInside;
        this.currentTime = LocalDateTime.now().format(formatter);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean getIsInside() {
        return isInside;
    }

    public String getCurrentTime() {
        return currentTime;
    }
}
