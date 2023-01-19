package br.com.db1.anymarket.sqlinjectiondemo.model.dto;

import java.math.BigInteger;

public record UserResponse(BigInteger id, String username, String name, String surname, String token) {
}
