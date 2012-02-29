package com.github.flickr.api.panda;

/**
 * User: Wursteisen David
 * Date: 29/02/12
 * Time: 21:53
 */
public enum Panda {
    LING_LING("ling ling"),
    HSING_HSING("hsing hsing"),
    WANG_WANG("wang wang");

    private final String pandaName;

    private Panda(String pandaName) {
        this.pandaName = pandaName;
    }

    public String getPandaName() {
        return pandaName;
    }

    public static Panda fromValue(String name) {
        for (Panda panda : values()) {
            if (panda.getPandaName().equals(name)) {
                return panda;
            }
        }
        throw new IllegalArgumentException("Invalid panda name : " + name);
    }
}
