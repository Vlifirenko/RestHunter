package resthunter.content.rest;

import java.util.List;

public class UserRegisterResponse {
    public String id;
    public String fname;
    public String lname;
    public String email;
    public boolean result;
    public Error error;

    public class Error {
        public List<Params> params;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Params item : params)
                sb.append("code:" + item.code + ",message:" + item.message + ",name:" + item.name + "; ");
            return sb.toString();
        }
    }

    public class Params {
        public String code;
        public String message;
        public String name;
    }
}
