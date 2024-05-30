package com.estoquespig.App.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarningEmailDTO {
    public String id;
    public String topic;
    public String text;
}
