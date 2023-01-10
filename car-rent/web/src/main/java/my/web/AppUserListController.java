package my.web;

import lombok.RequiredArgsConstructor;
import my.dto.AppUserReadDto;
import my.dto.CarReadDto;
import my.dto.PageResponse;
import my.service.AppUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AppUserListController {
    private final AppUserService appUserService;

    @GetMapping("/users")
    public ModelAndView showUsersPage(Pageable pageable) {
        Page<AppUserReadDto> page = appUserService.getAll(pageable);
        return new ModelAndView("users",
                Map.of("data", PageResponse.of(page)));
    }
}
