package com.lh.list.myenum;

/**
 * @author: 姊佹槉
 * @version: v1.0
 * @description: 项目[list]: com.lh.list.myenum
 * @date:2019/4/4
 */
public enum DictionaryType {
    IS_OIL("oil"),
    IS_CAR("car"),
    IS_USE("use");

    private String text;

    DictionaryType(String _context) {
        this.text = _context;
    }

    @Override
    public String toString() {
        return this.text;
    }

}
