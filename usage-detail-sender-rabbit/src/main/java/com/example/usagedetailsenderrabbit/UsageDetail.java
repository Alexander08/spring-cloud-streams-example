package com.example.usagedetailsenderrabbit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsageDetail {

    private String userId;
    private String from;
    private long duration;
    private long data;

}
