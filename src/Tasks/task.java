package Tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class task {
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private String nameTask;
	private String task;
	private LocalDate date;
	private Integer id;

	public task(String nameTask, String task, LocalDate date, Integer id) {
		this.task = task;
		this.date = date;
		this.nameTask = nameTask;
		this.id = id + 1;
	}

	public String getNameTask() {
		return nameTask;
	}

	public void setNameTask(String nameTask) {
		this.nameTask = nameTask;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	

	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\nNome: " + this.getNameTask() + "\nDescrição: " + this.getTask() + "\nData: " + fmt.format(date) + "\nId: " + this.getId() + "\n-----\n";
	}

}
