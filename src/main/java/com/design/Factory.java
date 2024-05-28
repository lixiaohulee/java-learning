package com.design;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Factory {
    public static Number parse(String s) {
        return new BigDecimal(s);
    }
}
