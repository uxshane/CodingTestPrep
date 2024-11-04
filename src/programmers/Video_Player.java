package programmers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Video_Player {

    static LocalTime videoTime;
    static LocalTime posTime;
    static LocalTime opStartTime;
    static LocalTime opEndTime;

    public static void main(String[] args) {

        System.out.println(
                solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(
                solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
        System.out.println(solution("30:00", "29:55", "01:00", "01:30", new String[]{"next"}));
    }


    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        videoTime = getTime(video_len.split(":"));
        posTime = getTime(pos.split(":"));
        opStartTime = getTime(op_start.split(":"));
        opEndTime = getTime(op_end.split(":"));

        skipOpening();

        for (String command : commands) {
            if(command.equals("prev")) {
                prev();
            } else {
                next();
            }
            skipOpening();
        }

        return posTime.format(DateTimeFormatter.ofPattern("mm:ss"));
    }

    private static void next() {
        posTime = posTime.plusSeconds(10);
        if(posTime.isAfter(videoTime)) posTime = videoTime;
    }

    private static void prev() {
        posTime = posTime.minusSeconds(10);
        if(posTime.isAfter(LocalTime.of(23, 59, 50))) {
            posTime = LocalTime.of(0, 0, 0);
        }
    }

    private static void skipOpening() {
        if(posTime.isBefore(opEndTime) && posTime.isAfter(opStartTime)) {
            posTime = opEndTime;
        }
    }

    private static LocalTime getTime(String[] split) {
        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);

        return LocalTime.of(0, min, sec);
    }

}
