package za.ac.iie.myhistoryapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Names of dead people and history
    val namesOfDeadPoeple = arrayOf<String>(
        "John Lennon was born on October 9 1940 in Liverpool England to Julia Lennon and Alfred Lennon< a merchant Seaman",
        "Michael Jackson was born on August 29, 1958 in Gary, Indiana, and entertained audience his whole life. He died due to a drug overdose",
        "Kurt Cobain was born on February 20 1967, in Aberdeen, washington. Kurt and his family lived in Hoquiam for the first few months of his life then later moved back to Adedeen",
        " Princess Diana was a member of the british royal family. She was the first wife of charles, prince of wales. he died in a car accident",
        " Bruce Lee Remains the greatest icon in Martial arts cinema and a key figure of modern popular media",
        "Robin McLaurin Williams was born on Saturday, July 21st, 1951, in chicago, illlinois, a great-great-grandson of mississippi governor and senator, anselm J. McLaurin. ",
        "Steve Jobs was born on the 24th of February 1955 in San Francisco, California to students Abdul Fattah Jandali and Joanne Carol, died of Pancreatic Cancer",
        " Tupac Shakur was Born in new york, tupac grew up primarily in harlem. in 1984, his family moved to a different city",
        "isaac hayes is the second born child of eula and isaac hayes sr., isaac hayes was raised by his grandparents",
        "vincent van gogh is a painter sufferent from depression and then later on killed himself",
        // https://www.imdb.com

    )

    // the ages of the dead people
    var agesOfDeadPeople = intArrayOf(
        40,
        50,
        27,
        36,
        32,
        63,
        56,
        25,
        65,
        37,

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //declarations of the textView
        val txtHeading = findViewById<TextView>(R.id.txtHeading)
        val txtDeadPeople = findViewById<TextView>(R.id.txtDeadPeople)
        val txtEnterAge = findViewById<TextView>(R.id.txtEnterAge)
        //delration of the edit text
        val txtAge = findViewById<EditText>(R.id.txtAge)
        //declarations of the buttons
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val btnClear = findViewById<Button>(R.id.btncClear)

        //now we want to generate the age using the button
        btnGenerate.setOnClickListener {
            val ageEntered = txtAge.text.toString().toIntOrNull()
            if (ageEntered != null) // this is when the age is not equal to zero. here we are initialising
            if (ageEntered in 23..70){ //the age entered must be correct
                val index = agesOfDeadPeople.indexOf(ageEntered)
                if ( index != 0 && index < namesOfDeadPoeple.size ) {
                    val name = namesOfDeadPoeple[index]
                    txtDeadPeople.text = "the individual that died at the age, $name, is $ageEntered"

                } else {
                    txtDeadPeople.text = "no one died at this age, $ageEntered"
                }
            }

            else {
                txtDeadPeople.text = "you have entered the wrong age, please enter the correct one"
            }

        }

        // we are adding the clear button to clear everything
         btnClear.setOnClickListener {
             txtAge.text.clear()
             txtDeadPeople.text = ""
         }
        

    }
}