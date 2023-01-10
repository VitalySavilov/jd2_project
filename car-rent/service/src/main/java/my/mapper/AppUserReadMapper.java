package my.mapper;

import lombok.RequiredArgsConstructor;
import my.dto.AppUserReadDto;
import my.model.AppUser;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppUserReadMapper implements Mapper<AppUser, AppUserReadDto> {

    @Override
    public AppUserReadDto mapFrom(AppUser object) {
        return new AppUserReadDto(
                object.getId(),
                object.getAppUserInfo(),
                object.getUsername(),
                object.getRoles(),
                object.getOrders(),
                object.getPaymentCards(),
                object.getPayments()
        );
    }
}
