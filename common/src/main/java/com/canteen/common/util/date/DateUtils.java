package com.canteen.common.util.date;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Locale;

public class DateUtils {
    public enum DatePattern {
        YYYY_MM_DD("yyyy-MM-dd"), YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss");
        private String date;

        private DatePattern(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }
    }

    private static String getDate(Long time, DatePattern pattern) {
        return parseDate(time, pattern.toString());
    }


    /**
     * Set default locale as ZH_CN
     *
     * @param time
     * @param pattern
     * @return
     */
    private static String parseDate(Long time, String pattern) {
        return parseDate(time, pattern, Locale.CHINA);
    }

    private static String parseDate(Long time, String pattern, Locale locale) {
        return DateFormatUtils.format(time, pattern, locale);
    }


}
