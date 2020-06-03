package com.daytoday.business.dailydelivery.MainHomeScreen.UI;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;

import androidx.core.content.ContextCompat;

import com.daytoday.business.dailydelivery.MainHomeScreen.Model.Dates;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CircleDecorator implements DayViewDecorator {

    private HashSet<Dates> dates;
    private Drawable drawable;

    public CircleDecorator(Context context, int resId, Collection<Dates> dates) {
        drawable = ContextCompat.getDrawable(context, resId);
        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day)
    {
        Iterator iterator = dates.iterator();
        while (iterator.hasNext())
        {
            Dates norDay = (Dates)iterator.next();
            if (day.equals( norDay.getDay()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.WHITE));
        view.setSelectionDrawable(drawable);
    }
}