package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.AppUserRepository;
import my.dao.AppUserRoleRepository;
import my.dao.PaymentCardRepository;
import my.dto.app_user.AppUserCreateDto;
import my.dto.app_user.AppUserReadDto;
import my.dto.app_user.EditUserDto;
import my.dto.app_user.EditUserProfileDto;
import my.mapper.app_user.AppUserCreateMapper;
import my.mapper.app_user.AppUserReadMapper;
import my.mapper.payment_card.PaymentCardCreateMapper;
import my.model.AppUser;
import my.model.AppUserRole;
import my.model.PaymentCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final PaymentCardRepository paymentCardRepository;
    private final AppUserCreateMapper appUserCreateMapper;
    private final AppUserReadMapper appUserReadMapper;
    private final PaymentCardCreateMapper paymentCardCreateMapper;
    private final AppUserRoleRepository appUserRoleRepository;

    @Transactional
    public void create(AppUserCreateDto userDto) {
        AppUser appUser = appUserCreateMapper.mapFrom(userDto);
        appUser.getRoles().add(appUserRoleRepository.findAppUserRoleByName("USER"));
        appUserRepository.save(appUser);
        PaymentCard paymentCard = paymentCardCreateMapper.mapFrom(userDto);
        paymentCard.setAppUser(appUser);
        paymentCardRepository.save(paymentCard);
    }

    public Optional<AppUser> findUserByUsername(String username) {
        return appUserRepository.findAppUserByUsernameEquals(username);
    }

    public AppUserReadDto getUserByUsername(String username) {
        return appUserRepository.findAppUserByUsernameEquals(username)
                .map(appUserReadMapper::mapFrom).orElseThrow();
    }

    public Page<AppUserReadDto> getAll(Pageable pageable) {
        return appUserRepository.findAll(pageable).map(appUserReadMapper::mapFrom);
    }

    public AppUserReadDto getAppUserById(String id) {
        return appUserRepository.findAppUserById(id)
                .map(appUserReadMapper::mapFrom)
                .orElseThrow();
    }

    @Transactional
    public void updateUser(EditUserDto editUserDto, String userId) {
        AppUser appUser = appUserRepository.findAppUserById(userId).orElseThrow();
        List<AppUserRole> roles = appUser.getRoles();
        AppUserRole addRole = appUserRoleRepository.findAppUserRoleByName(editUserDto.getAddRole());
        AppUserRole delRole = appUserRoleRepository.findAppUserRoleByName(editUserDto.getDelRole());
        if (!roles.contains(addRole)) {
            appUser.getRoles().add(addRole);
        }
        if (roles.contains(delRole)) {
            appUser.getRoles().remove(delRole);
        }
    }

    @Transactional
    public void updateUserProfile(EditUserProfileDto editUserProfileDto, String username) {
        if (editUserProfileDto.getDelCardId() != null) {
            appUserRepository.findAppUserByUsernameEquals(username)
                    .map(x -> x.getPaymentCards()
                            .remove(paymentCardRepository.findById(editUserProfileDto.getDelCardId())
                                    .orElseThrow())).orElseThrow();
            paymentCardRepository.deleteById(editUserProfileDto.getDelCardId());
        }
        AppUser appUser = appUserRepository.findAppUserByUsernameEquals(username).orElseThrow();
        if (!editUserProfileDto.getAddCard().isEmpty()
                && !appUser.getPaymentCards().stream()
                .map(PaymentCard::getCardNumber)
                .collect(Collectors.toList())
                .contains(editUserProfileDto.getAddCard())) {
            PaymentCard paymentCard = paymentCardCreateMapper.mapFrom(editUserProfileDto);
            paymentCard.setAppUser(appUser);
            paymentCardRepository.save(paymentCard);
        }
        appUser.getAppUserInfo().setFirstname(editUserProfileDto.getFirstname());
        appUser.getAppUserInfo().setLastname(editUserProfileDto.getLastname());
        appUser.getAppUserInfo().setBirthDate(editUserProfileDto.getBirthDate());
        appUser.getAppUserInfo().setEmail(editUserProfileDto.getEmail());
        appUser.getAppUserInfo().setTelNumber(editUserProfileDto.getTelNumber());
    }

    @Transactional
    public boolean deleteUser(String userId) {
        return appUserRepository.findAppUserById(userId)
                .map(entity -> {
                    appUserRepository.delete(entity);
                    return true;
                }).orElse(false);
    }

    public long getAppUserCount() {
        return appUserRepository.count();
    }
}
