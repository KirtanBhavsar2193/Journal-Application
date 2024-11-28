/*
package com.springBoot.journalProject.service;

import com.springBoot.journalProject.repository.UserRepo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
public class UserServiceTest
{
    @Autowired
    private UserRepo userRepo;

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "kimy",
            "raj",
            "Joy"
    })
    public void testFindByUserName(String name)
    {
        assertEquals(4, 2+2);
        assertNotNull(userRepo.findByUserName(name));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected)
    {
        assertEquals(expected, a+b);
    }
}
*/
