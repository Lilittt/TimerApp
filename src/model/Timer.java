package model;

import common.exceptions.InvalidTimeException;

public class Timer {
    private int minutes = 0;
    private int seconds = 0;

    public String decreaseOneSecond() throws InvalidTimeException {
        if (seconds > 0 && seconds < 60)
            return new Timer(minutes, --seconds).toString();

        if (minutes > 0) {
            if (seconds == 0) {
                --minutes;
                seconds = 59;
                return new Timer(minutes, seconds).toString();
            }
        }
        throw new InvalidTimeException();
    }

    public Timer decreaseOneSecondTimer() {
        String[] split = decreaseOneSecond().split(":");
        minutes = Integer.parseInt(split[0]);
        seconds = Integer.parseInt(split[1]);
        return new Timer(minutes, seconds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (minutes >= 0 && minutes <= 9)
            sb.append("0");
        sb.append(minutes).append(":");
        if (seconds >= 0 && seconds <= 9)
            sb.append("0");
        sb.append(seconds);
        return sb.toString();
    }

    public Timer(int minutes, int seconds) {
        if (minutes >= 0 && minutes <= 60 && seconds >= 0 && seconds < 60) {
            this.minutes = minutes;
            this.seconds = seconds;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
