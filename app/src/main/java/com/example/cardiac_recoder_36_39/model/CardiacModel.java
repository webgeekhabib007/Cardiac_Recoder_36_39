package com.example.cardiac_recoder_36_39.model;

/**
 * This class is used to create
 * the model for the data.
 */
public class CardiacModel {
    public String date, time, systolic, diastolic, heartRate, comment;
    public long id;

    /**
     * default constructor
     */
    CardiacModel() {
        this.id = 0L;
        this.date = "";
        this.time = "";
        this.systolic = "";
        this.diastolic = "";
        this.heartRate = "";
        this.comment = "";
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the systolic
     */
    public String getSystolic() {
        return systolic;
    }

    /**
     * @param systolic
     */
    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    /**
     * @return the diastolic
     */
    public String getDiastolic() {
        return diastolic;
    }

    /**
     * @param diastolic
     */
    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    /**
     * @return the heartRate
     */
    public String getHeartRate() {
        return heartRate;
    }

    /**
     * @param heartRate
     */
    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param date
     * @param time
     * @param systolic
     * @param diastolic
     * @param heartRate
     * @param comment
     */
    public CardiacModel( String date, String time, String systolic, String diastolic, String heartRate, String comment) {
        this.date = date;
        this.time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartRate = heartRate;
        this.comment = comment;
    }
}
