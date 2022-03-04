package Task;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {
    private int id;
    private String name;
    private String content;
    LocalDateTime createDate;


    public Task(String name, String content, LocalDateTime createDate) {
        this.id = this.id + 1;
        this.name = name;
        this.content = content;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }


    public boolean isContentValid(String content) {
        return content.length() < 1000 && content.length() > 0;
    }

    public boolean isThirtyMinutesOver(LocalDateTime createDate) {
        if(this.createDate.getDayOfMonth() != createDate.getDayOfMonth()) return true;
        else if(this.createDate.getMinute() - createDate.getMinute() >= 30 && this.createDate.getHour() == createDate.getHour()) return true;
        else if(this.createDate.getMonth() != createDate.getMonth()) return true;
        else if(this.createDate.getMinute() <= createDate.getMinute() && this.createDate.getHour() != createDate.getHour())return true;
        else if(this.createDate.getMinute() >= createDate.getMinute() && this.createDate.getHour() != createDate.getHour() ){
            int i = 0;
            i = this.createDate.getMinute()-createDate.getMinute();
            i = 60 - i;
            return i >= 30;
        }
        return false;
    }
    public boolean isTaskValid(ArrayList<Task> listTask) {
        if(isContentValid(this.getContent()) && listTask.size() < 10) {
            return true;
        }
        return false;
    }
    public boolean EmailSenderService() {
        System.out.println("Il ne vous reste plus que 2 tâches!");
        return true;
    }
}
