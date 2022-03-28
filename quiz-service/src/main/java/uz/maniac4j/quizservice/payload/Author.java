package uz.maniac4j.quizservice.payload;

public class Author {
    private static final String name="Mahmud Salomov";
    private static final String telegram="@complexio";
    private static final String facebook="https://www.facebook.com/mahmud.salomov";
    private static final String linkedin="https://www.linkedin.com/in/mahmudsalomov/";
    private static final String github="https://github.com/mahmudsalomov";



    public String getName() {
        return name;
    }

    public String getTelegram() {
        return telegram;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getGithub() {
        return github;
    }
}
