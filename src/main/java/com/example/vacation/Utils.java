package com.example.vacation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utils {
    public static <T> ResponseEntity<Response> okResponse(T data) {
        return jsonResponse("ok", data);
    }

    public static <T> ResponseEntity<Response> errorResponse(T data) {
        return jsonResponse("error", data);
    }

    private static <T> ResponseEntity<Response> jsonResponse(String status, T data) {
        var resp = new Response(status, data);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    public static class Response {
        String status;
        Object Data;

        public Response(String status, Object data) {
            this.status = status;
            Data = data;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getData() {
            return Data;
        }

        public void setData(Object data) {
            Data = data;
        }
    }
}
