package com.yusufislamdemir.weatherapi.entity;

import java.util.ArrayList;

public class Weather {
    private Location location;
    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
    public static class Condition{
        private String text;
        private String icon;
        private int code;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
    public static class Day{
        private double maxtemp_c;
        private double mintemp_c;
        private Condition condition;
        private int uv;

        public double getMaxtemp_c() {
            return maxtemp_c;
        }

        public void setMaxtemp_c(double maxtemp_c) {
            this.maxtemp_c = maxtemp_c;
        }

        public double getMintemp_c() {
            return mintemp_c;
        }

        public void setMintemp_c(double mintemp_c) {
            this.mintemp_c = mintemp_c;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public int getUv() {
            return uv;
        }

        public void setUv(int uv) {
            this.uv = uv;
        }
    }
    public static class Forecast{
        private ArrayList<Forecastday> forecastday;

        public ArrayList<Forecastday> getForecastday() {
            return forecastday;
        }

        public void setForecastday(ArrayList<Forecastday> forecastday) {
            this.forecastday = forecastday;
        }
    }
    public static class Forecastday{
        private String date;
        private Day day;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }
    }
    public static class Location{
        private String name;
        private String country;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
