package com.example.usagecostloggerrabbit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsageCostDetail {


    private String userId;
    private String from;
    private double callCost;
    private double dataCost;
}
