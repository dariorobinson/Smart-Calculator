import java.util.Scanner;

class Publication {

    protected String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        // write your code here
        return getType() + getDetails();
    }

    public String getType() {
        return "Publication: ";
    }

    public String getDetails() {
        return title;
    }

}

class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    @Override
    public String getType() {
        return "Newspaper";
    }

    @Override
    public String getDetails() {
        return " (source - " + source + "): " + this.title;
    }

}

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String getType() {
        return "Article";
    }
    @Override
    public String getDetails() {
        return " (author - " + author + "): " + this.title;
    }
}

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String getType() {
        return "Announcement";
    }

    @Override
    public String getDetails() {
        return " (days to expire - " + daysToExpire + "): " + this.title;
    }
}

class MainMeth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] arr = input.split("; ");

        if(arr[0].equals("Publication")) {
            Publication pub = new Publication(arr[1]);
            System.out.println(pub.getInfo());
        } else if (arr[0].equals("Newspaper")) {
            Newspaper news = new Newspaper(arr[1], arr[2]);
            System.out.println(news.getInfo());
        } else if (arr[0].equals("Article")) {
            Article art = new Article(arr[1], arr[2]);
            System.out.println(art.getInfo());
        } else if (arr[0].equals("Announcement")) {
            Announcement ann = new Announcement(arr[1], Integer.parseInt(arr[2]));
            System.out.println(ann.getInfo());
        }


    }
}