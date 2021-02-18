package com.timberliu.springboot.validation.constants;

import com.timberliu.springboot.validation.core.validator.IntArrayValuable;

import java.util.Arrays;

/**
 * @author: Timber
 * @date: 2021/2/7
 */
public enum GenderEnum implements IntArrayValuable {

    /**
     * 男、女
     */
    MALE(1, "男"),
    FEMALE(2, "女");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(GenderEnum::getValue).toArray();

    /**
     * 性别值
     */
    private final Integer value;

    /**
     * 性别名
     */
    private final String name;

    GenderEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
