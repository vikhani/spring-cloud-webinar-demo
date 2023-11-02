package edu.vikhani.springcloudwebinardemo.clientinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public record ClientInfo(String name, BigDecimal turnover, @JsonIgnore String bloodType) {
}
