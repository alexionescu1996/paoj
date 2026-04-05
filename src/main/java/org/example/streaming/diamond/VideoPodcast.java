package org.example.streaming.diamond;

/**
 * PROBLEMA ROMBULUI (Diamond Problem):
 *
 * VideoPodcast implementeaza AMBELE interfete: Audible si Visual.
 * Ambele au "default String prepare()" -> CONFLICT!
 *
 * Solutie: VideoPodcast TREBUIE sa suprascrie prepare() explicit.
 * Daca nu o face -> eroare de compilare!
 *
 * In interiorul suprascrierii, poate apela oricare varianta:
 *   - Audible.super.prepare()
 *   - Visual.super.prepare()
 *   - sau implementare complet noua
 */
public class VideoPodcast implements Audible, Visual {
    private String title;
    private String host;

    public VideoPodcast(String title, String host) {
        this.title = title;
        this.host = host;
    }

    @Override
    public String getTitle() {
        return title;
    }

    /**
     * OBLIGATORIU: trebuie sa suprascriem prepare() deoarece
     * exista conflict intre Audible.prepare() si Visual.prepare().
     *
     * Putem apela ambele variante prin InterfaceName.super.metoda()
     */
    @Override
    public String prepare() {
        // Apelam AMBELE implementari din interfete
        String audioPrep = Audible.super.prepare();
        String videoPrep = Visual.super.prepare();
        return "=== VideoPodcast se pregateste pe ambele canale ===\n"
                + "  [Audio]  " + audioPrep + "\n"
                + "  [Video]  " + videoPrep;
    }

    // playAudio() vine din Audible - fara conflict
    // playVideo() vine din Visual - fara conflict
}
