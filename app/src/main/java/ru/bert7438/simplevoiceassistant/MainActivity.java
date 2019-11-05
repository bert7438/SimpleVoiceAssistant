package ru.bert7438.simplevoiceassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView chatView;
    private EditText questionText;
    private Button sendButton;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatView = findViewById(R.id.сhatView);
        questionText = findViewById(R.id.questionText);
        sendButton = findViewById(R.id.sendButton);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status!= TextToSpeech.ERROR){
                    tts.setLanguage(new Locale("ru"));

                }
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //при нажатии на кнопку
                String question = questionText.getText().toString();
                questionText.setText("");
                //ЗДЕСЬ ДОЛЖЕН БЫТЬ ИИ
                String answer = AI.qetAnswer(question);//TODO AI

                chatView.append("\n >>" + question);
                tts.speak(answer, TextToSpeech.QUEUE_FLUSH, null);
                chatView.append("\n <<" + answer);
            }
        });
    }
}
