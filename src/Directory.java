import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Directory {
    String name;
    Date dateCreated;
    List<File> filesList;
    List<Directory> subDirectories;

    public Directory(String name) {
        this.name = name;
        dateCreated = new Date();
        filesList = new LinkedList<>();
        subDirectories = new LinkedList<>();
    }

    //region Gettr and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getdateCreated() {
        return dateCreated;
    }

    public void setdateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<File> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<File> filesList) {
        this.filesList = filesList;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }

    public void setSubDirectories(List<Directory> subDirectories) {
        this.subDirectories = subDirectories;
    }
    //endregion

    void addFile(String fileName, int fileSize) {
        File fileToAdd = new File(fileName, fileSize);
        filesList.add(fileToAdd);
    }

    void addDir(String dirName) {
        Directory dirToAdd = new Directory(dirName);
        subDirectories.add(dirToAdd);
    }

    Directory getDirectoryByName(String dirName) {
        Directory dir = null;
        if (dirName.equals(name))
            dir = this;
        else {
            for (int i = 0; i < subDirectories.size(); i++) {
                dir = subDirectories.get(i).getDirectoryByName(dirName);
            }
        }
        return dir;
    }


    public Directory deleteDirectory(String toDelete) {
        for (int i = 0; i < filesList.size(); i++) // toDelete is a file
        {
            if (filesList.get(i).getName().equals(toDelete)) {
                filesList.remove(filesList.get(i));
                return null;
            }
        }

        for (int i = 0; i < subDirectories.size(); i++) {
            if (subDirectories.get(i).getName().equals(toDelete)) {
                subDirectories.remove(subDirectories.get(i));
                return this;
            }
        }

        for (int i = 0; i < subDirectories.size(); i++) {
            subDirectories.get(i).deleteDirectory(toDelete);
        }
        return null;
    }

    public void printStructure() {

        // print folders
        System.out.println("Directory name: " + name + ", Date created: " + dateCreated);
        System.out.print("Contains Files: ");
        if (filesList.size() == 0)
            System.out.println("No files");
        for (int i = 0; i < filesList.size(); i++) {
            filesList.get(i).printStructure();
            if (i < filesList.size() - 1)
                System.out.print(", ");
            if (i == filesList.size() - 1)
                System.out.println("");
        }

        // print sub directories list
        System.out.print("Contains Directories: ");
        if (subDirectories.size() == 0)
            System.out.println("No Sub Directories");
        for (int i = 0; i < subDirectories.size(); i++) {
            System.out.print(subDirectories.get(i).getName());
            if (i < subDirectories.size() - 1)
                System.out.print(", ");
            else
                System.out.println("");
        }

        // print sub directories
        for (int i = 0; i < subDirectories.size(); i++) {
            subDirectories.get(i).printStructure();
        }
    }

    public boolean isUniqueName(String name) {
        boolean isUnique = true;
        if (this.name.equals(name))
            isUnique = false;
        else {
            for(int j=0; j< filesList.size(); j++)
            {
                if(filesList.get(j).getName().equals(name)) {
                    isUnique = false;
                    break;
                }
            }
            for (int i = 0; i < subDirectories.size(); i++) {
                isUnique = subDirectories.get(i).isUniqueName(name);
                if(!isUnique)
                    break;
            }
        }
        return isUnique;
    }
}
