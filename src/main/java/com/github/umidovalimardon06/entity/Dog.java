package com.github.umidovalimardon06.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private String name;
    private Float weight;
}
