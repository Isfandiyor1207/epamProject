package epam.project.bookshop.command;

public class Router {
    private String page;
    private Type type= Type.FORWARD;

    enum Type{
        FORWARD,
        REDIRECT;
    }

    public Router(String page) {
        this.page = page;
    }

    public Router(String page, Type type) {
        this.page = page;
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setRedirect(Type type) {
        this.type = Type.REDIRECT;
    }
}
