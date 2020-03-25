package com.lupa.a363.objects.views;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.lupa.a363.objects.Coordinates;
import com.lupa.a363.utils.AppConstants;

import androidx.annotation.RequiresApi;

public class LayoutWiringDiagram extends ViewGroup implements AppConstants {

    public LayoutWiringDiagram(Context context) {
        super(context);
    }

    public LayoutWiringDiagram(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutWiringDiagram(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LayoutWiringDiagram(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /*
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int childCount = getChildCount();
        int maxX = 0;
        int maxY = 0;

        Component component;

        for (int i = 0; i < childCount; i ++) {
            component = ((Component) getChildAt(i));

            if (component.getCoordinates().getX() > maxX) maxX = component.getCoordinates().getX();
            if (component.getCoordinates().getY() > maxY) maxY = component.getCoordinates().getY();
        }

        Log.i("bcwcbwe", "maxX: " + maxX);
        Log.i("bcwcbwe", "maxY: " + maxY);

        setMeasuredDimension(
                maxX * (COMPONENT_WIDTH - (2 * COMPONENT_FRAME)),
                maxX * (COMPONENT_HEIGHT - (2 * COMPONENT_FRAME)));
    }
    */

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int childCount = getChildCount();

        for (int i = 0; i < childCount; i ++) {
            if (!(getChildAt(i) instanceof Component)) continue;

            Component actualComponent = (Component) getChildAt(i);
            if (actualComponent.getCoordinates() == null) actualComponent.setCoordinates(0,0);

            //Bez relativní pozice může být pouze objekt na pozici [1,1]
            if (!actualComponent.hasRelativePosition()) {
                actualComponent.setCoordinates(1, 1);
            } else {
                Component referenceObject;
                Coordinates referenceObjectCoordinates;

                if (actualComponent.toLeftOf > 0) {
                    referenceObject = getChildById(actualComponent.toLeftOf);

                    addAllComponentsX(i);
                    referenceObjectCoordinates = referenceObject.getCoordinates();

                    actualComponent.setCoordinates(
                            referenceObjectCoordinates.getX() - 1,
                            referenceObjectCoordinates.getY());
                } else if (actualComponent.toRightOf > 0) {
                    referenceObject = getChildById(actualComponent.toRightOf);
                    referenceObjectCoordinates = referenceObject.getCoordinates();

                    actualComponent.setCoordinates(
                            referenceObjectCoordinates.getX() + 1,
                            referenceObjectCoordinates.getY());
                } else if (actualComponent.below > 0) {
                    referenceObject = getChildById(actualComponent.below);
                    referenceObjectCoordinates = referenceObject.getCoordinates();

                    actualComponent.setCoordinates(
                            referenceObjectCoordinates.getX(),
                            referenceObjectCoordinates.getY() + 1);
                } else if (actualComponent.above > 0) {
                    referenceObject = getChildById(actualComponent.above);
                    addAllComponentsY(i);
                    referenceObjectCoordinates = referenceObject.getCoordinates();

                    actualComponent.setCoordinates(
                            referenceObjectCoordinates.getX(),
                            referenceObjectCoordinates.getY() - 1);
                }
            }

            int tempLeft =
                    COMPONENT_FRAME
                            + (actualComponent.getCoordinates().getX() * (COMPONENT_WIDTH + (0 * COMPONENT_FRAME)))
                            - (COMPONENT_WIDTH + (2 * COMPONENT_FRAME));

            int tempTop =
                    COMPONENT_FRAME
                            + (actualComponent.getCoordinates().getY() * (COMPONENT_HEIGHT + (0 * COMPONENT_FRAME)))
                            - (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME));

            getChildAt(i).layout(
                    tempLeft - NODE_POINT_RADIUS,
                    tempTop - NODE_POINT_RADIUS,
                    tempLeft + (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) + NODE_POINT_RADIUS,
                    tempTop + (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) + NODE_POINT_RADIUS);
        }
    }

    private Component getChildById(int id) {
        for (int i = 0; i < getChildCount(); i ++) {
            View v = (View) getChildAt(i);

            if (v.getId() == id) {
                if (v instanceof Component) return (Component) v;
                else return null;
            }
        }

        return null;
    }

    private void addAllComponentsX(int toIndex) {
        for (int i = 0; i < getChildCount(); i ++) {
            if (i >= toIndex) break;

            View v = getChildAt(i);

            if (v instanceof Component) {
                ((Component) v).getCoordinates().addX();

                int left =
                        COMPONENT_FRAME
                                + (((Component) v).getCoordinates().getX() * (COMPONENT_WIDTH + (0 * COMPONENT_FRAME)))
                                - (COMPONENT_WIDTH + (2 * COMPONENT_FRAME));

                int top =
                        COMPONENT_FRAME
                                + (((Component) v).getCoordinates().getY() * (COMPONENT_HEIGHT + (0 * COMPONENT_FRAME)))
                                - (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME));

                getChildAt(i).layout(
                        left - NODE_POINT_RADIUS,
                        top - NODE_POINT_RADIUS,
                        left + (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) + NODE_POINT_RADIUS,
                        top + (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) + NODE_POINT_RADIUS);
            }
        }
    }

    private void addAllComponentsY(int toIndex) {
        for (int i = 0; i < getChildCount(); i ++) {
            if (i >= toIndex) break;

            View v = getChildAt(i);

            if (v instanceof Component) {
                ((Component) v).getCoordinates().addY();

                int left =
                        COMPONENT_FRAME
                                + (((Component) v).getCoordinates().getX() * (COMPONENT_WIDTH + (0 * COMPONENT_FRAME)))
                                - (COMPONENT_WIDTH + (2 * COMPONENT_FRAME));

                int top =
                        COMPONENT_FRAME
                                + (((Component) v).getCoordinates().getY() * (COMPONENT_HEIGHT + (0 * COMPONENT_FRAME)))
                                - (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME));

                getChildAt(i).layout(
                        left - NODE_POINT_RADIUS,
                        top - NODE_POINT_RADIUS,
                        left + (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) + NODE_POINT_RADIUS,
                        top + (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) + NODE_POINT_RADIUS);
            }
        }
    }
}
