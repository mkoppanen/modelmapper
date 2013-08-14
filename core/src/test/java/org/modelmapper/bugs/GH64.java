package org.modelmapper.bugs;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.testng.annotations.Test;

@Test
public class GH64 {
  public static class User {
    public String id;
    public Preference preference;
  }

  public static class Preference {
    public String id;
    public User user;
    public BigDecimal money;
  }

  public static class UserDto {
    public String id;
    public BigDecimal preferenceMoney;
  }

  public void test() {
    UserDto userDto = new UserDto();
    userDto.id = "test";
    userDto.preferenceMoney = BigDecimal.valueOf(1000.0);

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setFieldMatchingEnabled(true);
    User user = modelMapper.map(userDto, User.class);

    assertEquals(user.id, userDto.id);
    assertEquals(user.preference.money, userDto.preferenceMoney);
  }
}
