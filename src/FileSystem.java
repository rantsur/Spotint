import java.util.LinkedList;
import java.util.List;

public class FileSystem {
    List<Directory> fileSystemList;

    public FileSystem() {
        fileSystemList = new LinkedList<>();
    }

    void addFile(String parentDirName, String fileName, int fileSize) {
        Directory dirToAdd;
        if (!checkLegalFile(fileName, fileSize) || !parentDirName.matches(".*[a-zA-Z]+.*"))
            System.out.println("The file '" + fileName + "' is illegal.");
        else if ((parentDirName == null || isUniqueName(parentDirName)))
            System.out.println("The directory '" + parentDirName + "' doesn't exist.");
        else {
            dirToAdd = getDirectoryByName(parentDirName);
            dirToAdd.addFile(fileName, fileSize);
        }
    }

    private boolean checkLegalFile(String fileName, int fileSize) {
        if (fileSize <= 0)
            return false;
        if (fileName == null || !fileName.matches(".*[a-zA-Z]+.*") || fileName.length() > 32)
            return false;
        if (!isUniqueName(fileName))
            return false;
        return true;
    }

    private boolean isUniqueName(String name) {
        boolean isUnique;
        for (int i = 0; i < fileSystemList.size(); i++) {
            isUnique = fileSystemList.get(i).isUniqueName(name);
            if (!isUnique)
                return false;
        }
        return true;
    }

    void addDir(String parentDirName, String dirName) {
        Directory dirToAdd;
        if (parentDirName == "") // parent directory is the main directory
        {
            dirToAdd = new Directory(dirName);
            this.fileSystemList.add(dirToAdd);
            return;
        }
        if (dirName != null && dirName.length() < 32 && isUniqueName(dirName) && parentDirName != null) {
            dirToAdd = getDirectoryByName(parentDirName);
            if(dirToAdd != null)
                dirToAdd.addDir(dirName);
            else
                System.out.println("The directory '" + parentDirName + "' doesn't exist.");
        } else
            System.out.println("The directory '" + dirName + "' is illegal.");
    }

    private Directory getDirectoryByName(String parentDirName) {
        Directory dir;
        for (int i = 0; i < fileSystemList.size(); i++) {
            dir = fileSystemList.get(i).getDirectoryByName(parentDirName);
            if (dir != null)
                return dir;
        }
        return null;
    }

    void delete(String name) {
        if(name == null)
            return;
        for (int i = 0; i < fileSystemList.size(); i++) {
            if (fileSystemList.get(i).getName().equals(name))
                fileSystemList.remove(fileSystemList.get(i));
        }
        for (int i = 0; i < fileSystemList.size(); i++) {
            fileSystemList.get(i).deleteDirectory(name);
        }
    }

    void showFileSystem() {
        for (int i = 0; i < fileSystemList.size(); i++) {
            fileSystemList.get(i).printStructure();
        }
    }
}
