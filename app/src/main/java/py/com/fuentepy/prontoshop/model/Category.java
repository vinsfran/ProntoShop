package py.com.fuentepy.prontoshop.model;

/**
 * Created by vinsfran on 08/08/17.
 */
public class Category {
    private long id;
    private String categoryName;

    public Category(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
