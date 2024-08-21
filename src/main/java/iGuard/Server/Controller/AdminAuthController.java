package iGuard.Server.Controller;

import iGuard.Server.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminAuthController {

    @Autowired
    private EmailService emailService;

    // 사용자 등록 폼 표시
    @GetMapping("/sendcode")
    public String showRegisterForm() {
        return "company_register"; // register.html 템플릿을 반환
    }

    @PostMapping("/sendcode")
    public String register(@RequestParam String email, Model model) {
        String code = emailService.generateVerificationCode();
        emailService.sendVerificationEmail(email, code);
        model.addAttribute("email", email); // 이메일 주소를 뷰로 전달
        model.addAttribute("message", "인증메일이 보내졌습니다. 아래에 인증코드를 입력해 주세요.");
        return "verify"; // 인증 코드 입력 페이지로 이동
    }

    @PostMapping("/verify")
    public String verify(@RequestParam String email, @RequestParam String code, Model model) {
        boolean isValid = emailService.verifyCode(email, code);
        if (isValid) {
            model.addAttribute("message", "성공적으로 인증되었습니다.");
        } else {
            model.addAttribute("message", "유효하지 않습니다.");
        }
        return "verify"; // 인증 결과를 표시할 페이지
    }
}
