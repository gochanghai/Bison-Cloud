package com.bison.oms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by macro on 2020/6/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO {
    private Long id;
    private String username;
    private List<String> roles;
}
