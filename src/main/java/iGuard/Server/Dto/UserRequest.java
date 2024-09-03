package iGuard.Server.Dto;

import iGuard.Server.Entity.User;
import iGuard.Server.Enum.ShelterCategory;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "아이디는 필수입니다.")
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

    private List<ShelterCategory.Preference> preferences; // 카테고리 리스트 추가

    @AssertTrue(message = "약관에 동의해야 합니다.")
    private boolean accepted;

    public User toEntity() {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setAge(age);
        user.setAddress(
                detailAddress!=null
                        ?address + ", " + detailAddress
                        :address
        );
        user.setPhone_number(phone_number);
        user.setAccepted(accepted);
        return user;
    }

}