package com.example.cicddemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ValidatorTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Should pass with a valid phoneNumber")
    void itShouldValidatePhoneNumber() {

        //given
        String phoneNumber = "0793321039";
        //when
        boolean expected = Validator.isPhoneNumberValid(phoneNumber);
        //then
        assertThat(expected).isTrue();
    }

    @Test
    @DisplayName("Should fail when length is longer than 10")
    void itShouldValidatePhoneNumberWhenIncorrectAndHasLengthBiggerThan10() {

        //given
        String phoneNumber = "07933210397456387";
        //when
        boolean expected = Validator.isPhoneNumberValid(phoneNumber);
        //then
        assertThat(expected).isFalse();
    }

    @Test
    @DisplayName("Should fail when does not start with 0")
    void itShouldValidatePhoneNumberWhenDoesNotStartWithZero() {

        //given
        String phoneNumber = "1793321039";
        //when
        boolean expected = Validator.isPhoneNumberValid(phoneNumber);
        //then
        assertThat(expected).isFalse();
    }



    @Test
    @DisplayName("Should pass with valid email")
    void itShouldValidateEmail() {
        //given
        String email = "sample@gmail.com";
        //when
        boolean expected = Validator.isEmailValid(email);
        //then
        assertThat(expected).isTrue();

    }
    @Test
    @DisplayName("Should fail with an incorrect email format")
    void itShouldValidateEmailThatDoesHasAnInCorrectFormat() {
        //given
        String email = "daniel-gmail.com";
        //when
        boolean expected = Validator.isEmailValid(email);
        //then
        assertThat(expected).isFalse();

    }
}
