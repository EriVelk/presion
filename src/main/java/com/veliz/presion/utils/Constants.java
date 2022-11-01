package com.veliz.presion.utils;

public class Constants {
    public static String BLANK_SPACE= " ";
    public static String DATE_IS_REQUIRED = "Date field is required";
    public static String HOUR_IS_REQUIRED = "Hora field is required";
    public static String PRESION_DELETED = "Presion has been removed";

    public enum ResponseConstant{
        SUCCESS("SUCCESS"),
        FAILURE("FAILURE");

        private String description;

        ResponseConstant(final String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }

    }
}
