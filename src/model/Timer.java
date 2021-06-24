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
/*
*  int m = -1, s = -1;
                try {
                    m = Integer.parseInt(min.getText());
                    s = Integer.parseInt(sec.getText());
                } catch (NumberFormatException ex) {
                    min.setText(ex.getMessage());
                } catch (NullPointerException ex) {
                    sec.setText(ex.getMessage());
                }
                model.Timer timer = new model.Timer(m, s);
                int sum = timer.getMinutes() * 60 + timer.getSeconds();
                for (int i = 0; i < sum + 1; i++) {
                    if (i == 0) {
                        min.setText(Integer.toString(timer.getMinutes()));
                        sec.setText(Integer.toString(timer.getSeconds()));
                    } else {
                        System.out.println(timer.decreaseOneSecond());//talisa -1 varykan arajva String-y
                        min.setText(Integer.toString(timer.getMinutes()));
                        sec.setText(Integer.toString(timer.getSeconds()));
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        min.setText(ex.getMessage());
                    }
                }*/