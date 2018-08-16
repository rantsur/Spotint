import java.util.Date;

public class File {
    String name;
    int size;
    Date dateCreated;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
        dateCreated = new Date();
    }

    //region Getter and Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setdateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {

        return name;
    }

    public int getSize() {
        return size;
    }

    public Date getdateCreated() {
        return dateCreated;
    }
    //endregion

    public void printStructure() {
        System.out.print(name + " Size: " + size + " Date created: " + dateCreated);
    }
}
