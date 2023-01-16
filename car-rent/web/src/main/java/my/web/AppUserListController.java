package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserReadDto;
import my.dto.page_response.PageResponse;
import my.service.AppUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AppUserListController {
    private final AppUserService appUserService;

    @GetMapping("/users")
    public String showUsersPage(Pageable pageable, Model model) {
        Page<AppUserReadDto> page = appUserService.getAll(pageable);
        model.addAttribute("data",  PageResponse.of(page));
        return "users";
    }
}
