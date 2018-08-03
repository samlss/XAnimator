package com.iigo.library;

import android.annotation.LayoutRes;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SamLeung
 * @e-mail 729717222@qq.com
 * @github https://github.com/samlss
 * @csdn https://blog.csdn.net/Samlss
 * @description To init the layout.
 */
public class XAnimator {
    protected static final String TAG = "XAnimator";

    private XAnimator(){

    }

    /**
     * To init the layout which use
     *
     * @param context The context obj.
     * @param layoutId The layout id.
     * */
    public static View initLayout(Context context, int layoutId){
        LayoutInflater inflater = LayoutInflater.from(context);
        View layoutView = inflater.inflate(layoutId, null);

        if (layoutView instanceof ViewGroup){
            List<XAnimatorAttr> xAnimatorAttrs = parseLayoutXml(context, layoutId);
            List<View> viewList = getAllChildViews(layoutView);
            viewList.add(0, layoutView);

            if (xAnimatorAttrs != null && viewList != null
                    && xAnimatorAttrs.size() == viewList.size()) {
                for (int i = 0; i < viewList.size(); i++) {
                    View view = viewList.get(i);
                    ViewGroup parent = (ViewGroup) view.getParent();

                    if (parent != null && parent instanceof XAnimatorLinearLayout) {
                        view.setTag(R.id.XAnimator, xAnimatorAttrs.get(i));
                    }
                }
            }
        }
        return layoutView;
    }

    private static List<View> getAllChildViews(View view) {
        List<View> childList = new ArrayList<>();

        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                childList.add(child);
                childList.addAll(getAllChildViews(child));
            }
        }
        return childList;
    }

    /**
     * Parse the layout.xml, to get the attrs of the child in the {@link XAnimatorLinearLayout}
     * */
    private static List<XAnimatorAttr> parseLayoutXml(Context context, int layoutId){
        List<XAnimatorAttr> xAnimatorAttrs = new ArrayList<>();

        XmlResourceParser parser = context.getResources().getLayout(layoutId);
        AttributeSet attributeSet = Xml.asAttributeSet(parser);

        try{
            int type;
            while ((type = parser.next()) != XmlPullParser.END_DOCUMENT){
                String name = parser.getName();

                if (type != XmlPullParser.START_TAG
                        || TextUtils.isEmpty(name)) {
                    continue;
                }

                TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.XAnimator);

                if (typedArray.getIndexCount() == 0) {
                    xAnimatorAttrs.add(createDefaultAnimatorAttr());
                }else{
                    xAnimatorAttrs.add(parseAnimatorAttr(typedArray));
                }

                typedArray.recycle();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            parser.close();//release
        }

        return xAnimatorAttrs;
    }

    /**
     * According to the {@link TypedArray}, to parse into one {@link XAnimatorAttr}.
     *
     * @param typedArray The typedArray obj.
     * */
    private static XAnimatorAttr parseAnimatorAttr(TypedArray typedArray){
        if (typedArray.getIndexCount() == 0) {
           return createDefaultAnimatorAttr();
        }

        boolean alpha = false;
        boolean scaleX = false;
        boolean scaleY = false;
        int fromDirection = -1;
        int startBgColor = -1;
        int endBgColor = -1;

        for (int i = 0; i < typedArray.getIndexCount(); i++){
            int attrId = typedArray.getIndex(i);

            if (attrId == R.styleable.XAnimator_x_alpha){
                alpha = typedArray.getBoolean(attrId, false);
            } else if (attrId == R.styleable.XAnimator_x_scaleX){
                scaleX = typedArray.getBoolean(attrId, false);
            } else if (attrId == R.styleable.XAnimator_x_scaleY){
                scaleY = typedArray.getBoolean(attrId, false);
            } else if (attrId == R.styleable.XAnimator_from_direction){
                fromDirection = typedArray.getInt(attrId, -1);
            } else if (attrId == R.styleable.XAnimator_x_startBgColor){
                startBgColor = typedArray.getColor(attrId, -1);
            } else if (attrId == R.styleable.XAnimator_x_endBgColor){
                endBgColor = typedArray.getColor(attrId, -1);
            }
        }

        return  createAnimatorAttr(alpha, scaleX, scaleY,
                fromDirection, startBgColor, endBgColor);
    }


    /**
     * If no animator properties are specified，will return the default one.
     * */
    private static XAnimatorAttr createDefaultAnimatorAttr(){
        return createAnimatorAttr(false, false, false, -1, -1, -1);
    }

    /**
     * To create a {@link XAnimatorAttr}
     * */
    private static XAnimatorAttr createAnimatorAttr(boolean alpha, boolean scaleX, boolean scaleY, int fromDirection,
                        int startBgColor, int endBgColor){
        XAnimatorAttr xAnimatorAttr = new XAnimatorAttr();
        xAnimatorAttr.setAlpha(alpha);
        xAnimatorAttr.setScaleX(scaleX);
        xAnimatorAttr.setScaleY(scaleY);
        xAnimatorAttr.setFromDirection(fromDirection);
        xAnimatorAttr.setStartBgColor(startBgColor);
        xAnimatorAttr.setEndBgColor(endBgColor);
        return xAnimatorAttr;
    }
}
