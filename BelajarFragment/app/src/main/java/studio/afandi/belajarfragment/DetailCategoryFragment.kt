package studio.afandi.belajarfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class DetailCategoryFragment : Fragment() {

    lateinit var btnShowDialog: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
        btnShowDialog.setOnClickListener {
            val mOpenDialogFragment = OpenDialogFragment()

            val mFragmentManager = childFragmentManager
            mOpenDialogFragment.show(mFragmentManager, OpenDialogFragment::class.java.simpleName)
        }
    }

    internal var optionDialogListener: OpenDialogFragment.OnOptionDialogListener = object : OpenDialogFragment.OnOptionDialogListener{
        override fun onOptionChosen(text: String?) {
            Toast.makeText(activity, "Anda Memilih : "+text, Toast.LENGTH_SHORT).show()
        }
    }

}