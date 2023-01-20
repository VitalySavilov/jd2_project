package my.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_user_info")
public class AppUserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INFO_ID")
    private Long id;
    @Column(name = "INFO_U_FIRSTNAME")
    private String firstname;
    @Column(name = "INFO_U_LASTNAME")
    private String lastname;
    @Column(name = "INFO_U_BIRTHDATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Column(name = "INFO_U_EMAIL")
    private String email;
    @Column(name = "INFO_U_TEL")
    private String telNumber;
}
