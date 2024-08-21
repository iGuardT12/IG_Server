package iGuard.Server.dto;

import iGuard.Server.Entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "아이디는 필수입니다.")
    private String id;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    @NotBlank(message = "나이는 필수입니다.")
    private LocalDate age;

    @NotBlank(message = "주소는 필수입니다.")
    private String address;

    @NotBlank(message = "전화번호는 필수입니다.")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다.") // 예: 010-1234-5678
    private String phone_number;

    @NotBlank(message = "약관 동의는 필수입니다.")
    private boolean accepted;

    public User toEntity() {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setAge(age);
        user.setAddress(address);
        user.setPhone_number(phone_number);
        user.setAccepted(accepted);
        return user;
    }

}