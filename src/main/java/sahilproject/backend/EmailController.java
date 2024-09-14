package sahilproject.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.mail.MessagingException;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/portfolio")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public Map<String, Object> sendEmail(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String email = request.get("email");
        String msg = request.get("msg");

        try {
            emailService.sendEmail(email, name, "Message from Portfolio: " + name, msg);
            return Map.of("success", true, "message", "Email sent successfully.");
        } catch (MessagingException e) {
            return Map.of("success", false, "message", "Failed to send email. Error: " + e.getMessage());
        }
    }
}
