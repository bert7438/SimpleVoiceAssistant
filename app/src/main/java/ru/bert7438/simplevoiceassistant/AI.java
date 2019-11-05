package ru.bert7438.simplevoiceassistant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AI {
    public static String qetAnswer(String question){
        ArrayList<String> answer = new ArrayList<String>();
        question = question.toLowerCase();
        switch (question){
            case "сколько времени":
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                String time = timeFormat.format(new Date());
                answer.add("Время:" + time + " ,вот");
                break;
            default:
                answer.add("Каво?");

        }
        if (answer.size()> 0)
            return String.join(",", answer);
        else return "Не понял";
    }
}
