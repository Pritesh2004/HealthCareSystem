package com.health.dto;

public enum AppointmentStatus {
	
	  ACCEPTED("ACCEPTED"),
	    REJECTED("REJECTED"),
	    PENDING("PENDING"),
	CANCELLED("CANCELLED");

	    private String status;

	    AppointmentStatus(String status) {
	        this.status = status;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public static AppointmentStatus fromString(String status) {
	        for (AppointmentStatus s : AppointmentStatus.values()) {
	            if (s.getStatus().equalsIgnoreCase(status)) {
	                return s;
	            }
	        }
	        throw new IllegalArgumentException("No enum constant with status " + status);
	    }
}
