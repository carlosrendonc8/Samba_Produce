package Samba.commons.domains.DTO.user;


import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO implements Serializable {
    private Integer userId;
    private String userName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userNumber;
}