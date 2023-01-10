package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.AppUserRepository;
import my.dto.AppUserCreateDto;
import my.dto.AppUserReadDto;
import my.dto.CarReadDto;
import my.mapper.AppUserCreateMapper;
import my.mapper.AppUserReadMapper;
import my.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppUserCreateMapper appUserCreateMapper;
    private final AppUserReadMapper appUserReadMapper;

    @Transactional
    public void create(AppUserCreateDto userDto) {
        appUserRepository.save(appUserCreateMapper.mapFrom(userDto));
    }

    public List<AppUser> findUserByUsername(String username) {
        return appUserRepository.findAppUserByUsernameEquals(username);
    }

//    public List<AppUserReadDto> getAll() {
//        return appUserRepository.findAll().stream()
//                .map(appUserReadMapper::mapFrom)
//                .collect(Collectors.toList());
//    }

    public Page<AppUserReadDto> getAll(Pageable pageable) {
        return appUserRepository.findAll(pageable).map(appUserReadMapper::mapFrom);
    }
}
