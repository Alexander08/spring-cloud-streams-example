package com.example.usagecostprocessorrabbit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsageDetail {

    private String userId;
    private String from;
    private long duration;
    private long data;
}
