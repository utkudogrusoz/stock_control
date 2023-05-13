package com.utkudogrusoz.stockcontrol.response;

public record ProductResponse(
        Long id,
        String productName,
        Integer quantity,
        Double price,
        Long createdDate,
        Long updatedDate
) {
}
