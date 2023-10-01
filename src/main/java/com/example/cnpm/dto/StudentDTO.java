package com.example.cnpm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDTO {
    private long id;
    private String ten;
    private String masinhvien;
    private String lop;
    private String password;
}
