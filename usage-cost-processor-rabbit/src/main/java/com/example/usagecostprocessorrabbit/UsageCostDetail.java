package com.example.usagecostprocessorrabbit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsageCostDetail {

    private String userId;
    private String from;
    private double callCost;
    private double dataCost;
}
