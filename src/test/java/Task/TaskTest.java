package Task;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskTest {

    private Task task;
    private Task task2;
    private Task task3;
    private final ArrayList<Task> listTask = new ArrayList<Task>();

    @Before
    public void init(){
        this.task = new Task( "Test", "contenu testé et validé", LocalDateTime.now());
        this.task2 = new Task( "Test", "", LocalDateTime.now());
        this.task3 = new Task("Test", "", LocalDateTime.now());
    }

    @Test
    public void isContentValid() {
        Assert.assertTrue(this.task.isContentValid(this.task.getContent()));    }

    @Test
    public void isTimeTrue() {
        LocalDateTime createDate = this.task.getCreateDate().minusMinutes(30);
        Assert.assertTrue(this.task.isThirtyMinutesOver(createDate));
    }

    @Test
    public void isTimeFalse() {
        LocalDateTime createDate = this.task2.getCreateDate().minusMinutes(10);
        Assert.assertFalse(this.task2.isThirtyMinutesOver(createDate));
    }

    @Test
    public void isTimeHourTrue() {
        LocalDateTime dateTime = this.task3.getCreateDate().minusHours(1);
        Assert.assertTrue(this.task.isThirtyMinutesOver(dateTime));
    }

    @Test
    public void insertItemsFalse() {
        LocalDateTime createDate = this.task.getCreateDate().minusMinutes(10);
        Assert.assertFalse(this.task.isThirtyMinutesOver(createDate) && this.task.isTaskValid(this.listTask));
    }

    @Test
    public void getTenItems() {
        LocalDateTime createDate = this.task.getCreateDate().minusMinutes(30);
        for(int i = 0; i < 10; i++) {
            if(this.task.isThirtyMinutesOver(createDate) && this.task.isTaskValid(this.listTask)) {
                Assert.assertTrue(this.listTask.add(task));
            }
        }

        Assert.assertTrue(this.listTask.size() <= 10);
    }
    @Test
    public void moreTenItems() {
        LocalDateTime createDate = this.task.getCreateDate().minusMinutes(30);
        for(int i = 0; i < 15; i++) {
            if(this.task.isThirtyMinutesOver(createDate) && this.task.isTaskValid(this.listTask)) {
                this.listTask.add(task);
            }
        }

        Assert.assertFalse(this.task.isThirtyMinutesOver(createDate) && this.task.isTaskValid(this.listTask));
    }

    @Test
    public void testSendMail() {
        if(this.listTask.size() > 8) {
            Assert.assertTrue(this.task.EmailSenderService());
        }
    }
}
