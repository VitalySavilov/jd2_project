package my.rest;

import lombok.RequiredArgsConstructor;
import my.dto.app_user.AppUserReadDto;
import my.dto.page_response.PageResponse;
import my.service.AppUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AppUserRestController {
    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<PageResponse<AppUserReadDto>> getAllUsers(Pageable pageable) {
        Page<AppUserReadDto> page = appUserService.getAll(pageable);
        return new ResponseEntity<>(
                PageResponse.of(page),
                HttpStatus.OK);
    }
}
