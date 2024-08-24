package com.infect;

import com.infect.entity.User;
import com.infect.enums.user.*;
import com.infect.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    private User testUser;

    @BeforeEach
    public void setUp() {
        // Initialize a User object for testing
        testUser = new User();
        testUser.setPassword("password123");
        testUser.setUserType(UserType.SYSTEM_ADMINISTRATOR);
        testUser.setName("John Doe");
        testUser.setGender(Gender.MALE);
        testUser.setIsPregnant(false);
        testUser.setPregnancyWeeks(null);
        testUser.setIdNumber("123456789012345678");
        testUser.setBirthDate(new Date());
        testUser.setAge(30);
        testUser.setEthnicity(Ethnicity.HAN);
        testUser.setEducationLevel(EducationLevel.BELOW_PRIMARY);
        testUser.setWorkOnPlateauStartDate(new Date());
        testUser.setDepartment(Department.ENGINEERING_TECHNOLOGY);
        testUser.setSpecificOccupation(SpecificOccupation.MEDICAL_PERSONNEL);
        testUser.setMedicalPersonnelType(MedicalPersonnelType.DOCTOR);
        testUser.setOtherPositionName(null);
        testUser.setPhoneNumber("12345678901");
        testUser.setOtherPhoneNumber("9876543210");
        testUser.setHasMedicalHistory(false);
        testUser.setHasHypertension(false);
        testUser.setHasDiabetes(false);
        testUser.setHasHyperlipidemia(false);
        testUser.setHasHyperuricemia(false);
        testUser.setHasCoronaryHeartDisease(false);
        testUser.setHasStroke(false);
        testUser.setHasOtherCardiovascularDiseases(false);
        testUser.setHasAsthma(false);
        testUser.setHasCOPD(false);
        testUser.setHasPepticUlcer(false);
        testUser.setHasMalignantTumor(false);
        testUser.setHasLungCancer(false);
        testUser.setHasOtherCancer(false);
        testUser.setOtherCancerName(null);
        testUser.setHasSevereMentalDisorders(false);
        testUser.setHasTuberculosis(false);
        testUser.setHasHepatitis(false);
        testUser.setHasOccupationalDisease(false);
        testUser.setHasChronicKidneyDisease(false);
        testUser.setHasChronicLiverDisease(false);
        testUser.setHasImmunodeficiency(false);
        testUser.setHasTyphus(false);
        testUser.setIsPostpartumInSixWeeks(false);
        testUser.setHasDustExposure(false);
        testUser.setHasOtherDiseases(false);
        testUser.setOtherDiseasesName(null);
        testUser.setSmokingStatus(SmokingStatus.NEVER_SMOKED);
        testUser.setDrinkingStatus(DrinkingStatus.NON_DRINKER);
        testUser.setHeight(170);
        testUser.setWeight(70);
        testUser.setIsVaccinatedForCOVID(true);
        testUser.setIsVaccinatedForFlu(true);
        testUser.setIsVaccinatedForPlague(true);
        testUser.setIsVaccinatedForBCG(true);
        testUser.setIsVaccinatedForHepatitis(true);
    }

    @Test
    public void testInsert() {
        setUp();
        int result = userMapper.insert(testUser);
        assertEquals(1, result, "Insert operation failed");
        assertNotNull(testUser.getUserId(), "UserID should be auto-generated");
    }

    @Test
    public void testSelectById() {
        userMapper.insert(testUser); // Insert a user first
        User retrievedUser = userMapper.selectById(testUser.getUserId());
        assertNotNull(retrievedUser, "User should be found");
        assertEquals(testUser.getName(), retrievedUser.getName(), "User name should match");
    }

    @Test
    public void testUpdate() {
        userMapper.insert(testUser); // Insert a user first
        testUser.setName("Jane Doe");
        int result = userMapper.updateById(testUser);
        assertEquals(1, result, "Update operation failed");

        User updatedUser = userMapper.selectById(testUser.getUserId());
        assertEquals("Jane Doe", updatedUser.getName(), "User name should be updated");
    }

    @Test
    public void testDelete() {
        userMapper.insert(testUser); // Insert a user first
        int result = userMapper.deleteById(testUser.getUserId());
        assertEquals(1, result, "Delete operation failed");

        User deletedUser = userMapper.selectById(testUser.getUserId());
        assertNull(deletedUser, "User should be deleted");
    }
}
