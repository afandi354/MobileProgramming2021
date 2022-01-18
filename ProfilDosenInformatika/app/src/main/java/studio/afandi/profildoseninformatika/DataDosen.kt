package studio.afandi.profildoseninformatika

object DataDosen {

    private val lecturerImages = intArrayOf(
        R.drawable.kamto,
        R.drawable.kurnianingsih,
        R.drawable.parsumo,
        R.drawable.mardi,
        R.drawable.yudan,
        R.drawable.handoko,
        R.drawable.idha,
        R.drawable.liliek,
        R.drawable.irwan
    )


    private val lecturerNames = arrayOf(
        "Sukamto, S.Kom., M.T",
        "Dr. Kurnianingsih, M.T",
        "Drs. Parsumo Raharjo, M.Kom",
        "Mardiyono, S.Kom., M.Sc",
        "T R Yudantoro, M.Kom",
        "Slamet Handoko, M.Kom ",
        "Idhawati Hestiningsih, M.Kom",
        "Liliek Triyono, S.T., M.Kom",
        "M Irwan Yanwari, S.Kom., M.Eng"
    )

    private val lecturerDetails = arrayOf(
        "Bidang Keahlian adalah mobile development, dan database programming",
        "Bidang Keahlian adalah Kecerdasan buatan, Pembelajaran Mesin, dan Visi Komputer",
        "Bidang Keahlian adalah Jaringan Komputer, dan Virtualisasi",
        "Bidang Keahlian adalah Kecerdasan Buatan, dan Internet of Things",
        "Bidang Keahlian adalah Rekayasa Perangkat Lunak, dan Jaringan komputer",
        "Bidang Keahlian adalah Database Programming, dan Visualisasi Data",
        "Bidang Keahlian adalah Pemrograman Berorientasi Objek, dan Mobile Development",
        "Bidang Keahlian adalah Kecerdasan Buatan, dan Mobile Development",
        "Bidang Keahlian adalah Web Development, dan Desain Grafis",
        "Bidang Keahlian adalah Web Development, Game Development, dan Desain Grafis"
    )

    val listData: ArrayList<Dosen>
        get() {
            val list = arrayListOf<Dosen>()
            for (position in lecturerNames.indices) {
                val dosen = Dosen()
                dosen.name = lecturerNames[position]
                dosen.photo = lecturerImages[position]
                dosen.detail = lecturerDetails[position]
                list.add(dosen)
            }
            return list
        }


}