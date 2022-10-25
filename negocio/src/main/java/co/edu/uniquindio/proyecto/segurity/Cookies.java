package co.edu.uniquindio.proyecto.segurity;

import org.springframework.http.ResponseCookie;

public class Cookies {

    public static Cookies factory() {
        return new Cookies();
    }

    public ResponseCookie setCookieUser(String id){
        return ResponseCookie.from("user-id",id)
                .httpOnly(true)
                .path("/")
                .maxAge(18000)
                .build();
    }

    public ResponseCookie setCookieVeterinary(String id){
        return ResponseCookie.from("veterinary-id",id)
                .httpOnly(true)
                .path("/")
                .maxAge(43200)
                .build();
    }

    public ResponseCookie deleteCookieUser(){
        return ResponseCookie
                .from("user-id", null)
                .build();
    }

    public ResponseCookie deleteCookieVeterinary(){
        return ResponseCookie
                .from("veterinary-id", null)
                .build();
    }
}
