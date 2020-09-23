package com.bison.cis.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by macro on 2020/6/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO {
    private Long id;
    private String username;
}
