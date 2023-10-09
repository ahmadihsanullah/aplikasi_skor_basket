package bagicode.aplikasi_skor_basket

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InputTim.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputTim : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var inputTimAEditText : EditText
    private lateinit var inputTimBEditText : EditText
    private lateinit var mulaiButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            inputTimAEditText = view?.findViewById(R.id.inputTimAEditText)!!
            inputTimBEditText = view?.findViewById(R.id.inputTimBEditText)!!

            mulaiButton = view?.findViewById(R.id.mulaiButton)!!
            mulaiButton.setOnClickListener(this)
        }


    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.mulaiButton-> {
                val bundle: Bundle = Bundle()
                bundle.putString("timA", inputTimAEditText.text.toString())
                bundle.putString("timB", inputTimBEditText.text.toString())

//                val intent: Intent = Intent(requireContext(), HitungSkor::class.java)
//                intent.putExtras(bundle)
//                startActivity(intent)

                val hasilFragment = HitungSkor() // Ganti dengan fragment yang sesuai
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainer, hasilFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_tim, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InputTim.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InputTim().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}