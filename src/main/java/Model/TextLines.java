package Model;

/**
 *
 * @author marcos-medeiros
 */
public class TextLines {
    private int groupId;
    private String file;
    private int line;
    private String text;

    public TextLines(int groupId, String file, int line, String text) {
        this.groupId = groupId;
        this.file = file;
        this.line = line;
        this.text = text;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
