package hr.mogh.problems.timeformatconversion;

/**
 * Converts time from one format to another.
 * Created by vlado on 2.12.2015.
 */
public class TimeFormatConverter {

    /**
     * Converts time from 12-hour format to 24-hour format.
     * @param time Time in HH:MM:SSAM/HH:MM:SSPM format.
     * @return Time in HH:MM:SS 24-hour format.
     */
    public static String convert12To24(String time) {
        if (time == null || time.length() == 0) {
            return null;
        }

        String[] splitTime = time.split(":");

        if (splitTime.length != 3) {
            return null;
        }

        boolean isPm = time.substring(time.length() - 2, time.length()).toUpperCase().equals("PM");
        int hours = Integer.valueOf(splitTime[0]);
        int convertedHours = hours;
        if (isPm) {
            if (hours < 12) {
                convertedHours = (hours + 12) % 24;
            }
        } else {
            convertedHours %= 12;
        }
        return String.format("%02d", convertedHours) + ":" + splitTime[1] + ":" + splitTime[2].substring(0,
                splitTime[2].length() - 2);
    }
}
