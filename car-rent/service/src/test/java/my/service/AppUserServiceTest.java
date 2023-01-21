package my.service;

import my.DataConfig;
import my.dto.app_user.AppUserCreateDto;
import my.dto.app_user.EditUserProfileDto;
import my.model.AppUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ServiceConfig.class,
        DataConfig.class})
@Transactional
@TestPropertySource(value = "classpath:/test.jdbc.properties")
public class AppUserServiceTest {
    @Autowired
    AppUserService appUserService;

    @Test
    public void create() {
        long countBeforeCreate = appUserService.getAppUserCount();
        AppUserCreateDto appUserCreateDto = new AppUserCreateDto(
                "sveta",
                "sveta",
                "Sveta",
                "Svetikova",
                Date.valueOf(LocalDate.now()),
                "sveta@gmail.com",
                "+375252225511",
                "424-323-5525-6266"
        );
        appUserService.create(appUserCreateDto);
        assertEquals(countBeforeCreate + 1, appUserService.getAppUserCount());
    }

    @Test
    public void updateUserProfile() {
        AppUser appUser = appUserService.findUserByUsername("stepan").orElseThrow();
        assertEquals(appUser.getAppUserInfo().getFirstname(), "Stepan");
        assertEquals(appUser.getAppUserInfo().getLastname(), "Stepanov");
        assertEquals(appUser.getAppUserInfo().getEmail(), "stepan@gmail.com");
        assertEquals(appUser.getAppUserInfo().getTelNumber(), "+375339875885");
        EditUserProfileDto editUserProfileDto = new EditUserProfileDto(
                "Vasily",
                "Vasilyev",
                Date.valueOf(LocalDate.now()),
                "vasily@gmail.com",
                "+375298889966",
                "444-333-5555-6666",
                4L
        );
        appUserService.updateUserProfile(editUserProfileDto, "stepan");
        AppUser appUserAfterUpdate = appUserService.findUserByUsername("stepan").orElseThrow();
        assertEquals(appUserAfterUpdate.getAppUserInfo().getFirstname(), "Vasily");
        assertEquals(appUserAfterUpdate.getAppUserInfo().getLastname(), "Vasilyev");
        assertEquals(appUserAfterUpdate.getAppUserInfo().getEmail(), "vasily@gmail.com");
        assertEquals(appUserAfterUpdate.getAppUserInfo().getTelNumber(), "+375298889966");
    }

    @Test
    public void deleteUser() {
        long countBeforeDelete = appUserService.getAppUserCount();
        appUserService.deleteUser("10000000-0000-0000-0000-000000000001");
        assertEquals(countBeforeDelete - 1, appUserService.getAppUserCount());
    }

    @Test
    public void getAppUserCount() {
        assertEquals(9, appUserService.getAppUserCount());
    }
}