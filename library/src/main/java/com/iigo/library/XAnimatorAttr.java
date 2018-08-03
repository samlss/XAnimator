package com.iigo.library;

/**
 * @author SamLeung
 * @e-mail 729717222@qq.com
 * @github https://github.com/samlss
 * @csdn https://blog.csdn.net/Samlss
 * @description The attr class.
 */
final class XAnimatorAttr {
    public static final int FROM_DIRECTION_TOP = 1;
    public static final int FROM_DIRECTION_BOTTOM = 2;
    public static final int FROM_DIRECTION_LEFT = 3;
    public static final int FROM_DIRECTION_RIGHT = 4;

    private boolean alpha;
    private boolean scaleX;
    private boolean scaleY;
    private int fromDirection;
    private int startBgColor;
    private int endBgColor;

    public boolean isAlpha() {
        return alpha;
    }

    public void setAlpha(boolean alpha) {
        this.alpha = alpha;
    }

    public boolean isScaleX() {
        return scaleX;
    }

    public void setScaleX(boolean scaleX) {
        this.scaleX = scaleX;
    }

    public boolean isScaleY() {
        return scaleY;
    }

    public void setScaleY(boolean scaleY) {
        this.scaleY = scaleY;
    }

    public int getFromDirection() {
        return fromDirection;
    }

    public void setFromDirection(int fromDirection) {
        this.fromDirection = fromDirection;
    }

    public void setStartBgColor(int startBgColor) {
        this.startBgColor = startBgColor;
    }

    public void setEndBgColor(int endBgColor) {
        this.endBgColor = endBgColor;
    }


    public int getStartBgColor() {
        return startBgColor;
    }

    public int getEndBgColor() {
        return endBgColor;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("alpha = ")
                .append(alpha)
                .append(", scaleX = ")
                .append(scaleX)
                .append(", scaleY = ")
                .append(scaleY)
                .append(", fromDirection = ")
                .append(fromDirection)
                .append(", startBgColor = ")
                .append(startBgColor)
                .append(", endBgColor = ")
                .append(endBgColor)
                .toString();
    }
}
