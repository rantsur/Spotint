import java.util.LinkedList;
import java.util.List;

public class FileSystem {
    List<Directory> fileSystemList;

    public FileSystem() {
        fileSystemList = new LinkedList<>();
    }

    void addFile(String parentDirName, String fileName, int fileSize) {
        Directory dirToAdd = getDirectoryByName(parentDirName);
        dirToAdd.addFile(fileName, fileSize);
    }

    void addDir(String parentDirName, String dirName) {
        Directory dirToAdd = getDirectoryByName(parentDirName);
        if (dirToAdd == null) {
            dirToAdd = new Directory(dirName);
            this.fileSystemList.add(dirToAdd);
        } else
            dirToAdd.addDir(dirName);
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
