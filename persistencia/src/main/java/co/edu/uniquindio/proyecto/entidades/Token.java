package co.edu.uniquindio.proyecto.entidades;

import jakarta.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@Entity
public class Token implements Serializable {
    @JsonbProperty("id")
    @Id
    @Column(length = 50)
    private String id;

    @JsonbProperty("expirationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar expirationDate;

    @JsonbProperty("userName")
    @Column(length = 50)
    private String userName;

    private static final int TIME_LIVE_LIMIT = 5;

    public Token() {
    }

    public Token(String userName) {
        this.userName = userName;
        expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE,TIME_LIVE_LIMIT);
        id = UUID.randomUUID().toString();
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public static Token of(String userName){
        return new Token(userName);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
