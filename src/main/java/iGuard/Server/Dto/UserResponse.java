package iGuard.Server.Dto;

import iGuard.Server.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private Integer userid;
    private String id;
    private String address;

    public static UserResponse getFrom(User user) {
        return new UserResponse(
                user.getUserid(),
                user.getId(),// User의 id를 받아옴
                user.getAddress()
        );
    }
}