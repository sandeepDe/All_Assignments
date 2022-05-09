package com.doctorapp.exceptions;

import java.sql.SQLException;

public class DoctorNotFoundException extends SQLException {



    public DoctorNotFoundException() {
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
