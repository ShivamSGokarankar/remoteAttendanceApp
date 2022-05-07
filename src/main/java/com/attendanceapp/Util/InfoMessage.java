package com.attendanceapp.Util;

public enum InfoMessage
{
    User_Logged_In,
    User_Found,
    User_Not_Found,
    Invalid_Username_OR_Password,
    Error_Occured_While_fetching_user,
    Request {
        public String toString() {
            return "Request JSON";
        }
    },
    Response {
        @Override
        public String toString() {
            return "Response JSON";
        }
    },
    Hibernate_Session_Created,
    Hibernate_SessionCreation_Failed,
    Hibernate_Transaction_Failed,
    Hibernate_Transaction_Committed,
    Hibernate_Transaction_RollBacked,
    Hibernate_Transaction_created;
}
