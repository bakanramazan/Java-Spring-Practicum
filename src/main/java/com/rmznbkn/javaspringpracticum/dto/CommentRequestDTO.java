package com.rmznbkn.javaspringpracticum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDTO {
    private Date startDate;
    private Date endDate;
    private Long productId;
    private Long customerId;

}
