package com.health.helper;

//Custom exception for DoctorService
public class DoctorServiceException extends Exception {
 public DoctorServiceException(String message) {
     super(message);
 }

 public DoctorServiceException(String message, Throwable cause) {
     super(message, cause);
 }
}