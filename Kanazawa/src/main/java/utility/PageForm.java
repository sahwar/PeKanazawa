package utility;

import org.springframework.data.domain.Page;

public class PageForm<T> {
    private Page<T> pages;
    private int current;
    private int begin;
    private int end;
    private String path;

    public PageForm(Page<T> pageList, String path) {
        this.pages = pageList;
        this.current = pageList.getNumber() + 1;
        this.begin = Math.max(1, current - 5);
        this.end = Math.min(begin + 10, pageList.getTotalPages());
        this.path = path;
    }

    public Page<T> getPages() {
        return pages;
    }

    public int getCurrent() {
        return current;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public String getPath() {
        return path;
    }

}
