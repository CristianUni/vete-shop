package co.edu.uniquindio.proyecto.entidades;

import jakarta.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
public class Token implements Serializable {
    @JsonbProperty("id")
    @Column(length = 50)
    private String token;

    @JsonbProperty("expirationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar expirationDate;

    @Id
    @JsonbProperty("userName")
    @Column(length = 50)
    private String email;

    private static final int TIME_LIVE_LIMIT = 360;

    public Token() {
    }

    public Token(String email) {
        this.email = email;
        expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE,TIME_LIVE_LIMIT);
        token = UUID.randomUUID().toString();
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public static Token of(String userName){
        return new Token(userName);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
