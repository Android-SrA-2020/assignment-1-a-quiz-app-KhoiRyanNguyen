package work.nbcc.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val listQuestion = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    private var questionIndex = 0;



    lateinit var txt_Question: TextView
    lateinit var btn_False : Button
    lateinit var btn_True : TextView
    lateinit var btn_Previous : TextView
    lateinit var btn_Next : TextView
    var QuestionList : MutableList<Question> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        txt_Question = findViewById(R.id.txt_Question)
        btn_False = findViewById(R.id.btn_False)
        btn_True = findViewById(R.id.btn_True)
        btn_Previous = findViewById(R.id.btnPrevious)
        btn_Next = findViewById(R.id.btn_Next)
        txt_Question.setText(getString(R.string.question_1))
        btn_Next.setOnClickListener { Next() };
        btn_Previous.setOnClickListener { Previous() }
        btn_True.setOnClickListener { answer(true) }
        btn_False.setOnClickListener { answer(false) }
    }

    private fun Next() {
        
        questionIndex = (questionIndex + 1) % listQuestion.size;
        updateView();

    }

    private fun Previous() {
        questionIndex = if (questionIndex == 0) {
            listQuestion.size - 1;
        } else {
            (questionIndex - 1) % listQuestion.size;
        }

        updateView();
    }
    private fun answer(ans: Boolean) {
        if (ans == true && ans == listQuestion[questionIndex].answer) {
            Toast.makeText(applicationContext, "You are right", Toast.LENGTH_SHORT).show();
        } else if (ans == false && ans == listQuestion[questionIndex].answer) {
            Toast.makeText(applicationContext, "You are right", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(applicationContext, "You are wrong", Toast.LENGTH_SHORT).show();
        }
    }



    private fun updateView() {
        findViewById<TextView>(R.id.txt_Question).setText(listQuestion[questionIndex].resourceId);
    }



}
