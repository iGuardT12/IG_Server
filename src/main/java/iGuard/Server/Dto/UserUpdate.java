package iGuard.Server.Dto;

import iGuard.Server.Entity.User;
import iGuard.Server.Util.AgeUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdate {

    private String id;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    @NotNull(message = "생년월일은 필수입니다.")
    private LocalDate age;

    @NotBlank(message = "주소는 필수입니다.")
    private String address;

    private String detailAddress;

    @NotBlank(message = "전화번호는 필수입니다.")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다.") // 예: 010-1234-5678
    private String phone_number;

}
