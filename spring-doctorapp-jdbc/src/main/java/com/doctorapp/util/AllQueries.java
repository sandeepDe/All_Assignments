package com.doctorapp.util;

public class AllQueries {

    public static final String SELECTQUERY = "SELECT * FROM doctor";
    public static final String NAMEQUERY = "SELECT * FROM doctor WHERE category=?1";
    public static final String LOCATIONQUERY = "SELECT * FROM doctor WHERE location=?1";
    public static final String SPECANDPRICEQUERY = "SELECT * FROM doctor WHERE specialization = ?1 and price<=?2";
    public static final String ADDQUERY = "INSERT INTO doctor VALUES(?,?,?,?,?)";
    public static final String DELETEQUERY = "DELETE FROM doctor WHERE doctor_id=?1";
}
