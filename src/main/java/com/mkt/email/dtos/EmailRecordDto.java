package com.mkt.email.dtos;

import java.util.UUID;

public record EmailRecordDto(UUID userId,
                             String emailTo,
                             String subject,
                             String text) {

}
