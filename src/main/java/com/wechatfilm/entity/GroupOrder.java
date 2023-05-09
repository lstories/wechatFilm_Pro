package com.wechatfilm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupOrder {
    private String id;
    private String name;
    private List<String> items;
    private int minParticipants;
    private List<String> participants;

}
