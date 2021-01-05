package com.daytoday.business.dailydelivery.MainHomeScreen.UI;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;

import androidx.core.content.ContextCompat;

import com.daytoday.business.dailydelivery.Network.Response.Transaction;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

public class CircleDecorator implements DayViewDecorator {

    private Drawable drawable;
    private Transaction tempDay;

    public CircleDecorator(Context context, int resId, Transaction transaction) {
        drawable = ContextCompat.getDrawable(context, resId);
        this.tempDay = transaction;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        //TODO need to check if getYear() etc. are number or not
        CalendarDay calendarDay = CalendarDay.from(Integer.parseInt(tempDay.getYear()),Integer.parseInt(tempDay.getMon()),Integer.parseInt(tempDay.getDay()));
        if (calendarDay.equals(day)) return true;
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.WHITE));
        view.setSelectionDrawable(drawable);
    }
}