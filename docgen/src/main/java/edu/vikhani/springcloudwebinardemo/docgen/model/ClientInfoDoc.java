package edu.vikhani.springcloudwebinardemo.docgen.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ClientInfoDoc(LocalDateTime generationDate, String clientName, BigDecimal monthTurnover) {
}
