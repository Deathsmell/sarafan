package by.deathsmell.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "usr")
public class User implements Serializable {

    @Id
    private String  id;
    private String name;
    private String userpic;
    private String email;
    private String gender;
    private String locale;

    private String login;
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastVisit;

}
