package pl.javastart.springvalidatorcustomconstraints.model;

import pl.javastart.springvalidatorcustomconstraints.common.Lang;
import pl.javastart.springvalidatorcustomconstraints.constraint.NotBadWord;

import javax.validation.constraints.NotNull;

public class Message {

    @NotNull
    String title;
    @NotBadWord(lang = {Lang.ENG,Lang.PL})
    String content;

    public Message() {
    }

    public Message(@NotNull String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
